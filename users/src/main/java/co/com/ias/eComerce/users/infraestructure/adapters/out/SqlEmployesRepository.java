package co.com.ias.eComerce.users.infraestructure.adapters.out;

import co.com.ias.eComerce.commons.NonEmptyString;
import co.com.ias.eComerce.users.application.domain.Employe;
import co.com.ias.eComerce.users.application.domain.IdentificationNumber;
import co.com.ias.eComerce.users.application.ports.out.EmployeRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

@Repository("sql")
public class SqlEmployesRepository implements EmployeRepository {
    private final JdbcTemplate jdbcTemplate;

    public SqlEmployesRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Employe> employeRowMapper = (rs, rowNum) -> fromResultSet(rs);

    @Override
    public Optional<Employe> getEmployeById(IdentificationNumber identificationNumber) {
        final String sql = "SELECT * FROM EMPLOYE WHERE ID_NUMBER = ?";
        PreparedStatementSetter preparedStatementSetter = ps -> {
            ps.setString(1, identificationNumber.getValue());
        };
        final ResultSetExtractor<Optional<Employe>> resultSetExtractor = rs -> {
            if (rs.next()) {
                final Employe employe = fromResultSet(rs);
                return Optional.of(employe);
            } else {
                return Optional.empty();
            }
        };

        return jdbcTemplate.query(sql, preparedStatementSetter, resultSetExtractor);
    }

    @Override
    public void storeEmploye(Employe employe) {
        jdbcTemplate.update(connection -> {
            final PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO EMPLOYE (ID_NUMBER, ID_TYPE, NAME, LAST_NAME) VALUES (?, ?, ?, ?)");

            preparedStatement.setString(1, employe.getIdNumber().getValue());
           // preparedStatement.setString(2, employe.getIdentificationType().name());
            preparedStatement.setString(2, employe.getName().getValue());
            preparedStatement.setString(3, employe.getLastName().getValue());

            return preparedStatement;
        });
    }

    @Override
    public Collection<Employe> listEmployes(int limit, int skip) {
        final String sql = "SELECT * FROM EMPLOYE LIMIT ? OFFSET ?";
        return jdbcTemplate.query(sql, employeRowMapper, limit, skip);
    }


    private static Employe fromResultSet(ResultSet rs) throws SQLException {
        return  Employe.parseEmploye(
                rs.getString("ID_NUMBER"),
                rs.getString("NAME"),
                rs.getString("LAST_NAME")

        ).get();
    }
}
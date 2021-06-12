package co.com.ias.eComerce.productos.infraestructure.adapters.out;

import co.com.ias.eComerce.productos.application.domain.Product;
import co.com.ias.eComerce.productos.application.domain.ProductId;
import co.com.ias.eComerce.productos.application.ports.out.ProductsRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

public class SqlProductsRepository implements ProductsRepository {
    private final JdbcTemplate jdbcTemplate;

    public SqlProductsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Product> productRowMapper = (rs, rowNum) -> fromResultSet(rs);

    @Override
    public Optional<Product> getProductById(ProductId productId) {
        final String sql = "SELECT * FROM STUDENTS WHERE ID_NUMBER = ?";
        PreparedStatementSetter preparedStatementSetter = ps -> {
            ps.setString(1, productId.getValue());
        };
        final ResultSetExtractor<Optional<Product>> resultSetExtractor = rs -> {
            if (rs.next()) {
                final Product product = fromResultSet(rs);
                return Optional.of(product);
            } else {
                return Optional.empty();
            }
        };

        return jdbcTemplate.query(sql, preparedStatementSetter, resultSetExtractor);
    }

    @Override
    public void storeProduct(Product product) {
        jdbcTemplate.update(connection -> {
            final PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO PRODUCTS (ID_NUMBER, ID_TYPE, NAME, LAST_NAME) VALUES (?, ?, ?, ?)");

            preparedStatement.setString(1, product.getIdProduct().getValue());
            preparedStatement.setString(2, product.getName().getValue());
            preparedStatement.setString(3, product.getDescription().getValue());
            preparedStatement.setString(4, product.getBasePrice().getValue());
            preparedStatement.setString(4, product.getTaxRate().getValue());
            preparedStatement.setString(4, product.getProductStatus().name());
            preparedStatement.setString(4, product.getInventoryQuantity().getValue());

            return preparedStatement;
        });
    }

    @Override
    public Collection<Product> listProducts(int limit, int skip) {
        final String sql = "SELECT * FROM PRODUCTS LIMIT ? OFFSET ?";
        return jdbcTemplate.query(sql, productRowMapper, limit, skip);
    }

    @Override
    public Integer countProducts() {
        String sql = "select count(*) from STUDENTS";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }


    private static Product fromResultSet(ResultSet rs) throws SQLException {
        return Product.parseProduct(
                rs.getString("PRODUCTID"),
                rs.getString("NAME"),
                rs.getString("DESCRIPTION"),
                rs.getString("BASE PRICE"),
                rs.getString("TAX RATE"),
                rs.getString("PRODUCT STATUS"),
                rs.getString("INVENTORY QUANTITY")

                ).get();
    }
}

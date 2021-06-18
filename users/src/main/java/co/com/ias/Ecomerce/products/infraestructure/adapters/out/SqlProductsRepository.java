package co.com.ias.Ecomerce.products.infraestructure.adapters.out;

import co.com.ias.Ecomerce.commons.IdentificationNumber;
import co.com.ias.Ecomerce.products.application.domain.Product;
import co.com.ias.Ecomerce.products.application.ports.out.ProductsRepository;
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
@Repository("productSql")
public class SqlProductsRepository implements ProductsRepository {
    private final JdbcTemplate jdbcTemplate;

    public SqlProductsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Product> productRowMapper = (rs, rowNum) -> fromResultSet(rs);

    @Override
    public Optional<Product> getProductById(IdentificationNumber productId) {
        final String sql = "SELECT * FROM PRODUCT WHERE ID_NUMBER = ?";
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
                    .prepareStatement("INSERT INTO PRODUCT (ID_PRODUCT, NAME, DESCRIPTION,BASEPRICE,TAXRATE,PRODUCTSTATUS,INVENTORYQUANTITY) VALUES (?, ?, ?, ?,?,?,?)");

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
        final String sql = "SELECT * FROM PRODUCT LIMIT ? OFFSET ?";
        return jdbcTemplate.query(sql, productRowMapper, limit, skip);
    }

    @Override
    public Integer countProducts() {
        String sql = "select count(*) from PRODUCT";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }



    private static Product fromResultSet(ResultSet rs) throws SQLException {
        return Product.parseProduct(
                rs.getString("NAME"),
                rs.getString("DESCRIPTION"),
                rs.getString("BASE PRICE"),
                rs.getString("TAX RATE"),
                rs.getString("PRODUCT STATUS"),
                rs.getString("INVENTORY QUANTITY"),
                rs.getString("PRODUCTID")

                ).get();
    }
}

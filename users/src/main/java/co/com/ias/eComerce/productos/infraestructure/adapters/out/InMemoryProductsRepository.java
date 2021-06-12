package co.com.ias.eComerce.productos.infraestructure.adapters.out;

import co.com.ias.eComerce.productos.application.domain.Product;
import co.com.ias.eComerce.productos.application.domain.ProductId;
import co.com.ias.eComerce.productos.application.ports.out.ProductsRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryProductsRepository implements ProductsRepository {
    @Override
    public Optional<Product> getProductById(ProductId productId) {
        return Optional.empty();
    }

    @Override
    public void storeProduct(Product product) {
        database.put(product.getIdProduct(), product);

    }

    @Override
    public Collection<Product> listProducts(int limit, int skip) {
        return database.values();
    }

    @Override
    public Integer countProducts() {
        return database.size();
    }

    private final Map<ProductId, Product> database = new HashMap<>();

}

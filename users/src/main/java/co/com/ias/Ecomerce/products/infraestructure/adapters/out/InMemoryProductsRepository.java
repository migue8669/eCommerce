package co.com.ias.Ecomerce.products.infraestructure.adapters.out;

import co.com.ias.Ecomerce.commons.IdentificationNumber;
import co.com.ias.Ecomerce.products.application.domain.Product;
import co.com.ias.Ecomerce.products.application.ports.out.ProductsRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryProductsRepository implements ProductsRepository {
    @Override
    public Optional<Product> getProductById(IdentificationNumber productId) {
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

    private final Map<IdentificationNumber, Product> database = new HashMap<>();

}

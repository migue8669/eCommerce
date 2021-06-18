package co.com.ias.Ecomerce.products.application.ports.out;

import co.com.ias.Ecomerce.commons.IdentificationNumber;
import co.com.ias.Ecomerce.products.application.domain.Product;

import java.util.Collection;
import java.util.Optional;

public interface ProductsRepository {
    Optional<Product> getProductById(IdentificationNumber productId);
    void storeProduct(Product product);
    Collection<Product> listProducts(int limit,int skip);
    Integer countProducts();
}

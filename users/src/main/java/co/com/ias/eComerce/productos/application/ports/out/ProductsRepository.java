package co.com.ias.eComerce.productos.application.ports.out;

import co.com.ias.eComerce.productos.application.domain.Product;
import co.com.ias.eComerce.productos.application.domain.ProductId;

import java.util.Collection;
import java.util.Optional;

public interface ProductsRepository {
    Optional<Product> getProductById(ProductId productId);
    void storeProduct(Product product);
    Collection<Product> listProducts(int limit,int skip);
    Integer countProducts();
}

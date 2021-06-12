package co.com.ias.eComerce.productos.application.model;

import co.com.ias.eComerce.commons.operation.ApplicationResponse;
import co.com.ias.eComerce.productos.application.domain.Product;

public class CreateProductResponse implements ApplicationResponse {
    private  final Product product;

    @Override
    public String toString() {
        return "CreateProductResponse{" +
                "product=" + product +
                '}';
    }

    public Product getProduct() {
        return product;
    }

    public CreateProductResponse(Product product) {
        this.product = product;
    }
}

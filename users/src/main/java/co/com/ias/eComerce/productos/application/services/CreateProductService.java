package co.com.ias.eComerce.productos.application.services;

import co.com.ias.eComerce.productos.application.domain.Product;
import co.com.ias.eComerce.productos.application.domain.ProductId;
import co.com.ias.eComerce.productos.application.errors.ProductAlreadyExistEror;
import co.com.ias.eComerce.productos.application.model.CreateProductRequest;
import co.com.ias.eComerce.productos.application.model.CreateProductResponse;
import co.com.ias.eComerce.productos.application.ports.in.CreateProductUseCase;
import co.com.ias.eComerce.productos.application.ports.out.ProductsRepository;
import co.com.ias.eComerce.users.application.errors.InputDataError;
import io.vavr.control.Validation;

import java.util.Optional;

public class CreateProductService implements CreateProductUseCase {
    private final ProductsRepository repository;

    public CreateProductService(ProductsRepository repository) {
        this.repository = repository;
    }

    public CreateProductResponse execute(CreateProductRequest request){
        Validation<InputDataError, Product> validation = Product.parseProduct(
                request.getName(),
                request.getDescription(),
                request.getBasePrice(),
                request.getTaxRate(),
                request.getProductStatus(),
                request.getInventoryQuantity(),
                request.getIdProduct()
        );

        if(validation.isInvalid()) {
        throw validation.getError();
    }

    final Product product = validation.get();

    ProductId productId = product.getIdProduct();
    Optional<Product> studentById = repository.getProductById(productId);

        if (studentById.isPresent()) {
        throw new ProductAlreadyExistEror(productId);
    }

        repository.storeProduct(product);

        return new CreateProductResponse(product);
}
}

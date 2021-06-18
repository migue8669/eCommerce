package co.com.ias.Ecomerce.products.application.ports.in;

import co.com.ias.Ecomerce.commons.operation.ApplicationUseCase;
import co.com.ias.Ecomerce.products.application.model.CreateProductRequest;
import co.com.ias.Ecomerce.products.application.model.CreateProductResponse;

public interface CreateProductUseCase extends ApplicationUseCase<CreateProductRequest, CreateProductResponse> {
}

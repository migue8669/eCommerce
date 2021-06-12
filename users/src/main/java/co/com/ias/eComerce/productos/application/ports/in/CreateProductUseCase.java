package co.com.ias.eComerce.productos.application.ports.in;

import co.com.ias.eComerce.commons.operation.ApplicationUseCase;
import co.com.ias.eComerce.productos.application.model.CreateProductRequest;
import co.com.ias.eComerce.productos.application.model.CreateProductResponse;

public interface CreateProductUseCase extends ApplicationUseCase<CreateProductRequest, CreateProductResponse> {
}

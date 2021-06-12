package co.com.ias.eComerce.productos.application.ports.in;

import co.com.ias.eComerce.commons.operation.ApplicationUseCase;
import co.com.ias.eComerce.productos.application.model.ListProductsRequest;
import co.com.ias.eComerce.productos.application.model.ListProductResponse;

public interface ListProductsUseCase extends ApplicationUseCase<ListProductsRequest, ListProductResponse> {
}

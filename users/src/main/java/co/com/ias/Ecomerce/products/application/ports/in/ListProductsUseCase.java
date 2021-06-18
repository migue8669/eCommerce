package co.com.ias.Ecomerce.products.application.ports.in;

import co.com.ias.Ecomerce.commons.operation.ApplicationUseCase;
import co.com.ias.Ecomerce.products.application.model.ListProductsRequest;
import co.com.ias.Ecomerce.products.application.model.ListProductResponse;

public interface ListProductsUseCase extends ApplicationUseCase<ListProductsRequest, ListProductResponse> {
}

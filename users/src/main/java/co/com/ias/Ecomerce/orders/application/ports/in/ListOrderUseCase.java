package co.com.ias.Ecomerce.orders.application.ports.in;

import co.com.ias.Ecomerce.commons.operation.ApplicationUseCase;
import co.com.ias.Ecomerce.orders.application.model.ListOrderRequest;
import co.com.ias.Ecomerce.orders.application.model.ListOrderResponse;

public interface ListOrderUseCase extends ApplicationUseCase<ListOrderRequest, ListOrderResponse> {
}

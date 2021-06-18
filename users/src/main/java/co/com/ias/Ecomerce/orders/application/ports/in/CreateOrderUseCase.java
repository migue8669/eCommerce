package co.com.ias.Ecomerce.orders.application.ports.in;

import co.com.ias.Ecomerce.commons.operation.ApplicationUseCase;
import co.com.ias.Ecomerce.orders.application.model.CreateOrderRequest;
import co.com.ias.Ecomerce.orders.application.model.CreateOrderResponse;

public interface CreateOrderUseCase extends ApplicationUseCase<CreateOrderRequest, CreateOrderResponse> {
}

package co.com.ias.eComerce.ordenes.application.ports.in;

import co.com.ias.eComerce.commons.operation.ApplicationUseCase;
import co.com.ias.eComerce.ordenes.application.model.CreateOrderRequest;
import co.com.ias.eComerce.ordenes.application.model.CreateOrderResponse;

public interface CreateOrderUseCase extends ApplicationUseCase<CreateOrderRequest, CreateOrderResponse> {
}

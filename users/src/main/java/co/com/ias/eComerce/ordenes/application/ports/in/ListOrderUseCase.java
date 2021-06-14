package co.com.ias.eComerce.ordenes.application.ports.in;

import co.com.ias.eComerce.commons.operation.ApplicationUseCase;
import co.com.ias.eComerce.ordenes.application.model.ListOrderRequest;
import co.com.ias.eComerce.ordenes.application.model.ListOrderResponse;

public interface ListOrderUseCase extends ApplicationUseCase<ListOrderRequest, ListOrderResponse> {
}

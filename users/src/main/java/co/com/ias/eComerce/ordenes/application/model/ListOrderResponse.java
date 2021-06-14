package co.com.ias.eComerce.ordenes.application.model;

import co.com.ias.eComerce.commons.operation.ApplicationResponse;
import co.com.ias.eComerce.ordenes.application.domain.Orders;

import java.util.Collection;

public class ListOrderResponse implements ApplicationResponse {
    private final Collection<Orders> items;

    public ListOrderResponse(Collection<Orders> items) {
        this.items = items;
    }

    public Collection<Orders> getItems() {
        return items;
    }
}

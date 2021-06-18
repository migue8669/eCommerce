package co.com.ias.Ecomerce.orders.application.model;

import co.com.ias.Ecomerce.commons.operation.ApplicationResponse;
import co.com.ias.Ecomerce.orders.application.domain.Orders;

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

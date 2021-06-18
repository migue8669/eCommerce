package co.com.ias.Ecomerce.orders.application.model;

import co.com.ias.Ecomerce.commons.operation.ApplicationResponse;
import co.com.ias.Ecomerce.orders.application.domain.Orders;

public class CreateOrderResponse implements ApplicationResponse {
    private final Orders orders;

    public CreateOrderResponse(Orders orders) {
        this.orders = orders;
    }

    public Orders getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return "CreateEmployeResponse{" +
                "order=" + orders +
                '}';
    }
}

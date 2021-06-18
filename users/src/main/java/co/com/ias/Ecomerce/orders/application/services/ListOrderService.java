package co.com.ias.Ecomerce.orders.application.services;

import co.com.ias.Ecomerce.orders.application.domain.Orders;
import co.com.ias.Ecomerce.orders.application.model.ListOrderRequest;
import co.com.ias.Ecomerce.orders.application.model.ListOrderResponse;
import co.com.ias.Ecomerce.orders.application.ports.in.ListOrderUseCase;
import co.com.ias.Ecomerce.orders.application.ports.out.OrderRepository;

import java.util.Collection;

public class ListOrderService implements ListOrderUseCase {
    private final OrderRepository repository;

    public ListOrderService(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public ListOrderResponse execute(ListOrderRequest request) {
        Collection<Orders> orders = repository.listOrders(
                request.getLimit(),
                request.getSkip()
        );
        return new ListOrderResponse(orders);
    }
}
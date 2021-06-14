package co.com.ias.eComerce.ordenes.application.services;

import co.com.ias.eComerce.ordenes.application.domain.Orders;
import co.com.ias.eComerce.ordenes.application.model.ListOrderRequest;
import co.com.ias.eComerce.ordenes.application.model.ListOrderResponse;
import co.com.ias.eComerce.ordenes.application.ports.in.ListOrderUseCase;
import co.com.ias.eComerce.ordenes.application.ports.out.OrderRepository;

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
package co.com.ias.eComerce.ordenes.application.services;

import co.com.ias.eComerce.ordenes.application.domain.Orders;
import co.com.ias.eComerce.ordenes.application.domain.IdentificationNumber;
import co.com.ias.eComerce.ordenes.application.errors.OrdersAlreadyExistsError;
import co.com.ias.eComerce.ordenes.application.errors.InputDataError;
import co.com.ias.eComerce.ordenes.application.model.CreateOrderRequest;
import co.com.ias.eComerce.ordenes.application.model.CreateOrderResponse;
import co.com.ias.eComerce.ordenes.application.ports.in.CreateOrderUseCase;
import co.com.ias.eComerce.ordenes.application.ports.out.OrderRepository;
import io.vavr.control.Validation;

import java.util.Optional;

public class CreateOrderService implements CreateOrderUseCase {
    private final OrderRepository repository;

    public CreateOrderService(OrderRepository repository) {
        this.repository = repository;
    }


    public CreateOrderResponse execute(CreateOrderRequest request) {
        Validation<InputDataError, Orders> validation = Orders.parseEmploye(
                request.getName(),
                request.getLastName(),
//                request.getIdType(),
                request.getIdNumber()
        );

        if(validation.isInvalid()) {
            throw validation.getError();
        }

        final Orders orders = validation.get();

        IdentificationNumber identificationNumber = orders.getIdNumber();
        Optional<Orders> studentById = repository.getEmployeById(identificationNumber);

        if (studentById.isPresent()) {
            throw new OrdersAlreadyExistsError(identificationNumber);
        }

        repository.storeOrder(orders);

        return new CreateOrderResponse(orders);
    }
}
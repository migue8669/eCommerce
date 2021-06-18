package co.com.ias.Ecomerce.orders.application.ports.out;

import co.com.ias.Ecomerce.orders.application.domain.Orders;
import co.com.ias.Ecomerce.commons.IdentificationNumber;

import java.util.Collection;
import java.util.Optional;

public interface OrderRepository {


    Optional<Orders> getOrderById(IdentificationNumber identificationNumber);

    void storeOrder(Orders orders);

    Collection<Orders> listOrders(int limit, int skip);

}
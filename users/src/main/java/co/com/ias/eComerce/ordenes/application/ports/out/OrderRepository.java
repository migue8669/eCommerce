package co.com.ias.eComerce.ordenes.application.ports.out;

import co.com.ias.eComerce.ordenes.application.domain.Orders;
import co.com.ias.eComerce.ordenes.application.domain.IdentificationNumber;

import java.util.Collection;
import java.util.Optional;

public interface OrderRepository {


    Optional<Orders> getOrderById(IdentificationNumber identificationNumber);

    void storeOrder(Orders orders);

    Collection<Orders> listOrders(int limit, int skip);

}
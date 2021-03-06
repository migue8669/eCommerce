package co.com.ias.Ecomerce.products.application.model;

import co.com.ias.Ecomerce.commons.operation.ApplicationResponse;
import co.com.ias.Ecomerce.products.application.domain.Product;

import java.util.Collection;

public class ListProductResponse implements ApplicationResponse {
    private final Collection<Product> items;
    private final Integer total;
    public ListProductResponse(Collection<Product> items, Integer total) {
        this.items = items;
        this.total = total;
    }



    public Collection<Product> getItems() {
        return items;
    }

    public Integer getTotal() {
        return total;
    }
}

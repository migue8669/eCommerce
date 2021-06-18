package co.com.ias.Ecomerce.orders.application.model;

import co.com.ias.Ecomerce.commons.operation.ApplicationRequest;

public class ListOrderRequest implements ApplicationRequest {
    private final Integer limit;
    private final Integer skip;

    public Integer getLimit() {
        return limit;
    }

    public Integer getSkip() {
        return skip;
    }

    public ListOrderRequest(Integer limit, Integer skip) {
        this.limit = limit;
        this.skip = skip;
    }
}
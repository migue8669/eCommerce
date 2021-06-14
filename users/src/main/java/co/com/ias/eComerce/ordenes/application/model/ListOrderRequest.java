package co.com.ias.eComerce.ordenes.application.model;

import co.com.ias.eComerce.commons.operation.ApplicationRequest;

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
package co.com.ias.Ecomerce.users.application.model;

import co.com.ias.Ecomerce.commons.operation.ApplicationRequest;

public class ListEmployeRequest implements ApplicationRequest {
    private final Integer limit;
    private final Integer skip;

    public Integer getLimit() {
        return limit;
    }

    public Integer getSkip() {
        return skip;
    }

    public ListEmployeRequest(Integer limit, Integer skip) {
        this.limit = limit;
        this.skip = skip;
    }
}
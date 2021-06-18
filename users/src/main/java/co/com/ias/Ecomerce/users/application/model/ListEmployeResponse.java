package co.com.ias.Ecomerce.users.application.model;

import co.com.ias.Ecomerce.commons.operation.ApplicationResponse;
import co.com.ias.Ecomerce.users.application.domain.Employe;

import java.util.Collection;

public class ListEmployeResponse implements ApplicationResponse {
    private final Collection<Employe> items;

    public ListEmployeResponse(Collection<Employe> items) {
        this.items = items;
    }

    public Collection<Employe> getItems() {
        return items;
    }
}

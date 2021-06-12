package co.com.ias.eComerce.users.application.model;

import co.com.ias.eComerce.commons.operation.ApplicationResponse;
import co.com.ias.eComerce.users.application.domain.Employe;

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

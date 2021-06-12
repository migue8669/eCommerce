package co.com.ias.eComerce.users.application.model;

import co.com.ias.eComerce.commons.operation.ApplicationResponse;
import co.com.ias.eComerce.users.application.domain.Employe;

public class CreateEmployeResponse implements ApplicationResponse {
    private final Employe employe;

    public CreateEmployeResponse(Employe employe) {
        this.employe = employe;
    }

    public Employe getEmploye() {
        return employe;
    }

    @Override
    public String toString() {
        return "CreateEmployeResponse{" +
                "employe=" + employe +
                '}';
    }
}

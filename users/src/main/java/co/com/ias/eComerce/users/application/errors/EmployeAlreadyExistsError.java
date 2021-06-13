package co.com.ias.eComerce.users.application.errors;

import co.com.ias.eComerce.commons.errors.ApplicationError;
import co.com.ias.eComerce.commons.errors.HttpStatusCode;
import co.com.ias.eComerce.users.application.domain.IdentificationNumber;

import java.util.Map;
import java.util.UUID;

public class EmployeAlreadyExistsError extends ApplicationError {
    private final IdentificationNumber idNumber;

    public EmployeAlreadyExistsError(IdentificationNumber identificationNumber) {
        this.idNumber = identificationNumber;
    }

    @Override
    public String getMessage() {

        return "The employe with id number: " + idNumber + " already exists.";
    }

    @Override
    public String errorCode() {

        return "EMPLOYE_ALREADY_EXISTS_ERROR";

    }

    @Override
    public HttpStatusCode httpStatusCode() {
        return HttpStatusCode.BAD_REQUEST;
    }


    @Override
    public Map<String, Object> metadata() {
        return Map.of(
                "idNumber", idNumber
        );
    }
}

package co.com.ias.eComerce.users.application.errors;

import co.com.ias.eComerce.commons.errors.ApplicationError;
import co.com.ias.eComerce.commons.errors.HttpStatusCode;

import java.util.Map;

public class EmployeAlreadyExistsError extends ApplicationError {
    private final IdentificationNumber idNumber;

    public EmployeAlreadyExistsError(IdentificationNumber idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public String getMessage() {

        return "The employe with id number: " + idNumber.getValue() + " already exists.";
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

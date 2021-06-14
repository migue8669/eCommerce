package co.com.ias.eComerce.ordenes.application.errors;

import co.com.ias.eComerce.commons.errors.ApplicationError;
import co.com.ias.eComerce.commons.errors.HttpStatusCode;
import co.com.ias.eComerce.ordenes.application.domain.IdentificationNumber;

import java.util.Map;

public class OrdersAlreadyExistsError extends ApplicationError {
    private final IdentificationNumber idNumber;

    public OrdersAlreadyExistsError(IdentificationNumber identificationNumber) {
        this.idNumber = identificationNumber;
    }

    @Override
    public String getMessage() {

        return "The order with id number: " + idNumber + " already exists.";
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

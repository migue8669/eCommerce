package co.com.ias.Ecomerce.products.application.errors;

import co.com.ias.Ecomerce.commons.IdentificationNumber;
import co.com.ias.Ecomerce.commons.errors.ApplicationError;
import co.com.ias.Ecomerce.commons.errors.HttpStatusCode;

import java.util.Map;

public class ProductAlreadyExistEror extends ApplicationError {
    private final IdentificationNumber idNumber;

    public IdentificationNumber getIdNumber() {
        return idNumber;
    }

    public ProductAlreadyExistEror(IdentificationNumber idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public String errorCode() {
        return "PRODUCT_ALREADY_EXISTS_ERROR";
    }

        @Override
    public String getMessage() {
        return "The product with id number: " + idNumber.getValue() + " already exists.";
    }

    @Override
    public HttpStatusCode httpStatusCode() {
        return HttpStatusCode.BAD_REQUEST;

    }

    @Override
    public Map<String, Object> metadata() {
        return Map.of(
                "idNumber", idNumber
        );    }
}

package co.com.ias.eComerce.productos.application.errors;

import co.com.ias.eComerce.commons.errors.ApplicationError;
import co.com.ias.eComerce.commons.errors.HttpStatusCode;
import co.com.ias.eComerce.productos.application.domain.ProductId;

import java.util.Map;

public class ProductAlreadyExistEror extends ApplicationError {
    private final ProductId idNumber;

    public ProductId getIdNumber() {
        return idNumber;
    }

    public ProductAlreadyExistEror(ProductId idNumber) {
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

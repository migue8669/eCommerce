package co.com.ias.eComerce.productos.application.errors;

import co.com.ias.eComerce.commons.InputAttributeError;
import co.com.ias.eComerce.commons.errors.ApplicationError;
import co.com.ias.eComerce.commons.errors.HttpStatusCode;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InputDataError extends ApplicationError {
    private final String message;
    private final List<InputAttributeError> errors;

    public InputDataError(String message, List<InputAttributeError> errors) {
        this.message = message;
        this.errors = errors;
    }

    @Override
    public String errorCode() {
        return "INPUT_DATA_ERROR";
    }

    @Override
    public HttpStatusCode httpStatusCode() {
        return HttpStatusCode.BAD_REQUEST;

    }

    @Override
    public Map<String, Object> metadata() {
        return errors
                .stream()
                .collect(Collectors.toMap(
                        InputAttributeError::getAttributeName,
                        InputAttributeError::getErrorMessage
                ));
    }
}

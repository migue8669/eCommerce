package co.com.ias.Ecomerce.commons.errors;

import java.util.Map;

public interface ApplicationErrorSpec {
    String errorCode();
    HttpStatusCode httpStatusCode();
    String getMessage();
    default Map<String,Object>metadata(){
        return Map.of();
    }
}

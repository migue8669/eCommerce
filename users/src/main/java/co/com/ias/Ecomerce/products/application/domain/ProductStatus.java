package co.com.ias.Ecomerce.products.application.domain;

import co.com.ias.Ecomerce.commons.InputAttributeError;
import io.vavr.control.Validation;

import java.util.Objects;

public enum ProductStatus {
    Borrador,
    Publicado;

    public static Validation<InputAttributeError, ProductStatus> parse(
            String value,
            String attributeName
    ) {
        Objects.requireNonNull(attributeName);

        try {
            final ProductStatus productStatus = ProductStatus.valueOf(value);
            return Validation.valid(productStatus);
        } catch (RuntimeException e) {
            return Validation.invalid(new InputAttributeError(attributeName, e.getMessage()));
        }
    }
}

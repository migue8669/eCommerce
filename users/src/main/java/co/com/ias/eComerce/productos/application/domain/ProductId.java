package co.com.ias.eComerce.productos.application.domain;

import co.com.ias.eComerce.commons.InputAttributeError;
import co.com.ias.eComerce.commons.StringUtils;
import co.com.ias.eComerce.commons.Validate;
import io.vavr.control.Validation;

import java.util.Objects;

public class ProductId {
    private final String value;
    private static final String NULL_MESSAGE = "IdentificationNumber can not be null";
    private static final String EMPTY_MESSAGE = "IdentificationNumber can not be empty";
    private static final String INVALID_PATTERN_MESSAGE = "Invalid identification number";
    public ProductId(String value) {
        Validate.notNull(value, NULL_MESSAGE);

        this.value = value;
    }
    public static Validation<InputAttributeError, ProductId> parse(
            String unsafeValue,
            String attributeName
    ) {
        Objects.requireNonNull(attributeName);

        if(unsafeValue == null) {
            return Validation.invalid(new InputAttributeError(attributeName, NULL_MESSAGE));
        }
        if(StringUtils.nonBlank(unsafeValue)) {
            return Validation.invalid(new InputAttributeError(attributeName, EMPTY_MESSAGE));
        }


        return Validation.valid(new ProductId(unsafeValue));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductId productId = (ProductId) o;
        return Objects.equals(value, productId.value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ProductId{" +
                "value='" + value + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

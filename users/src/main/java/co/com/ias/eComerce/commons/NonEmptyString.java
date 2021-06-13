package co.com.ias.eComerce.commons;

import io.vavr.control.Validation;

import static co.com.ias.eComerce.commons.StringUtils.nonBlank;

public class NonEmptyString {
    private final String value;
    private static final String NULL_MESSAGE = "NonEmptyString can not be null";
    private static final String EMPTY_MESSAGE = "NonEmptyString can not be empty";

    public NonEmptyString(String value) {
        // validation logic
        Validate.notNull(value, NULL_MESSAGE);
        Validate.isTrue(StringUtils.nonBlank(value), EMPTY_MESSAGE);
        this.value = value;
    }

    // factory
    public static Validation<InputAttributeError, NonEmptyString> parse(
            String unsafeValue,
            String attributeName
    ) {
        if(unsafeValue == null) {
            return Validation.invalid(new InputAttributeError(attributeName, NULL_MESSAGE));
        }
        if(StringUtils.nonBlank(unsafeValue)) {
            return Validation.invalid(new InputAttributeError(attributeName, EMPTY_MESSAGE));
        }
        return Validation.valid(new NonEmptyString(unsafeValue));
    }
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "NonEmpityString{" +
                "value='" + value + '\'' +
                '}';
    }
}

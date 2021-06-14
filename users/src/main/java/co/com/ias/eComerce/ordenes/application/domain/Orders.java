package co.com.ias.eComerce.ordenes.application.domain;


import co.com.ias.eComerce.commons.InputAttributeError;
import co.com.ias.eComerce.commons.NonEmptyString;
import co.com.ias.eComerce.commons.Validate;
import co.com.ias.eComerce.ordenes.application.errors.InputDataError;
import io.vavr.control.Validation;

import java.util.List;

public class Orders {



    private final IdentificationNumber idNumber;

    private final NonEmptyString name;
    private final NonEmptyString lastName;


    public Orders(IdentificationNumber identificationNumber, NonEmptyString name, NonEmptyString lastName){
        Validate.notNull(name,"Order name can not be null");
        Validate.notNull(lastName,"Order lastname can not be null");
        Validate.notNull(identificationNumber, "Order identificationNumber can not be null");

       this.idNumber=identificationNumber;
        this.name=name;
        this.lastName=lastName;

    }

    public IdentificationNumber getIdNumber() {
        return idNumber;
    }
    public static Validation<InputDataError, Orders> parseEmploye(
            String idNumber,
            String name,
            String lastName
    ) {
        var nameValidation = NonEmptyString.parse(
                name,
                "name"
        );

        var lastNameValidation = NonEmptyString.parse(
                lastName,
                "lastName"
        );


        var idNumberValidation = IdentificationNumber.parse(
                idNumber,
                "idNumber"
        );
        return Validation.combine(
                idNumberValidation,
                nameValidation,
                lastNameValidation

        )
                .ap(Orders::new)
                .mapError(inputAttributeErrors -> {
                    String message = "There was an error with the input order data.";
                    final List<InputAttributeError> errors = inputAttributeErrors.asJava();
                    return new InputDataError(message, errors);
                });
    }

    public NonEmptyString getName() {
        return name;
    }

    public NonEmptyString getLastName() {
        return lastName;
    }


}
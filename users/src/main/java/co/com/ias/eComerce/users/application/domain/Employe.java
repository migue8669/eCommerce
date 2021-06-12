package co.com.ias.eComerce.users.application.domain;


import co.com.ias.eComerce.commons.NonEmptyString;
import co.com.ias.eComerce.commons.Validate;

import java.util.UUID;

public class Employe {



    private final UUID id;

    private final NonEmptyString name;
    private final NonEmptyString lastName;


    public Employe(NonEmptyString name, NonEmptyString lastName,UUID id){
        Validate.notNull(name,"Employe name can not be null");
        Validate.notNull(lastName,"Employe lastname can not be null");

       this.id=id;
        this.name=name;
        this.lastName=lastName;

    }

    public NonEmptyString getName() {
        return name;
    }

    public NonEmptyString getLastName() {
        return lastName;
    }


}
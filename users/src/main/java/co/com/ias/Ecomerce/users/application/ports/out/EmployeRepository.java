package co.com.ias.Ecomerce.users.application.ports.out;

import co.com.ias.Ecomerce.commons.IdentificationNumber;
import co.com.ias.Ecomerce.users.application.domain.Employe;

import java.util.Collection;
import java.util.Optional;

public interface EmployeRepository {

        Optional<Employe> getEmployeById(IdentificationNumber identificationNumber);

    void storeEmploye(Employe employe);

    Collection<Employe> listEmployes(int limit, int skip);
}
package co.com.ias.eComerce.users.application.ports.out;

import co.com.ias.eComerce.users.application.domain.Employe;
import co.com.ias.eComerce.users.application.domain.IdentificationNumber;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface EmployeRepository {

        Optional<Employe> getEmployeById(IdentificationNumber identificationNumber);

    void storeEmploye(Employe employe);

    Collection<Employe> listEmployes(int limit, int skip);
}
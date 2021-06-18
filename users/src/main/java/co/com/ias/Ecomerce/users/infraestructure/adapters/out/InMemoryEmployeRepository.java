package co.com.ias.Ecomerce.users.infraestructure.adapters.out;

import co.com.ias.Ecomerce.commons.IdentificationNumber;
import co.com.ias.Ecomerce.users.application.domain.Employe;
import co.com.ias.Ecomerce.users.application.ports.out.EmployeRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryEmployeRepository implements EmployeRepository {
    private final Map<IdentificationNumber, Employe> database = new HashMap<>();


    @Override
    public Optional<Employe> getEmployeById(IdentificationNumber identificationNumber) {
        Employe employe = database.get(identificationNumber);
        return Optional.ofNullable(employe);    }

    @Override
    public void storeEmploye(Employe employe) {
        database.put(employe.getIdNumber(), employe);
    }

    @Override
    public Collection<Employe> listEmployes(int limit, int skip) {
        return database.values();
    }

}
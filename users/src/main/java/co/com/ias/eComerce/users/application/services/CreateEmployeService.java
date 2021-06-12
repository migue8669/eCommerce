package co.com.ias.eComerce.users.application.services;

import co.com.ias.eComerce.users.application.domain.Employe;
import co.com.ias.eComerce.users.application.errors.EmployeAlreadyExistsError;
import co.com.ias.eComerce.users.application.errors.InputDataError;
import co.com.ias.eComerce.users.application.model.CreateEmployeRequest;
import co.com.ias.eComerce.users.application.model.CreateEmployeResponse;
import co.com.ias.eComerce.users.application.ports.in.CreateEmployeUseCase;
import co.com.ias.eComerce.users.application.ports.out.EmployeRepository;
import co.com.ias.eComerce.commons.NonEmptyString;

import java.util.Optional;

public class CreateEmployeService implements CreateEmployeUseCase {
    private final EmployeRepository repository;

    public CreateEmployeService(EmployeRepository repository) {
        this.repository = repository;
    }


    public  CreateEmployeResponse execute(CreateEmployeRequest request) {
        Employe employe = validateInput(request);

         identificationNumber = employe.getIdentificationNumber();
        Optional<Employe> employeById = repository.getEmployeById(identificationNumber);

        if (employeById.isPresent()) {
            throw new EmployeAlreadyExistsError(identificationNumber);
        }

        repository.storeEmploye(employe);

        return new CreateEmployeResponse(employe);
    }


    private Employe validateInput(CreateEmployeRequest request) {
        try {
            NonEmptyString name = new NonEmptyString(request.getName());
            NonEmptyString lastName = new NonEmptyString(request.getLastName());
            IdentificationType identificationType = IdentificationType.valueOf(request.getIdType());
            IdentificationNumber identificationNumber = new IdentificationNumber(request.getIdNumber());

            return new Employe(
                    name,
                    lastName,
                    identificationType,
                    identificationNumber
            );
        } catch (RuntimeException e) {
            throw new InputDataError(e.getMessage());
        }
    }
}
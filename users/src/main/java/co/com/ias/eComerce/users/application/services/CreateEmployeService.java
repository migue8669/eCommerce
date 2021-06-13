package co.com.ias.eComerce.users.application.services;

import co.com.ias.eComerce.users.application.domain.Employe;
import co.com.ias.eComerce.users.application.domain.IdentificationNumber;
import co.com.ias.eComerce.users.application.errors.EmployeAlreadyExistsError;
import co.com.ias.eComerce.users.application.errors.InputDataError;
import co.com.ias.eComerce.users.application.model.CreateEmployeRequest;
import co.com.ias.eComerce.users.application.model.CreateEmployeResponse;
import co.com.ias.eComerce.users.application.ports.in.CreateEmployeUseCase;
import co.com.ias.eComerce.users.application.ports.out.EmployeRepository;
import co.com.ias.eComerce.commons.NonEmptyString;
import io.vavr.control.Validation;

import java.util.Optional;

public class CreateEmployeService implements CreateEmployeUseCase {
    private final EmployeRepository repository;

    public CreateEmployeService(EmployeRepository repository) {
        this.repository = repository;
    }


    public  CreateEmployeResponse execute(CreateEmployeRequest request) {
        Validation<InputDataError, Employe> validation = Employe.parseEmploye(
                request.getName(),
                request.getLastName(),
//                request.getIdType(),
                request.getIdNumber()
        );

        if(validation.isInvalid()) {
            throw validation.getError();
        }

        final Employe employe = validation.get();

        IdentificationNumber identificationNumber = employe.getIdNumber();
        Optional<Employe> studentById = repository.getEmployeById(identificationNumber);

        if (studentById.isPresent()) {
            throw new EmployeAlreadyExistsError(identificationNumber);
        }

        repository.storeEmploye(employe);

        return new CreateEmployeResponse(employe);
    }
}
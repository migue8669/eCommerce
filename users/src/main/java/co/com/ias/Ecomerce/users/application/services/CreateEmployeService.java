package co.com.ias.Ecomerce.users.application.services;

import co.com.ias.Ecomerce.commons.IdentificationNumber;
import co.com.ias.Ecomerce.users.application.domain.Employe;
import co.com.ias.Ecomerce.users.application.errors.EmployeAlreadyExistsError;
import co.com.ias.Ecomerce.users.application.errors.InputDataError;
import co.com.ias.Ecomerce.users.application.model.CreateEmployeRequest;
import co.com.ias.Ecomerce.users.application.model.CreateEmployeResponse;
import co.com.ias.Ecomerce.users.application.ports.in.CreateEmployeUseCase;
import co.com.ias.Ecomerce.users.application.ports.out.EmployeRepository;
import io.vavr.control.Validation;

import java.util.Optional;

public class CreateEmployeService implements CreateEmployeUseCase {
    private final EmployeRepository repository;

    public CreateEmployeService(EmployeRepository repository) {
        this.repository = repository;
    }


    public  CreateEmployeResponse execute(CreateEmployeRequest request) {
        System.out.println(request);

        Validation<InputDataError, Employe> validation = Employe.parseEmploye(
                request.getIdNumber(),
                request.getName(),
                request.getLastName()
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
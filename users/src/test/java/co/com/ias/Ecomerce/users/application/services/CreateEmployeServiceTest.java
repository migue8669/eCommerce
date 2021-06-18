package co.com.ias.Ecomerce.users.application.services;
import co.com.ias.Ecomerce.commons.IdentificationNumber;
import co.com.ias.Ecomerce.commons.NonEmptyString;
import co.com.ias.Ecomerce.users.application.domain.Employe;
import co.com.ias.Ecomerce.users.application.errors.EmployeAlreadyExistsError;
import co.com.ias.Ecomerce.users.application.model.CreateEmployeRequest;
import co.com.ias.Ecomerce.users.application.model.CreateEmployeResponse;
import co.com.ias.Ecomerce.users.application.ports.out.EmployeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
public class CreateEmployeServiceTest {

    @Test
    void ifEmployeDoesNotExistsItGetsCreated() {
        // arrange
        EmployeRepository repository = Mockito.mock(EmployeRepository.class);
        Mockito.when(repository.getEmployeById(ArgumentMatchers.any(IdentificationNumber.class)))
                .thenReturn(Optional.empty());


        CreateEmployeService createEmployeService = new CreateEmployeService(repository);
        final String lastName = "lastName";

        CreateEmployeRequest request = new CreateEmployeRequest(
                "idNumber",
                "name",
          lastName
        );

        // act
        CreateEmployeResponse response = createEmployeService.execute(request);

        // assert
        assertAll(
                () -> assertDoesNotThrow(() -> createEmployeService.execute(request)),
                () -> assertEquals(
                        response.getEmploye().getIdNumber().getValue(),
                        lastName
                ),
                () -> Mockito.verify(repository, Mockito.times(2))
                        .getEmployeById(ArgumentMatchers.any(IdentificationNumber.class))
        );
    }


    @Test
    void ifEmployeExistsItThrowsAnException() {
        Employe employe = new Employe(
                new IdentificationNumber("12345678"),

        new NonEmptyString("name"),
                new NonEmptyString("lastName")
            //    IdentificationType.CC.CC,
        );

        EmployeRepository repository = Mockito.mock(EmployeRepository.class);
        Mockito.when(repository.getEmployeById(ArgumentMatchers.any(IdentificationNumber.class)))
                .thenReturn(Optional.of(employe));


        CreateEmployeService createEmployeService = new CreateEmployeService(repository);
        CreateEmployeRequest request = new CreateEmployeRequest(
                employe.getName().getValue(),
                employe.getLastName().getValue(),
                employe.getIdNumber().getValue()
               // employe.getIdentificationType().name()
        );

        assertAll(
                () -> assertThrows(EmployeAlreadyExistsError.class, () -> createEmployeService.execute(request)),
                () -> Mockito.verify(repository, Mockito.times(0))
                        .storeEmploye(ArgumentMatchers.any(Employe.class))
        );

    }

}
package co.com.ias.eComerce.users.application.services;
import co.com.ias.eComerce.commons.NonEmptyString;
import co.com.ias.eComerce.users.application.domain.Employe;
import co.com.ias.eComerce.users.application.errors.EmployeAlreadyExistsError;
import co.com.ias.eComerce.users.application.model.CreateEmployeRequest;
import co.com.ias.eComerce.users.application.model.CreateEmployeResponse;
import co.com.ias.eComerce.users.application.ports.out.EmployeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
public class CreateEmployeServiceTest {

    @Test
    void ifStudentsDoesNotExistsItGetsCreated() {
        // arrange
        EmployeRepository repository = Mockito.mock(EmployeRepository.class);
        Mockito.when(repository.getEmployeById(ArgumentMatchers.any(IdentificationNumber.class)))
                .thenReturn(Optional.empty());


        CreateEmployeService createEmployeService = new CreateEmployeService(repository);
        final String idNumber = "12345678";
        CreateEmployeRequest request = new CreateEmployeRequest(
                "name",
                "lastName",
                idNumber,
                "CC"
        );

        // act
        CreateEmployeResponse response = createEmployeService.execute(request);

        // assert
        assertAll(
                () -> assertDoesNotThrow(() -> createEmployeService.execute(request)),
                () -> assertEquals(
                        response.getEmploye().getIdentificationNumber().getValue(),
                        idNumber
                ),
                () -> Mockito.verify(repository, Mockito.times(2))
                        .getEmployeById(ArgumentMatchers.any(IdentificationNumber.class))
        );
    }


    @Test
    void ifStudentExistsItThrowsAnException() {
        Employe employe = new Employe(
                new NonEmptyString("name"),
                new NonEmptyString("lastName"),
                IdentificationType.CC.CC,
                new IdentificationNumber("12345678")
        );

        EmployeRepository repository = Mockito.mock(EmployeRepository.class);
        Mockito.when(repository.getEmployeById(ArgumentMatchers.any(IdentificationNumber.class)))
                .thenReturn(Optional.of(employe));


        CreateEmployeService createEmployeService = new CreateEmployeService(repository);
        CreateEmployeRequest request = new CreateEmployeRequest(
                employe.getName().getValue(),
                employe.getLastName().getValue(),
                employe.getIdentificationNumber().getValue(),
                employe.getIdentificationType().name()
        );

        assertAll(
                () -> assertThrows(EmployeAlreadyExistsError.class, () -> createEmployeService.execute(request)),
                () -> Mockito.verify(repository, Mockito.times(0))
                        .storeEmploye(ArgumentMatchers.any(Employe.class))
        );

    }

}
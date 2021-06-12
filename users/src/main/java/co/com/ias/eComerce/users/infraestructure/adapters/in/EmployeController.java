package co.com.ias.eComerce.users.infraestructure.adapters.in;

import co.com.ias.eComerce.users.application.model.CreateEmployeRequest;
import co.com.ias.eComerce.users.application.model.ListEmployeRequest;
import co.com.ias.eComerce.users.application.ports.in.CreateEmployeUseCase;
import co.com.ias.eComerce.users.application.ports.in.ListEmployeUseCase;
import co.com.ias.eComerce.users.infraestructure.commons.UseCaseHttpExecutor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public class EmployeController {
    private final UseCaseHttpExecutor useCaseHttpExecutor;
    private final CreateEmployeUseCase createEmployeUseCase;
    private final ListEmployeUseCase listEmployeUseCase;

    public EmployeController(UseCaseHttpExecutor useCaseHttpExecutor, CreateEmployeUseCase createEmployeUseCase, ListEmployeUseCase listEmployeUseCase) {
        this.useCaseHttpExecutor = useCaseHttpExecutor;
        this.createEmployeUseCase = createEmployeUseCase;
        this.listEmployeUseCase = listEmployeUseCase;
    }

    @GetMapping
    public ResponseEntity listStudentsHandler(
            @RequestParam(name = "limit", defaultValue = "10") String limit,
            @RequestParam(name = "skip", defaultValue = "0") String skip
    ) {
        Integer limitInt = Integer.parseInt(limit, 10);
        Integer skipInt = Integer.parseInt(skip, 10);
        return useCaseHttpExecutor.executeUseCase(
                listEmployeUseCase,
                new ListEmployeRequest(limitInt, skipInt)
        );
    }


    @PostMapping
    public ResponseEntity createStudentHandler(
            @RequestBody CreateEmployeRequest request
    ) {
        return useCaseHttpExecutor.executeUseCase(
                createEmployeUseCase,
                request
        );
    }
}

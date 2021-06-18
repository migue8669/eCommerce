package co.com.ias.Ecomerce.users.infraestructure.adapters.in;

import co.com.ias.Ecomerce.users.application.model.CreateEmployeRequest;
import co.com.ias.Ecomerce.users.application.model.ListEmployeRequest;
import co.com.ias.Ecomerce.users.application.ports.in.CreateEmployeUseCase;
import co.com.ias.Ecomerce.users.application.ports.in.ListEmployeUseCase;
import co.com.ias.Ecomerce.infraestructure.commons.UseCaseHttpExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employees")
public class EmployeController {
    private final UseCaseHttpExecutor useCaseHttpExecutor;
    private final CreateEmployeUseCase createEmployeUseCase;
    private final ListEmployeUseCase listEmployeUseCase;
    @Autowired
    public EmployeController(UseCaseHttpExecutor useCaseHttpExecutor, CreateEmployeUseCase createEmployeUseCase, ListEmployeUseCase listEmployeUseCase) {
        this.useCaseHttpExecutor = useCaseHttpExecutor;
        this.createEmployeUseCase = createEmployeUseCase;
        this.listEmployeUseCase = listEmployeUseCase;
    }

    @GetMapping
    public ResponseEntity listEmployeHandler(
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
    public ResponseEntity createEmployeHandler(
            @RequestBody CreateEmployeRequest request
    ) {
        return useCaseHttpExecutor.executeUseCase(
                createEmployeUseCase,
                request
        );
    }
}

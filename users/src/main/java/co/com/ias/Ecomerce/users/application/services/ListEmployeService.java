package co.com.ias.Ecomerce.users.application.services;

import co.com.ias.Ecomerce.users.application.domain.Employe;

import co.com.ias.Ecomerce.users.application.model.ListEmployeRequest;
import co.com.ias.Ecomerce.users.application.model.ListEmployeResponse;
import co.com.ias.Ecomerce.users.application.ports.in.ListEmployeUseCase;
import co.com.ias.Ecomerce.users.application.ports.out.EmployeRepository;

import java.util.Collection;

public class ListEmployeService implements ListEmployeUseCase {
    private final EmployeRepository repository;

    public ListEmployeService(EmployeRepository repository) {
        this.repository = repository;
    }

    @Override
    public ListEmployeResponse execute(ListEmployeRequest request) {
        Collection<Employe> employes = repository.listEmployes(
                request.getLimit(),
                request.getSkip()
        );
        return new ListEmployeResponse(employes);
    }
}
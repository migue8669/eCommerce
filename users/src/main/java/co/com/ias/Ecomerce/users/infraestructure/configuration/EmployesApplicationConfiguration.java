package co.com.ias.Ecomerce.users.infraestructure.configuration;

import co.com.ias.Ecomerce.users.application.ports.in.CreateEmployeUseCase;
import co.com.ias.Ecomerce.users.application.ports.out.EmployeRepository;
import co.com.ias.Ecomerce.users.application.services.CreateEmployeService;
import co.com.ias.Ecomerce.users.application.services.ListEmployeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployesApplicationConfiguration {

    @Bean
    public CreateEmployeUseCase createEmployeServiceBean(
            EmployeRepository employeRepository
    ) {
        return new CreateEmployeService(employeRepository);
    }

    @Bean
    public ListEmployeService listEmployeService(
            @Qualifier("employeeSql") EmployeRepository repository
    ) {
        return new ListEmployeService(repository);
    }
}

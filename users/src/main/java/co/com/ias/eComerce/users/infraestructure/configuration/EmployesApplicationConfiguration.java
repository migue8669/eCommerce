package co.com.ias.eComerce.users.infraestructure.configuration;

import co.com.ias.eComerce.users.application.ports.in.CreateEmployeUseCase;
import co.com.ias.eComerce.users.application.ports.out.EmployeRepository;
import co.com.ias.eComerce.users.application.services.CreateEmployeService;
import co.com.ias.eComerce.users.application.services.ListEmployeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import javax.sql.DataSource;

@Configuration
public class EmployesApplicationConfiguration {

    @Bean
    public CreateEmployeUseCase createStudentServiceBean(
            EmployeRepository employeRepository
    ) {
        return new CreateEmployeService(employeRepository);
    }

    @Bean
    public ListEmployeService listEmployeService(
            @Qualifier("sql") EmployeRepository repository
    ) {
        return new ListEmployeService(repository);
    }
}

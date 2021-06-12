package co.com.ias.eComerce.productos.infraestructure.configuration;

import co.com.ias.eComerce.productos.application.ports.in.CreateProductUseCase;
import co.com.ias.eComerce.productos.application.ports.in.ListProductsUseCase;
import co.com.ias.eComerce.productos.application.ports.out.ProductsRepository;
import co.com.ias.eComerce.productos.application.services.CreateProductService;
import co.com.ias.eComerce.productos.application.services.ListProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

public class ProductApplicationConfiguration {
    @Bean
    public CreateProductUseCase createStudentServiceBean(
            ProductsRepository studentsRepository
    ) {
        return new CreateProductService(studentsRepository);
    }

    @Bean
    public ListProductsUseCase listProductsUseCase(
            @Qualifier("sql") ProductsRepository repository
    ) {
        return new ListProductService(repository);
    }
}

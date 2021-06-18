package co.com.ias.Ecomerce.products.infraestructure.configuration;

import co.com.ias.Ecomerce.products.application.ports.in.CreateProductUseCase;
import co.com.ias.Ecomerce.products.application.ports.in.ListProductsUseCase;
import co.com.ias.Ecomerce.products.application.ports.out.ProductsRepository;
import co.com.ias.Ecomerce.products.application.services.CreateProductService;
import co.com.ias.Ecomerce.products.application.services.ListProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductApplicationConfiguration {
    @Bean
    public CreateProductUseCase createProductServiceBean(
            ProductsRepository productsRepository
    ) {
        return new CreateProductService(productsRepository);
    }

    @Bean
    public ListProductsUseCase listProductsUseCase(
            @Qualifier("productSql") ProductsRepository repository
    ) {
        return new ListProductService(repository);
    }
}

package co.com.ias.eComerce.productos.application.services;

import co.com.ias.eComerce.productos.application.domain.Product;
import co.com.ias.eComerce.productos.application.model.ListProductsRequest;
import co.com.ias.eComerce.productos.application.model.ListProductResponse;
import co.com.ias.eComerce.productos.application.ports.in.ListProductsUseCase;
import co.com.ias.eComerce.productos.application.ports.out.ProductsRepository;

import java.util.Collection;

public class ListProductService implements ListProductsUseCase {
    private final ProductsRepository repository;

    @Override
    public ListProductResponse execute(ListProductsRequest request) {
        Collection<Product> products = repository.listProducts(
                request.getLimit(),
                request.getSkip()
        );
        Integer total = repository.countProducts();
        return new ListProductResponse(products, total);    }

    public ListProductService(ProductsRepository repository) {
        this.repository = repository;
    }
}

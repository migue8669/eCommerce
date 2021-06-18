package co.com.ias.Ecomerce.products.infraestructure.adapters.in;

import co.com.ias.Ecomerce.infraestructure.commons.UseCaseHttpExecutor;
import co.com.ias.Ecomerce.products.application.model.CreateProductRequest;
import co.com.ias.Ecomerce.products.application.model.ListProductsRequest;
import co.com.ias.Ecomerce.products.application.ports.in.CreateProductUseCase;
import co.com.ias.Ecomerce.products.application.ports.in.ListProductsUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final UseCaseHttpExecutor useCaseHttpExecutor;
    private final CreateProductUseCase createProductUseCase;
    private final ListProductsUseCase listProductsUseCase;

    @Autowired
    public ProductController(UseCaseHttpExecutor useCaseHttpExecutor, CreateProductUseCase createProductUseCase, ListProductsUseCase listProductsUseCase) {
        this.useCaseHttpExecutor = useCaseHttpExecutor;
        this.createProductUseCase = createProductUseCase;
        this.listProductsUseCase = listProductsUseCase;
    }
    @GetMapping
    public ResponseEntity listProductHandler(
            @RequestParam(name = "limit", defaultValue = "10") String limit,
            @RequestParam(name = "skip", defaultValue = "0") String skip
    ) {
        Integer limitInt = Integer.parseInt(limit, 10);
        Integer skipInt = Integer.parseInt(skip, 10);
        return useCaseHttpExecutor.executeUseCase(
                listProductsUseCase,
                new ListProductsRequest(limitInt, skipInt)
        );
    }


    @PostMapping
    public ResponseEntity createProductHandler(
            @RequestBody CreateProductRequest request
    ) {
        return useCaseHttpExecutor.executeUseCase(
                createProductUseCase,
                request
        );
    }}

package co.com.ias.eComerce.productos.infraestructure.adapters.in;

import co.com.ias.eComerce.productos.application.model.CreateProductRequest;
import co.com.ias.eComerce.productos.application.model.ListProductsRequest;
import co.com.ias.eComerce.productos.application.ports.in.CreateProductUseCase;
import co.com.ias.eComerce.productos.application.ports.in.ListProductsUseCase;
import co.com.ias.eComerce.productos.infraestructure.commons.UseCaseHttpExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/products")
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

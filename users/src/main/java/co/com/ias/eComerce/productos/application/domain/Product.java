package co.com.ias.eComerce.productos.application.domain;

import co.com.ias.eComerce.commons.InputAttributeError;
import co.com.ias.eComerce.commons.NonEmptyString;
import co.com.ias.eComerce.commons.Validate;
import co.com.ias.eComerce.users.application.errors.InputDataError;
import io.vavr.control.Validation;

import java.util.List;

public class Product {
    private final ProductId idProduct;

    private final NonEmptyString name;
    private final NonEmptyString description;
    private final NonEmptyString basePrice;
    private final NonEmptyString taxRate;
    private final NonEmptyString inventoryQuantity;
    private final ProductStatus productStatus;

    public Product(ProductId idProduct,NonEmptyString name, NonEmptyString description, NonEmptyString basePrice, NonEmptyString taxRate, NonEmptyString inventoryQuantity, ProductStatus productStatus) {
        Validate.notNull(name,"Product name can not be null ");
        Validate.notNull(description,"Product description can not be null ");
        Validate.notNull(basePrice,"base price of product can not be null ");
        Validate.notNull(productStatus,"Product Status can not be null ");

        Validate.notNull(taxRate,"Tax rate of product can not be null ");
        Validate.notNull(inventoryQuantity,"inventory quantity of product can not be null ");
        this.idProduct=idProduct;
        this.description = description;
        this.name = name;
        this.basePrice = basePrice;
        this.taxRate=taxRate;
        this.inventoryQuantity=inventoryQuantity;
        this.productStatus=productStatus;
    }

    public ProductStatus getProductStatus() {
        return productStatus;
    }

    public static Validation<InputDataError, Product> parseProduct(

            String name,
            String description,
            String basePrice,
            String taxRate,
            String productStatus,
            String inventoryQuantity,
            String idProduct
    ) {
        var nameValidation = NonEmptyString.parse(
                name,
                "name"
        );

        var descriptionValidation = NonEmptyString.parse(
                description,
                "description"
        );

        var productStatusValidation = ProductStatus.parse(
                productStatus,
                "productStatus"
        );
        var basePriceValidation = NonEmptyString.parse(
                basePrice,
                "basePrice"
        );
        var taxRateValidation = NonEmptyString.parse(
                taxRate,
                "taxRate"
        );
        var inventoryQuantityValidation = NonEmptyString.parse(
                inventoryQuantity,
                "inventoryQuantity"
        );
        var porductIdValidation = ProductId.parse(
                idProduct,
                "idProduct"
        );
        return Validation.combine(
                porductIdValidation,
                nameValidation,
                descriptionValidation,
                basePriceValidation,
                taxRateValidation,
                inventoryQuantityValidation,
                productStatusValidation

                )
                .ap(Product::new)
                .mapError(inputAttributeErrors -> {
                    String message = "There was an error with the input product data.";
                    final List<InputAttributeError> errors = inputAttributeErrors.asJava();
                    return new InputDataError(message, errors);
                });
    }

    public ProductId getIdProduct() {
        return idProduct;
    }

    public NonEmptyString getName() {
        return name;
    }

    public NonEmptyString getDescription() {
        return description;
    }

    public NonEmptyString getBasePrice() {
        return basePrice;
    }

    public NonEmptyString getTaxRate() {
        return taxRate;
    }

    public NonEmptyString getInventoryQuantity() {
        return inventoryQuantity;
    }
}

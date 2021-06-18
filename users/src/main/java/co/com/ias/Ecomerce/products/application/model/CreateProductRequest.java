package co.com.ias.Ecomerce.products.application.model;

import co.com.ias.Ecomerce.commons.operation.ApplicationRequest;

import java.util.Objects;

public class CreateProductRequest implements ApplicationRequest {
    private String name;
    private String description;
    private String basePrice;
    private String taxRate;
    private String productStatus;
    private String inventoryQuantity;
    private String idProduct;

    public CreateProductRequest() {
    }

    public CreateProductRequest(String idProduct, String name, String description, String basePrice, String taxRate, String productStatus, String inventoryQuantity) {
        this.idProduct=idProduct;
        this.name = name;
        this.description = description;
        this.basePrice = basePrice;
        this.taxRate = taxRate;
        this.productStatus = productStatus;
        this.inventoryQuantity = inventoryQuantity;

    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getBasePrice() {
        return basePrice;
    }

    public String getTaxRate() {
        return taxRate;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBasePrice(String basePrice) {
        this.basePrice = basePrice;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public void setInventoryQuantity(String inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }
    public String getInventoryQuantity() {
        return inventoryQuantity;
    }

    @Override
    public String toString() {
        return "CreateProductRequest{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", basePrice='" + basePrice + '\'' +
                ", taxRate='" + taxRate + '\'' +
                ", productStatus='" + productStatus + '\'' +
                ", inventoryQuantity='" + inventoryQuantity + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateProductRequest that = (CreateProductRequest) o;
        return name.equals(that.name) &&
                description.equals(that.description) &&
                basePrice.equals(that.basePrice) &&
                taxRate.equals(that.taxRate) &&
                productStatus.equals(that.productStatus) &&
                inventoryQuantity.equals(that.inventoryQuantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, basePrice, taxRate, productStatus, inventoryQuantity);
    }


}


package com.zitrus.stock.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zitrus.stock.entities.enums.ProductType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Campo 'code' é requerido.")
    private Long code;
    @NotNull(message = "Campo 'description' é requerido.")
    private String description;
    @NotNull(message = "Campo 'type' é requerido.")
    @Enumerated(EnumType.STRING)
    private ProductType typeProduct;
    @JsonProperty("value")
    @NotNull(message = "Campo 'value' é requerido.")
    private Double valueProvider;
    @NotNull(message = "Campo 'amount' é requerido.")
    private Long amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductType getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(ProductType typeProduct) {
        this.typeProduct = typeProduct;
    }

    public Double getValueProvider() {
        return valueProvider;
    }

    public void setValueProvider(Double valueProvider) {
        this.valueProvider = valueProvider;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}

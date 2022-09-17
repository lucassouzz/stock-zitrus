package com.zitrus.stock.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zitrus.stock.entities.enums.ProductType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Produto")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Campo 'code' é requerido.")
    private Long code;
    @NotEmpty(message = "Campo 'description' é requerido.")
    private String description;
    @NotEmpty(message = "Campo 'type' é requerido.")
    private ProductType type;
    @JsonProperty("value")
    @NotEmpty(message = "Campo 'value' é requerido.")
    private Double valueProvider;
    @NotEmpty(message = "Campo 'amount' é requerido.")
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

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
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

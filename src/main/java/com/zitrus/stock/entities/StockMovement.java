package com.zitrus.stock.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zitrus.stock.entities.enums.MovementType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "Movimento")
public class StockMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @JsonIgnore
    private MovementType movementType;
    @NotNull(message = "Campo 'saleValue' é requerido.")
    private Double saleValue;
    @NotNull(message = "Campo 'saleDate' é requerido.")
    private LocalDate saleDate;
    @NotNull(message = "Campo 'movementAmount' é requerido.")
    private Long movementAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public MovementType getMovementType() {
        return movementType;
    }

    public void setMovementType(MovementType movementType) {
        this.movementType = movementType;
    }

    public Double getSaleValue() {
        return saleValue;
    }

    public void setSaleValue(Double saleValue) {
        this.saleValue = saleValue;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public Long getMovementAmount() {
        return movementAmount;
    }

    public void setMovementAmount(Long movementAmount) {
        this.movementAmount = movementAmount;
    }
}

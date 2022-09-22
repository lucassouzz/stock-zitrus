package com.zitrus.stock.dtos.product;

import java.io.Serializable;

public class FilterTypeProductDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String description;
    private Long sumMovementAmount;
    private Long available;

    public FilterTypeProductDTO(Long id, String description, Long sumMovementAmount, Long available) {
        this.id = id;
        this.description = description;
        this.sumMovementAmount = sumMovementAmount;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSumMovementAmount() {
        return sumMovementAmount;
    }

    public void setSumMovementAmount(Long sumMovementAmount) {
        this.sumMovementAmount = sumMovementAmount;
    }

    public Long getAvailable() {
        return available;
    }

    public void setAvailable(Long available) {
        this.available = available;
    }
}

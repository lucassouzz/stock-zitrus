package com.zitrus.stock.dtos.product;

public class FilterGainProductDTO {

    private Long productId;
    private String productDescription;
    private Long totalOutput;
    private Double totalGainProduct;
    private Double meanGainSale;

    public FilterGainProductDTO(Long productId, String productDescription, Long totalOutput, Double totalGainProduct) {
        this.productId = productId;
        this.productDescription = productDescription;
        this.totalOutput = totalOutput;
        this.totalGainProduct = totalGainProduct;
        this.meanGainSale = totalGainProduct / totalOutput;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Long getTotalOutput() {
        return totalOutput;
    }

    public void setTotalOutput(Long totalOutput) {
        this.totalOutput = totalOutput;
    }

    public Double getTotalGainProduct() {
        return totalGainProduct;
    }

    public void setTotalGainProduct(Double totalGainProduct) {
        this.totalGainProduct = totalGainProduct;
    }

    public Double getMeanGainSale() {
        return meanGainSale;
    }

    public void setMeanGainSale(Double meanGainSale) {
        this.meanGainSale = meanGainSale;
    }
}

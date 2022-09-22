package com.zitrus.stock.repositories;

import com.zitrus.stock.dtos.product.FilterGainProductDTO;
import com.zitrus.stock.dtos.product.FilterTypeProductDTO;
import com.zitrus.stock.entities.Product;
import com.zitrus.stock.entities.enums.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT new com.zitrus.stock.dtos.product.FilterTypeProductDTO(p.id, p.description, SUM(m.movementAmount), p.amount) " +
            "FROM Product AS p JOIN StockMovement AS m ON p.id = m.product.id " +
            "WHERE p.typeProduct = :productType " +
            "AND m.movementType = 'OUTPUT' " +
            "GROUP BY p.description")
    public List<FilterTypeProductDTO> filterByType(@Param("productType") ProductType productType);

    @Query("SELECT new com.zitrus.stock.dtos.product.FilterGainProductDTO(p.id, p.description, sum(m.movementAmount), (sum(m.saleValue) - sum(p.valueProvider))) " +
            "FROM Product AS p JOIN StockMovement AS m ON p.id = m.product.id " +
            "WHERE p.id = :productId AND m.movementType = 'OUTPUT'")
    public FilterGainProductDTO filterByGain(@Param("productId") Long productId);

}

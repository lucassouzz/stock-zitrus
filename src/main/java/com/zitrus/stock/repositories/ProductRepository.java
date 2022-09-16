package com.zitrus.stock.repositories;

import com.zitrus.stock.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

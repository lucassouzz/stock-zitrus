package com.zitrus.stock.services;

import com.zitrus.stock.entities.Product;
import com.zitrus.stock.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findProduct(){
        return repository.findAll();
    }

    public Product deleteById(Long id) {
        Product object = repository.findById(id).get();
        repository.deleteById(id);
        return object;
    }
}

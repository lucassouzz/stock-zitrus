package com.zitrus.stock.controllers;

import com.zitrus.stock.entities.Product;
import com.zitrus.stock.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/findProduct")
    public List<Product> findProduct(){
        return service.findProduct();
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity<Product> deleteById(@PathVariable Long id){
        Product object = service.deleteById(id);
        return ResponseEntity.ok().body(object);
    }


}

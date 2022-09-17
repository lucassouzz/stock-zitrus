package com.zitrus.stock.controllers;

import com.zitrus.stock.entities.Product;
import com.zitrus.stock.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping(value = "/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product newProduct){
        newProduct = service.createProduct(newProduct);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newProduct.getId()).toUri();
        return ResponseEntity.created(uri).body(newProduct);
    }

    @GetMapping(value = "/findAll")
    public List<Product> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<Product> findById (@PathVariable Long id){
        Product product = service.findById(id);
        return ResponseEntity.ok().body(product);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity<Product> deleteById(@PathVariable Long id){
        Product object = service.deleteById(id);
        return ResponseEntity.ok().body(object);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Product> update (@PathVariable Long id, @RequestBody Product product){
        Product productUpdate = service.update(id, product);
        return ResponseEntity.ok().body(productUpdate);
    }

}

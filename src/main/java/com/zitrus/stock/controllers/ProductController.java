package com.zitrus.stock.controllers;

import com.zitrus.stock.dtos.product.FilterGainProductDTO;
import com.zitrus.stock.dtos.product.FilterTypeProductDTO;
import com.zitrus.stock.entities.Product;
import com.zitrus.stock.entities.enums.ProductType;
import com.zitrus.stock.services.ProductService;
import com.zitrus.stock.services.TokenService;
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
    @Autowired
    private TokenService tokenService;

    @PostMapping(value = "/create")
    public ResponseEntity<Product> createProduct(
            @RequestBody Product newProduct,
            @RequestHeader String Authorization) {
        tokenService.validate(Authorization.replace("Bearer ", ""));
        newProduct = service.createProduct(newProduct);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newProduct.getId()).toUri();
        return ResponseEntity.created(uri).body(newProduct);
    }

    @GetMapping(value = "/findAll")
    public List<Product> findAll(@RequestHeader String Authorization) {
        tokenService.validate(Authorization.replace("Bearer ", ""));
        return service.findAll();
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<Product> findById(
            @PathVariable Long id,
            @RequestHeader String Authorization) {
        tokenService.validate(Authorization.replace("Bearer ", ""));
        Product product = service.findById(id);
        return ResponseEntity.ok().body(product);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity<Product> deleteById(
            @PathVariable Long id,
            @RequestHeader String Authorization) {
        tokenService.validate(Authorization.replace("Bearer ", ""));
        Product object = service.deleteById(id);
        return ResponseEntity.ok().body(object);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Product> update(
            @PathVariable Long id,
            @RequestBody Product product,
            @RequestHeader String Authorization) {
        tokenService.validate(Authorization.replace("Bearer ", ""));
        Product productUpdate = service.update(id, product);
        return ResponseEntity.ok().body(productUpdate);
    }

    @GetMapping(value = "/filterByType")
    public ResponseEntity<List<FilterTypeProductDTO>> filterByType(
            @RequestParam(value = "type", defaultValue = "") ProductType type,
            @RequestHeader String Authorization) {
        tokenService.validate(Authorization.replace("Bearer ", ""));
        List<FilterTypeProductDTO> result = service.filterByType(type);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping(value = "/filterByGain/{id}")
    public ResponseEntity<FilterGainProductDTO> filterByGain(
            @PathVariable Long id,
            @RequestHeader String Authorization) {
        tokenService.validate(Authorization.replace("Bearer ", ""));
        FilterGainProductDTO result = service.filterByGain(id);
        return ResponseEntity.ok().body(result);
    }

}
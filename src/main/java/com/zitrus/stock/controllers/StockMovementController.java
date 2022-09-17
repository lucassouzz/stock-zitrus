package com.zitrus.stock.controllers;

import com.zitrus.stock.entities.Product;
import com.zitrus.stock.entities.StockMovement;
import com.zitrus.stock.services.StockMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/stockMovement")
public class StockMovementController {

    @Autowired
    private StockMovementService service;

    @PostMapping(value = "/output/{productId}")
    public ResponseEntity<StockMovement> output (@PathVariable Long productId, @RequestBody StockMovement movement){
        StockMovement m = service.output(productId, movement);
        return ResponseEntity.ok().body(m);
    }

    @PostMapping(value = "/input/{productId}")
    public ResponseEntity<StockMovement> input (@PathVariable Long productId, @RequestBody StockMovement movement){
        StockMovement m = service.input(productId, movement);
        return ResponseEntity.ok().body(m);
    }


}

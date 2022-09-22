package com.zitrus.stock.services;

import com.zitrus.stock.entities.Product;
import com.zitrus.stock.entities.StockMovement;
import com.zitrus.stock.entities.enums.MovementType;
import com.zitrus.stock.repositories.StockMovementRepository;
import com.zitrus.stock.services.exceptions.AmountNegativeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockMovementService {

    @Autowired
    private StockMovementRepository repository;

    @Autowired
    ProductService serviceProduct;

    public StockMovement input(Long productId, StockMovement movement) {

        Product product = serviceProduct.findById(productId);
        product.setAmount(product.getAmount() + movement.getMovementAmount());
        serviceProduct.update(productId, product);

        movement.setProduct(product);
        movement.setMovementType(MovementType.INPUT);
        return repository.save(movement);
    }

    public StockMovement output(Long productId, StockMovement movement) {

        Product product = serviceProduct.findById(productId);
        Long amaountResult = product.getAmount() - movement.getMovementAmount();
        if (amaountResult < 0) {
            throw new AmountNegativeException("Saldo desejado indisponível, " +
                    "o saldo disponível é de " + product.getAmount() + " unidades.");
        }
        product.setAmount(amaountResult);
        serviceProduct.update(productId, product);

        movement.setProduct(product);
        movement.setMovementType(MovementType.OUTPUT);
        return repository.save(movement);
    }
}

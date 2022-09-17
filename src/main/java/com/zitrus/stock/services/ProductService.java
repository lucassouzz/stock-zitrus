package com.zitrus.stock.services;

import com.zitrus.stock.entities.Product;
import com.zitrus.stock.repositories.ProductRepository;
import com.zitrus.stock.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product createProduct(Product newProduct) {
        newProduct.setId(null);
        return repository.save(newProduct);
    }
    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long id){
        Product product = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Objeto nao encontrado id:" + id));
        return product;
    }
    public Product deleteById(Long id) {
        Product object = this.findById(id);
        repository.deleteById(id);
        return object;
    }


    public Product update(Long id, Product product) {
        Product productUpdate = this.findById(id);

        productUpdate.setCode(product.getCode());
        productUpdate.setDescription(product.getDescription());
        productUpdate.setAmount(product.getAmount());
        productUpdate.setType(product.getType());
        productUpdate.setValueProvider(product.getValueProvider());
        return repository.save(productUpdate);
    }
}

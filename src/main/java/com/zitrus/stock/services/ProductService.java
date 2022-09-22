package com.zitrus.stock.services;

import com.zitrus.stock.dtos.product.FilterGainProductDTO;
import com.zitrus.stock.dtos.product.FilterTypeProductDTO;
import com.zitrus.stock.entities.Product;
import com.zitrus.stock.entities.enums.ProductType;
import com.zitrus.stock.repositories.ProductRepository;
import com.zitrus.stock.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product createProduct(Product newProduct) {
        newProduct.setId(null);
        return repository.save(newProduct);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Objeto nao encontrado id: " + id));
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
        productUpdate.setTypeProduct(product.getTypeProduct());
        productUpdate.setValueProvider(product.getValueProvider());
        return repository.save(productUpdate);
    }

    public List<FilterTypeProductDTO> filterByType(ProductType type) {
        List<FilterTypeProductDTO> resultByType = new ArrayList<>();
        resultByType = repository.filterByType(type);
        return resultByType;
    }

    public FilterGainProductDTO filterByGain(Long id) {
        return repository.filterByGain(id);
    }
}

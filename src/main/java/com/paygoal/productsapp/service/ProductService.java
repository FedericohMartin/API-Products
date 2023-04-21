package com.paygoal.productsapp.service;

import com.paygoal.productsapp.dto.ProductInDTO;
import com.paygoal.productsapp.mapper.ProductInDTOToProduct;
import com.paygoal.productsapp.persistence.entity.Product;
import com.paygoal.productsapp.persistence.repository.ProductRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductInDTOToProduct mapper;
    public ProductService(ProductRepository repository, ProductInDTOToProduct mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Product createProduct(ProductInDTO productInDTO) {
        Product product = mapper.map(productInDTO);
        return repository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        Product existingProduct = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found - Product ID: " + id));
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        return repository.save(existingProduct);
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product findProductById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found - Product ID: " + id));
    }

    public List<Product> findProductByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    public List<Product> findProductsByPriceOrderedByAsc() {
        return repository.findAllByOrderByPriceAsc();
    }
}

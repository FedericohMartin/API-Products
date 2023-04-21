package com.paygoal.productsapp.controller;

import com.paygoal.productsapp.dto.ProductInDTO;
import com.paygoal.productsapp.mapper.ProductInDTOToProduct;
import com.paygoal.productsapp.persistence.entity.Product;
import com.paygoal.productsapp.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ProductInDTOToProduct mapper;

    public ProductController(ProductService productService, ProductInDTOToProduct mapper) {
        this.productService = productService;
        this.mapper = mapper;
    }

    @PostMapping("/createProduct")
    public Product createProduct(@RequestBody ProductInDTO productInDTO) {
        return productService.createProduct(productInDTO);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable Long id) {
        return productService.findProductById(id);
    }

    @GetMapping("/searchbyname/{name}")
    public List<Product> findProducts(@PathVariable String name) {
        return productService.findProductByName(name);
    }

    @GetMapping("/orderByPrice")
    public List<Product> getProductsByPriceAsc() {
        return productService.findProductsByPriceOrderedByAsc();
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
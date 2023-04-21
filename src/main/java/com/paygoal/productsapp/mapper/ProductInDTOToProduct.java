package com.paygoal.productsapp.mapper;

import com.paygoal.productsapp.dto.ProductInDTO;
import com.paygoal.productsapp.persistence.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductInDTOToProduct implements IMapper<ProductInDTO, Product>{

    @Override
    public Product map(ProductInDTO in) {
        Product product = new Product();
        product.setName(in.getName());
        product.setDescription(in.getDescription());
        product.setPrice(in.getPrice());
        product.setQuantity(in.getQuantity());
        return product;
    }
}

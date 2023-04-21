package com.paygoal.productsapp.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class ProductInDTO {
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
}

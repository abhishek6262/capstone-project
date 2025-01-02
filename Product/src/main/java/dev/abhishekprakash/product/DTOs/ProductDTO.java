package dev.abhishekprakash.product.DTOs;

import java.math.BigDecimal;

import lombok.Value;

@Value
public class ProductDTO {

    Integer id;

    String title;

    BigDecimal price;

    String category;

    String description;

    String image;

}
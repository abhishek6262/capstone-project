package dev.abhishekprakash.product.DTOs;

import lombok.Data;

@Data
public class ProductDTO {

    Integer id;

    String title;

    String price;

    String category;

    String description;

    String image;

    Rating rating;

    @Data
    static class Rating {

        Float rate;

        Integer count;

    }

}
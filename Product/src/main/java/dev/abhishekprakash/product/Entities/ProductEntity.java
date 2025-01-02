package dev.abhishekprakash.product.Entities;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String title;

    BigDecimal price;

    String category;

    String description;

    String image;

}
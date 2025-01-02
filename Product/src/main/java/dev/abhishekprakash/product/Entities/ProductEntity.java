package dev.abhishekprakash.product.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String title;

    Double price;

    String category;

    String description;

    String image;

}
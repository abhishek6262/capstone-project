package dev.abhishekprakash.cart.Entities;

import lombok.Value;

import java.io.Serializable;

@Value
public class CartItemEntity implements Serializable {

    String productName;

    Integer quantity;

    public CartItemEntity(String productName, Integer quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

}
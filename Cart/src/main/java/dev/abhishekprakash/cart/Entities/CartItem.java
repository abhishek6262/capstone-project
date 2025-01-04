package dev.abhishekprakash.cart.Entities;

import lombok.Value;

import java.io.Serializable;

@Value
public class CartItem implements Serializable {

    Long productId;

    Integer quantity;

}
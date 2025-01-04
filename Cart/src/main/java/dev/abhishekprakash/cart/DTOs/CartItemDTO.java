package dev.abhishekprakash.cart.DTOs;

import lombok.Value;

@Value
public class CartItemDTO {
    Long productId;

    Integer quantity;
}
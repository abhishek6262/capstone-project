package dev.abhishekprakash.cart.DTOs;

import lombok.Value;

@Value
public class AddCartItemDTO {

    Long productId;

    Integer quantity;

}
package dev.abhishekprakash.cart.DTOs;

import lombok.Value;

import java.io.Serializable;

@Value
public class AddCartItemDTO implements Serializable {

    Long productId;

    Integer quantity;

}
package dev.abhishekprakash.cart.Entities;

import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;

@Value
public class CartItemEntity implements Serializable {

    String productTitle;

    Integer quantity;

    BigDecimal totalPrice;

    public CartItemEntity(String productTitle, Integer quantity, BigDecimal totalPrice) {
        this.productTitle = productTitle;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

}
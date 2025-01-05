package dev.abhishekprakash.cart.Services;

import dev.abhishekprakash.cart.DTOs.AddCartItemDTO;
import dev.abhishekprakash.cart.Entities.CartItemEntity;
import dev.abhishekprakash.cart.Repositories.CartRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public HashMap<Object, Object> getCartItems(Long userId) {
        return cartRepository.getCartItems(userId);
    }

    public void addCartItem(Long userId, AddCartItemDTO addCartItemDTO) {
        Long productId = addCartItemDTO.getProductId();
        Integer quantity = addCartItemDTO.getQuantity();

        CartItemEntity cartItemEntity = new CartItemEntity("Product Name", quantity);

        cartRepository.addCartItem(userId, productId, cartItemEntity);
    }

}
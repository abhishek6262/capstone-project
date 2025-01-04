package dev.abhishekprakash.cart.Services;

import dev.abhishekprakash.cart.DTOs.AddCartItemDTO;
import dev.abhishekprakash.cart.DTOs.CartItemDTO;
import dev.abhishekprakash.cart.Mappers.CartItemMapper;
import dev.abhishekprakash.cart.Repositories.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartItemMapper cartItemMapper;
    private final CartRepository cartRepository;

    public CartService(CartItemMapper cartItemMapper, CartRepository cartRepository) {
        this.cartItemMapper = cartItemMapper;
        this.cartRepository = cartRepository;
    }

    public List<CartItemDTO> getCartItems(Long userId) {
        return cartRepository.getCartItems(userId)
                .stream()
                .map(cartItemMapper::toResponseDto)
                .toList();
    }

    public void addCartItem(Long userId, AddCartItemDTO addCartItemDTO) {
        cartRepository.addCartItem(userId, cartItemMapper.fromRequest(addCartItemDTO));
    }

}
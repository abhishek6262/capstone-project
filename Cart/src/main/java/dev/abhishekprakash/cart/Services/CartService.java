package dev.abhishekprakash.cart.Services;

import dev.abhishekprakash.cart.Clients.ProductServiceClient;
import dev.abhishekprakash.cart.DTOs.AddCartItemDTO;
import dev.abhishekprakash.cart.DTOs.ProductDTO;
import dev.abhishekprakash.cart.Entities.CartItemEntity;
import dev.abhishekprakash.cart.Repositories.CartRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;

@Service
public class CartService {

    private final CartRepository cartRepository;

    private final ProductServiceClient productServiceClient;

    public CartService(CartRepository cartRepository, ProductServiceClient productServiceClient) {
        this.cartRepository = cartRepository;
        this.productServiceClient = productServiceClient;
    }

    public HashMap<Object, Object> getCartItems(Long userId) {
        return cartRepository.getCartItems(userId);
    }

    public void addCartItem(Long userId, AddCartItemDTO addCartItemDTO) {
        Long productId = addCartItemDTO.getProductId();

        ProductDTO productDTO = productServiceClient.getProductById(productId);

        if (productDTO == null) {
            throw new RuntimeException("Product not found");
        }

        String productTitle = productDTO.getTitle();
        Integer quantity = addCartItemDTO.getQuantity();
        BigDecimal totalPrice = productDTO.getPrice().multiply(BigDecimal.valueOf(quantity));

        CartItemEntity cartItemEntity = new CartItemEntity(
                productTitle,
                quantity,
                totalPrice
        );

        cartRepository.addCartItem(userId, productId, cartItemEntity);
    }

    public void removeCartItem(Long userId, Long productId) {
        cartRepository.removeCartItem(userId, productId);
    }

}
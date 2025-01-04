package dev.abhishekprakash.cart.Repositories;

import dev.abhishekprakash.cart.Entities.CartItem;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartRepository {

    private final RedisTemplate<String, Object> redisTemplate;

    public CartRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public List<CartItem> getCartItems(Long userId) {
        List<Object> cartItems = redisTemplate.opsForList().range(userId.toString(), 0, -1);

        if (cartItems == null) return List.of();

        return cartItems.stream().map(CartItem.class::cast).toList();
    }

    public void addCartItem(Long userId, CartItem cartItem) {
        redisTemplate.opsForList().rightPush(userId.toString(), cartItem);
    }

}
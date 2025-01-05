package dev.abhishekprakash.cart.Repositories;

import dev.abhishekprakash.cart.Entities.CartItemEntity;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class CartRepository {

    private final RedisTemplate<Object, Object> redisTemplate;

    public CartRepository(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public HashMap<Object, Object> getCartItems(Long userId) {
        return (HashMap<Object, Object>) redisTemplate.opsForHash().entries(userId);
    }

    public void addCartItem(Long userId, Long productId, CartItemEntity cartItemEntity) {
        redisTemplate.opsForHash().put(userId, productId, cartItemEntity);
    }

}
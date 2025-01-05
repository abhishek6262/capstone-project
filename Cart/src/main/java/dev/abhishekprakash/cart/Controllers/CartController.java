package dev.abhishekprakash.cart.Controllers;

import dev.abhishekprakash.cart.DTOs.AddCartItemDTO;
import dev.abhishekprakash.cart.Services.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/cart/{userId}")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public ResponseEntity<HashMap<Object, Object>> getCartItems(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(cartService.getCartItems(userId));
    }

    @PostMapping
    public ResponseEntity<String> addCartItem(
            @PathVariable("userId") Long userId,
            @RequestBody AddCartItemDTO addCartItemDTO
    ) {
        cartService.addCartItem(userId, addCartItemDTO);

        return ResponseEntity.ok("Added item to cart");
    }

    @DeleteMapping
    public ResponseEntity<String> removeCartItem(
            @PathVariable("userId") Long userId,
            @RequestParam Long productId
    ) {
        cartService.removeCartItem(userId, productId);

        return ResponseEntity.ok("Removed item from cart");
    }

}
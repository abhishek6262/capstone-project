package dev.abhishekprakash.cart.Controllers;

import dev.abhishekprakash.cart.DTOs.AddCartItemDTO;
import dev.abhishekprakash.cart.DTOs.CartItemDTO;
import dev.abhishekprakash.cart.Services.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public ResponseEntity<List<CartItemDTO>> getCart(@RequestParam("userId") Long userId) {
        List<CartItemDTO> cartItemEntities = cartService.getCartItems(userId);

        return ResponseEntity.ok(cartItemEntities);
    }

    @PostMapping
    public ResponseEntity<String> addItemToCart(@RequestParam("userId") Long userId, @RequestBody AddCartItemDTO addCartItemDTO) {
        cartService.addCartItem(userId, addCartItemDTO);

        return ResponseEntity.ok("Item added to cart");
    }

}
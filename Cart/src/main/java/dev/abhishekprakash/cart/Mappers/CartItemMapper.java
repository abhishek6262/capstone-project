package dev.abhishekprakash.cart.Mappers;

import dev.abhishekprakash.cart.DTOs.AddCartItemDTO;
import dev.abhishekprakash.cart.DTOs.CartItemDTO;
import dev.abhishekprakash.cart.Entities.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartItemMapper {

    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "quantity", target = "quantity")
    CartItem fromRequest(AddCartItemDTO addCartItemDTO);

    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "quantity", target = "quantity")
    CartItemDTO toResponseDto(CartItem cartItem);

}
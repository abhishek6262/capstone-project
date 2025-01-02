package dev.abhishekprakash.product.DTOs;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CategoryResponseDTO {

    private Long id;

    private String name;

}
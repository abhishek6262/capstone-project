package dev.abhishekprakash.cart.Clients;

import dev.abhishekprakash.cart.DTOs.ProductDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductServiceClient {

    private final String BASE_PRODUCTS_URL = "http://localhost:8083/api/v1/products";

    private final RestTemplate restTemplate;

    public ProductServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ProductDTO getProductById(Long productId) {
        return restTemplate.getForObject("http://localhost:8083/api/v1/products/1", ProductDTO.class);
    }

}
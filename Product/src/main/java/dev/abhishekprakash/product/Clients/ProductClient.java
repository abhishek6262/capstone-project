package dev.abhishekprakash.product.Clients;

import dev.abhishekprakash.product.DTOs.ProductDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ProductClient {

    private final String PRODUCTS_URL = "https://fakestoreapi.com/products";

    private final RestTemplate restTemplate;

    public ProductClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ProductDTO> getProducts(int page, int limit) {
        try {
            ProductDTO[] products = restTemplate.getForObject(PRODUCTS_URL, ProductDTO[].class);

            if (products == null) {
                throw new RestClientException("Failed to fetch the products received `null`");
            }

            return List.of(products);
        } catch (RestClientException e) {
            //
        }

        return List.of();
    }

    public List<ProductDTO> getProductsByCategory(String productCategory, int page, int limit) {
        try {
            ProductDTO[] products = restTemplate.getForObject(PRODUCTS_URL + "/category/" + productCategory, ProductDTO[].class);

            if (products == null) {
                throw new RestClientException("Failed to fetch the products received `null`");
            }

            return List.of(products);
        } catch (RestClientException e) {
            //
        }

        return List.of();
    }

}
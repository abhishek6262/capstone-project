package dev.abhishekprakash.product.Clients;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductCategoryClient {

    private final String PRODUCT_CATEGORIES_URL = "https://fakestoreapi.com/products/categories";

    private final RestTemplate restTemplate;

    public ProductCategoryClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<String> getProductCategories() {
        try {
            String[] productCategories = restTemplate.getForObject(PRODUCT_CATEGORIES_URL, String[].class);

            if (productCategories == null) {
                throw new RestClientException("Failed to fetch the product categories received `null`");
            }

            return Arrays.asList(productCategories);
        } catch (RestClientException e) {
            System.err.println("Failed to fetch the product categories: " + e.getMessage());
        }

        return List.of();
    }

}
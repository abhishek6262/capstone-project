package dev.abhishekprakash.product.Seeders;

import com.github.javafaker.Faker;
import dev.abhishekprakash.product.Entities.ProductEntity;
import dev.abhishekprakash.product.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductSeeder implements CommandLineRunner {

    private static final int BATCH_SIZE = 50;
    
    private final ProductRepository productRepository;
    private final Faker faker;

    @Value("${app.seeder.product-count:100}")
    private int productCount;

    public ProductSeeder(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.faker = new Faker();
    }

    @Override
    public void run(String... args) {
        seedProducts();
    }

    private void seedProducts() {
        int totalBatches = (int) Math.ceil((double) productCount / BATCH_SIZE);
        int seededCount = 0;

        for (int batch = 0; batch < totalBatches; batch++) {
            List<ProductEntity> products = new ArrayList<>();
            int batchSize = Math.min(BATCH_SIZE, productCount - seededCount);

            for (int i = 0; i < batchSize; i++) {
                products.add(ProductEntity.builder()
                    .title(faker.commerce().productName())
                    .description(faker.lorem().paragraph())
                    .price(new BigDecimal(faker.commerce().price().replaceAll(",", "")))
                    .category(faker.commerce().department())
                    .image(faker.internet().image())
                    .build());
            }

            productRepository.saveAll(products);

            seededCount += batchSize;
        }
    }

}

package dev.abhishekprakash.product.Seeders;

import com.github.javafaker.Faker;
import dev.abhishekprakash.product.Entities.CategoryEntity;
import dev.abhishekprakash.product.Entities.ProductEntity;
import dev.abhishekprakash.product.Repositories.CategoryRepository;
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

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final Faker faker;

    @Value("${app.seeder.product-count:100}")
    private int productCount;

    public ProductSeeder(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.faker = new Faker();
    }

    @Override
    public void run(String... args) {
        seedCategories();
        seedProducts();
    }

    private void seedCategories() {
        List<CategoryEntity> categories = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            CategoryEntity categoryEntity = new CategoryEntity();

            categoryEntity.setName(faker.commerce().department());

            categories.add(categoryEntity);
        }

        categoryRepository.saveAll(categories);
    }

    private void seedProducts() {
        int totalBatches = (int) Math.ceil((double) productCount / BATCH_SIZE);
        int seededCount = 0;

        List<CategoryEntity> categories = categoryRepository.findAll();

        for (int batch = 0; batch < totalBatches; batch++) {
            List<ProductEntity> products = new ArrayList<>();
            int batchSize = Math.min(BATCH_SIZE, productCount - seededCount);

            for (int i = 0; i < batchSize; i++) {
                // Get a random category
                CategoryEntity category = categories.get(faker.number().numberBetween(0, categories.size() - 1));

                products.add(ProductEntity.builder()
                        .title(faker.commerce().productName())
                        .description(faker.lorem().paragraph())
                        .price(new BigDecimal(faker.commerce().price().replaceAll(",", "")))
                        .category(category)
                        .image(faker.internet().image())
                        .build());
            }

            productRepository.saveAll(products);

            seededCount += batchSize;
        }
    }

}
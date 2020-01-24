package br.com.caioaraujo.shoppingcart.product;

import br.com.caioaraujo.shoppingcart.domain.Product;
import br.com.caioaraujo.shoppingcart.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;


@DataMongoTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
public class ProductTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveTest(){
        Product product = mongoTemplate.save(ProductHelper.getProductDefault());
        assertThat(this.productRepository.findById(product.getId())).isNotNull();
    }

    @Test
    void saveAllAndCount() {
        ProductHelper.getListProduct().stream().forEach(this.mongoTemplate::save);
        assertThat(this.productRepository.findAll()).hasSize(ProductHelper.getListProduct().size());
    }

    @BeforeEach
    void clearAllPRoducts(){
        this.productRepository.findAll().stream().forEach(this.productRepository::delete);
    }
}

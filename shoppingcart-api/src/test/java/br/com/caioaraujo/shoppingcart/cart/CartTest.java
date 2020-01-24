package br.com.caioaraujo.shoppingcart.cart;

import br.com.caioaraujo.shoppingcart.domain.Cart;
import br.com.caioaraujo.shoppingcart.domain.Product;
import br.com.caioaraujo.shoppingcart.product.ProductHelper;
import br.com.caioaraujo.shoppingcart.repository.CartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
public class CartTest {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private CartRepository cartRepository;

    @Test
    @Order(0)
    void saveTest() {
        this.cartRepository.findAll().stream().forEach(this.cartRepository::delete);
        Cart cart = this.mongoTemplate.save(CartHelper.getCartDefault());
        assertThat(this.cartRepository.findById(cart.getId()).isPresent()).isTrue();
    }

    @Test
    @Order(1)
    void putProductTest() {
        Cart cart = this.cartRepository.findAll().get(0);
        assertThat(cart.getCartProducts()).hasSize(0);
        Product productDarthVaderHelmet = ProductHelper.PRODUCT_DARTH_VADER_HELMET;
        cart.addProduct(productDarthVaderHelmet);
        assertThat(cart.getCartProducts()).hasSize(1);
        cart.addProduct(productDarthVaderHelmet);
        assertThat(cart.getCartProducts()).hasSize(1);
        cart.addProduct(productDarthVaderHelmet);
        assertThat(cart.getCartProducts()).hasSize(1);
    }

    @Test
    @Order(2)
    void putProductAndIncreaseTest() {
        Cart cart = this.cartRepository.findAll().get(0);
        assertThat(cart.getCartProducts()).hasSize(0);
        Product productMilleniunFalcon = ProductHelper.PRODUCT_MILLENIUN_FALCON;
        cart.addProduct(productMilleniunFalcon);
        assertThat(cart.getCartProducts()).hasSize(1);
        assertThat(cart.getCartProducts().get(0).getAmount()).isEqualByComparingTo(BigDecimal.ONE);
        cart.addProduct(productMilleniunFalcon);
        assertThat(cart.getCartProducts()).hasSize(1);
        assertThat(cart.getCartProducts().get(0).getAmount()).isEqualByComparingTo(BigDecimal.valueOf(2));
        cart.decreaseProduct(productMilleniunFalcon);
        assertThat(cart.getCartProducts()).hasSize(1);
        assertThat(cart.getCartProducts().get(0).getAmount()).isEqualByComparingTo(BigDecimal.ONE);
        Product productDroidR2D2 = ProductHelper.PRODUCT_DROID_R_2_D_2;
        cart.addProduct(productDroidR2D2);
        assertThat(cart.getCartProducts()).hasSize(2);
        assertThat(cart.getCartProducts().get(1).getAmount()).isEqualByComparingTo(BigDecimal.ONE);
        cart.addProduct(productDroidR2D2);
        assertThat(cart.getCartProducts()).hasSize(2);
        assertThat(cart.getCartProducts().get(1).getAmount()).isEqualByComparingTo(BigDecimal.valueOf(2));
        cart.decreaseProduct(productDroidR2D2);
        assertThat(cart.getCartProducts()).hasSize(2);
        assertThat(cart.getCartProducts().get(1).getAmount()).isEqualByComparingTo(BigDecimal.ONE);
        cart.decreaseProduct(productDroidR2D2);
        cart.removeWithZero();
        assertThat(cart.getCartProducts()).hasSize(1);
    }

    @Test
    @Order(3)
    void removeProductTest() {
        Cart cart = this.cartRepository.findAll().get(0);
        assertThat(cart.getCartProducts()).hasSize(0);
        List<Product> list = ProductHelper.getListProduct();
        list.stream().forEach(cart::addProduct);
        assertThat(cart.getCartProducts()).hasSize(list.size());
        list.stream().forEach(cart::removeProduct);
        assertThat(cart.getCartProducts()).hasSize(0);
    }

}

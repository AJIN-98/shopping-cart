package br.com.caioaraujo.shoppingcart.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Caio Araujo
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "carts")
public class Cart extends ADomain {

    private User user;
    private LocalDateTime createdAt;
    private CartStatus status;
    private List<CartProduct> cartProducts;

    public void addProduct(Product product) {
        if (Objects.isNull(cartProducts)) {
            this.cartProducts = new ArrayList<>();
        }
        if (containsProductOnCart(product)) {
            for (CartProduct cartProduct : cartProducts) {
                if (cartProduct.getProduct().getId().equals(product.getId())) {
                    cartProduct.increase();
                }
            }
        } else {
            this.cartProducts.add(
                    CartProduct.builder()
                            .product(product)
                            .amount(BigDecimal.ONE)
                            .build());
        }
    }

    public void removeWithZero() {
        for (int i = 0; i < this.cartProducts.size(); i++) {
            if (cartProducts.get(i).getAmount().compareTo(BigDecimal.ZERO)==0) {
                removeProduct(cartProducts.get(i).getProduct());
            }
        }
    }

    public void decreaseProduct(Product product) {
        if (Objects.nonNull(this.cartProducts)) {
            cartProducts.stream()
                    .filter(cartProduct -> cartProduct.getProduct().getId().equals(product.getId()))
                    .forEach(CartProduct::decrease);
        }
    }

    public void removeProduct(Product product) {
        if (Objects.nonNull(this.cartProducts)) {
            cartProducts.removeIf(cartProduct -> cartProduct.getProduct().getId().equals(product.getId()));
        }
    }

    private Boolean containsProductOnCart(Product product) {
        return cartProducts.stream()
                .map(CartProduct::getProduct)
                .anyMatch(prod -> prod.getId().equals(product.getId()));
    }

}

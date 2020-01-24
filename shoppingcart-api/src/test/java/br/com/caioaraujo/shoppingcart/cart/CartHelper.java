package br.com.caioaraujo.shoppingcart.cart;

import br.com.caioaraujo.shoppingcart.domain.Cart;
import br.com.caioaraujo.shoppingcart.domain.CartStatus;
import br.com.caioaraujo.shoppingcart.user.UserHelper;

import java.time.LocalDateTime;
import java.util.ArrayList;


public class CartHelper {

    public static Cart getCartDefault() {
        return Cart.builder()
                .user(UserHelper.getUserDefault())
                .status(CartStatus.OPEN)
                .createdAt(LocalDateTime.now())
                .cartProducts(new ArrayList<>())
                .build();
    }

}

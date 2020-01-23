package br.com.caioaraujo.shoppingcart.service;

import br.com.caioaraujo.shoppingcart.domain.Cart;
import br.com.caioaraujo.shoppingcart.domain.CartStatus;
import br.com.caioaraujo.shoppingcart.domain.Product;
import br.com.caioaraujo.shoppingcart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class CartService extends AService<Cart> {

    private CartRepository repository;
    private ProductService productService;

    @Autowired
    public CartService(CartRepository repository, ProductService productService) {
        super(repository);
        this.repository = repository;
        this.productService = productService;
    }

    public Cart findCartOrCreateNewCart() {
        Optional<Cart> optionalCart = this.repository.findByUser_IdAndStatus(getLoggedUser().getId(), CartStatus.OPEN);
        return optionalCart.orElseGet(() -> this.save(Cart.builder()
                .cartProducts(new ArrayList<>())
                .createdAt(LocalDateTime.now())
                .status(CartStatus.OPEN)
                .user(getLoggedUser())
                .build()));
    }

    public Cart putProductOnCurrentCart(String productId) {
        Cart cart = findCartOrCreateNewCart();
        Product product = productService.findById(productId);
        cart.addProduct(product);
        return save(cart);
    }

    public Cart decreaseProductOnCurrentCart(String productId) {
        Cart cart = findCartOrCreateNewCart();
        Product product = productService.findById(productId);
        cart.decreaseProduct(product);
        cart.removeWithZero();
        return save(cart);
    }

    public Cart removeProductOnCurrentCart(String productId) {
        Cart cart = findCartOrCreateNewCart();
        Product product = productService.findById(productId);
        cart.removeProduct(product);
        return save(cart);
    }

    public void finishCurrentCart(){
        Cart cart = findCartOrCreateNewCart();
        cart.setStatus(CartStatus.FINISH);
        this.save(cart);
    }
}

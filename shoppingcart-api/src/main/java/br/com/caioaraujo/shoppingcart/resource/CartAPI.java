package br.com.caioaraujo.shoppingcart.resource;

import br.com.caioaraujo.shoppingcart.domain.Cart;
import br.com.caioaraujo.shoppingcart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/cart")
public class CartAPI extends AResource<Cart> {

    private CartService service;

    @Autowired
    public CartAPI(CartService service) {
        super(service);
        this.service = service;
    }

    @GetMapping(path = "/current")
    public ResponseEntity getCurrentCart() {
        try {
            return ResponseEntity.ok(this.service.findCartOrCreateNewCart());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping(path = "/put-product/{productId}")
    public ResponseEntity putItemOnCart(@PathVariable String productId) {
        try {
            return ResponseEntity.ok(this.service.putProductOnCurrentCart(productId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping(path = "/decrease-product/{productId}")
    public ResponseEntity decreacreItemOnCart(@PathVariable String productId) {
        try {
            return ResponseEntity.ok(this.service.decreaseProductOnCurrentCart(productId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping(path = "/remove-product/{productId}")
    public ResponseEntity removeItemOnCart(@PathVariable String productId) {
        try {
            return ResponseEntity.ok(this.service.removeProductOnCurrentCart(productId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping(path = "/finish")
    public ResponseEntity finishCurrentCart() {
        try {
            this.service.finishCurrentCart();
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

}

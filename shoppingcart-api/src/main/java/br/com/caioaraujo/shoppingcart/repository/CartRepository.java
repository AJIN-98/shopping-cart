package br.com.caioaraujo.shoppingcart.repository;

import br.com.caioaraujo.shoppingcart.domain.Cart;
import br.com.caioaraujo.shoppingcart.domain.CartStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *
 * @author Caio Araujo
 */

@Repository
public interface CartRepository extends IRepository<Cart> {

    Optional<Cart> findByUser_IdAndStatus(String userId, CartStatus status);

}

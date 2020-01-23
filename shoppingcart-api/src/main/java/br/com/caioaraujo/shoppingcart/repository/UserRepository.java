package br.com.caioaraujo.shoppingcart.repository;

import br.com.caioaraujo.shoppingcart.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *
 * @author Caio Araujo
 */

@Repository
public interface UserRepository extends IRepository<User> {

    Boolean existsByEmail(String email);

    Optional<User> findByEmail(String username);

}

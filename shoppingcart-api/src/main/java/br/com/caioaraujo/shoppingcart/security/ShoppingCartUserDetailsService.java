package br.com.caioaraujo.shoppingcart.security;

import br.com.caioaraujo.shoppingcart.exception.UserNotFoundException;
import br.com.caioaraujo.shoppingcart.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Caio Araujo
 */

@Component
public class ShoppingCartUserDetailsService implements UserDetailsService {

    private UserService userService;

    public ShoppingCartUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userService.findByUsername(username).orElseThrow(UserNotFoundException::new);
    }
}

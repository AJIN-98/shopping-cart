package br.com.caioaraujo.shoppingcart.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Caio Araujo
 */

public class UserNotFoundException extends UsernameNotFoundException {
    public UserNotFoundException() {
        super("Username not found. Try again!");
    }
}

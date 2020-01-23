package br.com.caioaraujo.shoppingcart.exception;

import org.springframework.security.core.AuthenticationException;

/**
 *
 * @author Caio Araujo
 */

public class JwtAuthenticationException extends AuthenticationException {

    public JwtAuthenticationException(String e) {
        super(e);
    }
}
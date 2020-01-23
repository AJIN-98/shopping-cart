package br.com.caioaraujo.shoppingcart.exception;

/**
 *
 * @author Caio Araujo
 */

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("ID not found on database!");
    }
}

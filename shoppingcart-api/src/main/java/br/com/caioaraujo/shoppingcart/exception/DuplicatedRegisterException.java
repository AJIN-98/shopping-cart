package br.com.caioaraujo.shoppingcart.exception;

/**
 *
 * @author Caio Araujo
 */

public class DuplicatedRegisterException extends RuntimeException {

    public DuplicatedRegisterException() {
        super("Already exists in the database!");
    }
}

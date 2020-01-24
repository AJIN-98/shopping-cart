package br.com.caioaraujo.shoppingcart.service;

import br.com.caioaraujo.shoppingcart.domain.ADomain;

import java.util.List;

/**
 *
 * @author Caio Araujo
 */

public interface IService<T extends ADomain> {

    T save(T object);

    void delete(String id);

    void delete(T object);

    List<T> listAll();

    T findById(String id);

}

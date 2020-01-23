package br.com.caioaraujo.shoppingcart.service;

import br.com.caioaraujo.shoppingcart.domain.ADomain;

import java.util.List;

/**
 *
 * @author Caio Araujo
 */

public interface IService<T extends ADomain> {

    public T save(T object);

    public void delete(String id);

    public List<T> listAll();

    public T findById(String id);

}

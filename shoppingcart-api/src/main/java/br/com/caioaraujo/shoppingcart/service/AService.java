package br.com.caioaraujo.shoppingcart.service;

import br.com.caioaraujo.shoppingcart.domain.ADomain;
import br.com.caioaraujo.shoppingcart.domain.User;
import br.com.caioaraujo.shoppingcart.exception.NotFoundException;
import br.com.caioaraujo.shoppingcart.repository.IRepository;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

/**
 * @author Caio Araujo
 */

public class AService<T extends ADomain> implements IService<T> {

    private IRepository<T> repository;

    public AService(IRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public T save(T object) {
        return this.repository.save(object);
    }

    @Override
    public void delete(String id) {
        this.repository.deleteById(id);
    }

    @Override
    public void delete(T object) {
        this.repository.delete(object);
    }

    @Override
    public List<T> listAll() {
        return this.repository.findAll();
    }

    @Override
    public T findById(String id) {
        return this.repository.findById(id).orElseThrow(NotFoundException::new);
    }

    public User getLoggedUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}

package br.com.caioaraujo.shoppingcart.service;

import br.com.caioaraujo.shoppingcart.domain.Product;
import br.com.caioaraujo.shoppingcart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Caio Araujo
 */

@Service
public class ProductService extends AService<Product> {

    @Autowired
    public ProductService(ProductRepository repository) {
        super(repository);
    }

    @Override
    public Product save(Product object) {
        return super.save(object);
    }

    @Override
    public void delete(String id) {

        super.delete(id);
    }
}

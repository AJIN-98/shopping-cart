package br.com.caioaraujo.shoppingcart.repository;

import br.com.caioaraujo.shoppingcart.domain.ADomain;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Caio Araujo
 */

public interface IRepository<T extends ADomain> extends MongoRepository<T, String> {
}

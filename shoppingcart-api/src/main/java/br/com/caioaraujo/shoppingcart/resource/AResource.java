package br.com.caioaraujo.shoppingcart.resource;

import br.com.caioaraujo.shoppingcart.domain.ADomain;
import br.com.caioaraujo.shoppingcart.exception.NotFoundException;
import br.com.caioaraujo.shoppingcart.service.AService;
import com.mongodb.MongoException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Caio Araujo
 */

public abstract class AResource<T extends ADomain> {

    private AService<T> service;

    public AResource(AService<T> service) {
        this.service = service;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getById(@PathVariable("id") String id) {
        try {
            return ResponseEntity.ok(this.service.findById(id));
        } catch (NotFoundException | MongoException dbe) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(this.service.listAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity save(@RequestBody T object) {
        try {
            return ResponseEntity.ok(this.service.save(object));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity delete(@PathVariable String id) {
        try {
            this.service.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}

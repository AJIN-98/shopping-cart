package br.com.caioaraujo.shoppingcart.resource;

import br.com.caioaraujo.shoppingcart.domain.Product;
import br.com.caioaraujo.shoppingcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Caio Araujo
 */

@CrossOrigin
@RestController
@RequestMapping(path = "/products")
public class ProductAPI extends AResource<Product> {

    @Autowired
    public ProductAPI(ProductService service) {
        super(service);
    }

}

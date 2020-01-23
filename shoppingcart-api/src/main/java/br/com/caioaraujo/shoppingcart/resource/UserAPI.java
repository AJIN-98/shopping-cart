package br.com.caioaraujo.shoppingcart.resource;

import br.com.caioaraujo.shoppingcart.domain.User;
import br.com.caioaraujo.shoppingcart.service.UserService;
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
@RequestMapping(path = "/users")
public class UserAPI extends AResource<User> {

    @Autowired
    public UserAPI(UserService service) {
        super(service);
    }

}

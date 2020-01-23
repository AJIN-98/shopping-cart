package br.com.caioaraujo.shoppingcart.service;

import br.com.caioaraujo.shoppingcart.domain.User;
import br.com.caioaraujo.shoppingcart.exception.DuplicatedRegisterException;
import br.com.caioaraujo.shoppingcart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 *
 * @author Caio Araujo
 */

@Service
public class UserService extends AService<User> {

    private UserRepository repository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        super(repository);
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User save(User object) {
        if (alreadyContainsEmail(object.getEmail())) {
            throw new DuplicatedRegisterException();
        }
        object.setPassword(passwordEncoder.encode(object.getPassword()));
        return super.save(object);
    }

    public Optional<User> findByUsername(String username) {
        return this.repository.findByEmail(username);
    }

    private Boolean alreadyContainsEmail(String email) {
        return this.repository.existsByEmail(email);
    }
}

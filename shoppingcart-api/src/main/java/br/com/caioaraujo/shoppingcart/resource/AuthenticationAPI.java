package br.com.caioaraujo.shoppingcart.resource;

import br.com.caioaraujo.shoppingcart.domain.User;
import br.com.caioaraujo.shoppingcart.dto.AuthenticationRequest;
import br.com.caioaraujo.shoppingcart.dto.AuthenticationResponse;
import br.com.caioaraujo.shoppingcart.security.JwtProvider;
import br.com.caioaraujo.shoppingcart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author Caio Araujo
 */

@CrossOrigin
@RestController
@RequestMapping(path = "/auth")
public class AuthenticationAPI {

    private JwtProvider jwtProvider;
    private UserService userService;
    private AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationAPI(JwtProvider jwtProvider, UserService userService, AuthenticationManager authenticationManager) {
        this.jwtProvider = jwtProvider;
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping(path = "/test")
    public ResponseEntity test() {
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/signin")
    public ResponseEntity signIn(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(),
                            authenticationRequest.getPassword()));
            String token = jwtProvider.createToken(authenticationRequest.getUsername(), Arrays.asList("USER"));
            Optional<User> user = userService.findByUsername(authenticationRequest.getUsername());
            return ResponseEntity.ok(new AuthenticationResponse(token, user.get()));
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new BadCredentialsException("Invalid username/password supplied!"));
        }
    }

}
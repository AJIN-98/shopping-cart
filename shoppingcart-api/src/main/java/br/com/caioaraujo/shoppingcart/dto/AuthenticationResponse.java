package br.com.caioaraujo.shoppingcart.dto;

import br.com.caioaraujo.shoppingcart.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 * @author Caio Araujo
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse implements Serializable {

    private String idUser;
    private String email;
    private String username;
    private String token;

    public AuthenticationResponse(String token, User user) {
        this.idUser = user.getId();
        this.token = token;
        this.username = user.getName();
        this.email = user.getEmail();
    }

}

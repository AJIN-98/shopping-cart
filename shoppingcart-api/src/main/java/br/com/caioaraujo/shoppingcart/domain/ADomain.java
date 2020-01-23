package br.com.caioaraujo.shoppingcart.domain;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.util.UUID;

/**
 * This abstract class provide a id generator usign UUID from Java.util.UUID
 * The id attribute does not contain a setter because this way it`s possible prevent the id duplication
 *
 * @author Caio Araujo
 */

@Data
public abstract class ADomain {

    @Id
    @Getter
    private String id;

    public ADomain() {
        this.id = UUID.randomUUID().toString().replaceAll("-", "");
    }
}

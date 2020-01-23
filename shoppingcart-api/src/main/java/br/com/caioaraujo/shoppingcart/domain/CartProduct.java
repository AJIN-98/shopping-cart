package br.com.caioaraujo.shoppingcart.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author Caio Araujo
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cart_products")
public class CartProduct extends ADomain {

    private Product product;
    private BigDecimal amount;

    public void decrease() {
        if(Objects.isNull(amount)){
            this.amount = BigDecimal.ZERO;
        } else {
            if(this.amount.compareTo(BigDecimal.ZERO)>0) {
                this.amount = this.amount.subtract(BigDecimal.ONE);
            }
        }
    }

    public void increase() {
        if(Objects.isNull(amount)){
            this.amount = BigDecimal.ZERO;
        }
        this.amount = this.amount.add(BigDecimal.ONE);
    }

}

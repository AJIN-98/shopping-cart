package br.com.caioaraujo.shoppingcart.generic;

import br.com.caioaraujo.shoppingcart.domain.ADomain;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
public class GenericTests {

    @Test
    void aDomainTest() {
        ADomain aDomain = new ADomain() {
            @Override
            public String getId() {
                return super.getId();
            }
        };

        assertThat(aDomain.getId()).isNotNull();
        assertThat(aDomain.getId()).isNotBlank();

        final String TEST_ID = "TEST";
        aDomain.setId(TEST_ID);
        assertThat(aDomain.getId()).isEqualTo(TEST_ID);
    }



}

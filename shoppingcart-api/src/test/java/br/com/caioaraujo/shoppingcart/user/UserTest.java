package br.com.caioaraujo.shoppingcart.user;

import br.com.caioaraujo.shoppingcart.domain.User;
import br.com.caioaraujo.shoppingcart.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
public class UserTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserRepository userRepository;


    @Test
    void saveTest() {
        this.mongoTemplate.save(UserHelper.getUserDefault());
        assertThat(userRepository.findByEmail(UserHelper.EMAIL_USER_DEFAULT).isPresent()).isTrue();
    }

    @Test
    void saveList() {
        UserHelper.getListUser().stream().forEach(this.mongoTemplate::save);
        assertThat(this.userRepository.findAll()).hasSize(UserHelper.getListUser().size());
    }

    @Test
    void findByUUIDTest() {
        User userDefault = UserHelper.getUserDefault();
        this.mongoTemplate.save(userDefault);
        assertThat(this.userRepository.findById(userDefault.getId())).isNotNull();
    }

    @Test
    void finByEmailTest() {
        this.mongoTemplate.save(UserHelper.getUserDefault());
        assertThat(this.userRepository.findByEmail(UserHelper.EMAIL_USER_DEFAULT).isPresent()).isTrue();
    }

    @Test
    void testSecurityImplementation() {
        User user = UserHelper.getUserDefault();
        assertThat(user.getAuthorities()).size().isGreaterThan(0);
        assertThat(user.isEnabled()).isTrue();
        assertThat(user.isAccountNonExpired()).isTrue();
        assertThat(user.isAccountNonLocked()).isTrue();
        assertThat(user.isCredentialsNonExpired()).isTrue();
    }

    @BeforeEach
    private void clearAllUsers() {
        this.userRepository.findAll().stream().forEach(userRepository::delete);
    }

}

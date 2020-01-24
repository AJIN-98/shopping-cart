package br.com.caioaraujo.shoppingcart.user;

import br.com.caioaraujo.shoppingcart.domain.User;

import java.util.Arrays;
import java.util.List;

public class UserHelper {

    public static final String NAME_USER_DEFAULT = "Darth Vader";
    public static final String EMAIL_USER_DEFAULT = "empires@lightsaber.com";
    public static final String PASSWORD_USER_DEFAULT = "maybe4thbewithyou";

    public static User getUserDefault() {
        return User.builder()
                .name(NAME_USER_DEFAULT)
                .email(EMAIL_USER_DEFAULT)
                .password(PASSWORD_USER_DEFAULT)
                .build();
    }

    public static List<User> getListUser() {
        return Arrays.asList(
                User.builder().name("Han Solo").email("hansolo@lightsaber.com").password("milleniunmfalcon").build(),
                User.builder().name("Boba Fett").email("bobafett@lightsaber.com").password("kamino").build(),
                User.builder().name("R2D2").email("r2d2@lightsaber.com").password("kickAdroid").build(),
                User.builder().name("Yoda Master").email("lightsaber@yoda.com").password("trulywonderful").build(),
                User.builder().name("Palpatine").email("palpatine@darkside.com").password("darkside").build()
        );
    }

}

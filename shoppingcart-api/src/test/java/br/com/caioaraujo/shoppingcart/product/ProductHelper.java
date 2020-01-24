package br.com.caioaraujo.shoppingcart.product;

import br.com.caioaraujo.shoppingcart.domain.Product;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ProductHelper {

    public static final String NAME_DEFAULT_PRODUCT = "Dual-phase Sith Lightsaber";
    public static final BigDecimal VALUE_DEFAULT_PRODUCT = BigDecimal.valueOf(29.90);

    public static final Product PRODUCT_DARTH_VADER_HELMET = Product.builder().name("Darth Vader Helmet").value(BigDecimal.valueOf(199.90)).build();
    public static final Product PRODUCT_BOBA_FETT_HELMET = Product.builder().name("Boba Fett Helmet").value(BigDecimal.valueOf(99.90)).build();
    public static final Product PRODUCT_STORMTROOPER_HELMET = Product.builder().name("Stormtrooper Helmet").value(BigDecimal.valueOf(89.90)).build();
    public static final Product PRODUCT_REBELS_LIGHTSABER = Product.builder().name("Rebels Lightsaber").value(BigDecimal.valueOf(19.90)).build();
    public static final Product PRODUCT_DARKSIDE_LIGHTSABER = Product.builder().name("Darkside Lightsaber").value(BigDecimal.valueOf(590.20)).build();
    public static final Product PRODUCT_JEDIS_LIGHTSABER = Product.builder().name("Jedis Lightsaber").value(BigDecimal.valueOf(590.20)).build();
    public static final Product PRODUCT_MILLENIUN_FALCON = Product.builder().name("Milleniun Falcon").value(BigDecimal.valueOf(29990.90)).build();
    public static final Product PRODUCT_DROID_R_2_D_2 = Product.builder().name("Droid R2D2").value(BigDecimal.valueOf(190.90)).build();
    public static final Product PRODUCT_DROID_C_3_PO = Product.builder().name("Droid C3PO").value(BigDecimal.valueOf(19.90)).build();


    public static Product getProductDefault() {
        return Product.builder()
                .name(NAME_DEFAULT_PRODUCT)
                .value(VALUE_DEFAULT_PRODUCT)
                .build();
    }

    public static List<Product> getListProduct() {
        return Arrays.asList(
                PRODUCT_DARTH_VADER_HELMET,
                PRODUCT_BOBA_FETT_HELMET,
                PRODUCT_STORMTROOPER_HELMET,
                PRODUCT_REBELS_LIGHTSABER,
                PRODUCT_DARKSIDE_LIGHTSABER,
                PRODUCT_JEDIS_LIGHTSABER,
                PRODUCT_MILLENIUN_FALCON,
                PRODUCT_DROID_R_2_D_2,
                PRODUCT_DROID_C_3_PO
        );
    }

}

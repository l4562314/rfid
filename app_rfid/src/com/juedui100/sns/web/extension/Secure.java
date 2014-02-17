package com.juedui100.sns.web.extension;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * User: chjp
 * Date: 11-11-25
 * Time: 上午10:18
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface Secure {
    String[] roles() default {};
    String url() default "";
    String from() default "";
}

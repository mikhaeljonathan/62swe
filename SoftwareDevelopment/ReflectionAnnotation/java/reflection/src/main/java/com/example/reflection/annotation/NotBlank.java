package com.example.reflection.annotation;

import java.lang.annotation.*;

@Documented
@Target({
        ElementType.FIELD
})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface NotBlank {
    boolean allowEmptyString() default false;
}

package com.example.reflection.validation;

import com.example.reflection.annotation.NotBlank;

import java.lang.reflect.Field;

public class Validator {
    public static void validateNotBlank(Object object) {
        Class<?> aClass = object.getClass();

        Field[] fields = aClass.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);

            NotBlank annotation = field.getAnnotation(NotBlank.class);
            if (annotation != null) {
                try {
                    String value = (String) field.get(object);
                    if (value == null || value.isEmpty() || (!annotation.allowEmptyString() && value.trim().isEmpty())) {
                        throw new IllegalArgumentException("Field " + field.getName() + " should not be blank");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

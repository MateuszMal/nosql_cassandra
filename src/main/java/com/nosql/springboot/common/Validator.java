package com.nosql.springboot.common;

public class Validator {

    public static void checkIdIsNull(Long id) {
        if (id == null) {
            throw new NullIdException("Provided id is null");
        }
    }
}

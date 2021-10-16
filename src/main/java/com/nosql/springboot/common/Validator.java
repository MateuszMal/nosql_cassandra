package com.nosql.springboot.common;

public class Validator {

    public static void checkIdIsNull(Integer id) {
        if (id == null) {
            throw new NullIdException("Provided id is null");
        }
    }
}

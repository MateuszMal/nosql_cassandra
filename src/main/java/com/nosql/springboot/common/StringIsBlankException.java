package com.nosql.springboot.common;

public class StringIsBlankException extends RuntimeException{

    public StringIsBlankException(String msg){
        super(msg);
    }
}

package com.example.University_Management.Exceptions;

public class courseNotFoundException extends RuntimeException{
    public courseNotFoundException(String msg){
        super(msg);
    }
}

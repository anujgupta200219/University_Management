package com.example.University_Management.Exceptions;

public class departmentNotFoundException extends RuntimeException{

    public departmentNotFoundException(String msg){
        super(msg);
    }
}

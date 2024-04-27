package com.example.employeeapi.Exceptions.customs;

public class BussinesException extends RuntimeException{

    private final int code;

    public BussinesException(int code, String messsage){
        super(messsage);
        this.code = code;
    }

    public int getCode() { return this.code;}
}

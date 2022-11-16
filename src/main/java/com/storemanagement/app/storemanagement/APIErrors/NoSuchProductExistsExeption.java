package com.storemanagement.app.storemanagement.APIErrors;

public class NoSuchProductExistsExeption extends RuntimeException{
    private  String message;
    public NoSuchProductExistsExeption(){}
    public NoSuchProductExistsExeption(String msg){
        super(msg);
        this.message = msg;
    }
}

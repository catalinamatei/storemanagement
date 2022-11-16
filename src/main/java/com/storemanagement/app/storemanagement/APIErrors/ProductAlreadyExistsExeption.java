package com.storemanagement.app.storemanagement.APIErrors;

public class ProductAlreadyExistsExeption extends RuntimeException {
    private  String message;
    public ProductAlreadyExistsExeption(){}
    public ProductAlreadyExistsExeption(String msg){
        super(msg);
        this.message = msg;
    }
}

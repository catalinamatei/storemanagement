package com.storemanagement.app.storemanagement.APIErrors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoSuchProductExistsExeption extends RuntimeException{
    private  String message;
    public NoSuchProductExistsExeption(){}
    public NoSuchProductExistsExeption(String msg){
        super(msg);
        this.message = msg;
    }
}

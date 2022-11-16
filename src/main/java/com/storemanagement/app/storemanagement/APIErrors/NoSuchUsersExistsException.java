package com.storemanagement.app.storemanagement.APIErrors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoSuchUsersExistsException extends RuntimeException{
        private  String message;
        public NoSuchUsersExistsException(){}
        public NoSuchUsersExistsException(String msg) {
            super(msg);
            this.message = msg;
        }
}

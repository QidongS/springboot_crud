package com.rsqd.springbootwebrestfulcrud.exception;

public class UserNotExistException extends RuntimeException   {
    public UserNotExistException(){
        super("User Not Exist");
    }


}

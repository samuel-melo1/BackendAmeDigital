package com.backend.amedigital.exceptions;

public class NotFoundResultAPI extends  RuntimeException{

    public NotFoundResultAPI(){
        super("Not found object json results in api ");
    }
}

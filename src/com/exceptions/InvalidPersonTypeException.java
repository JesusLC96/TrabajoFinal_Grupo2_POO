package com.exceptions;

public class InvalidPersonTypeException extends Exception{
    @Override
    public String getMessage() {
        return "Tipo de persona inválido.";
    }
}

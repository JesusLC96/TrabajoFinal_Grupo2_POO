package com.exceptions;

public class MaximumCursosLimitReachedException extends Exception {

    @Override
    public String getMessage() {
        return "Cantidad máxima de cursos ya ha sido alcanzada.";
    }
}

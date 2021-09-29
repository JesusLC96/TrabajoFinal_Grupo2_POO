package com.entities;

public abstract class Persona {
    String nombres;
    String apellidos;
    String documento;

    public Persona(String nombres, String apellidos, String documento) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.documento = documento;
    }
}

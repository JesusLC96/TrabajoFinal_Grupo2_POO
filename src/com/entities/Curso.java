package com.entities;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nombre;
    private List<Seccion> secciones;

    public Curso(String nombre) {
        this.nombre = nombre;
        this.secciones = new ArrayList<>();
    }
}
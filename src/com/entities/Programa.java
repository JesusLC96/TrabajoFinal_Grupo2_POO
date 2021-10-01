package com.entities;

import java.util.ArrayList;
import java.util.List;

public class Programa {
    private String nombre;
    private int cantidadMaximaCursos;
    private Linea linea;
    private List<Seccion> seccions;

    public Programa(Linea linea, String nombre,  int cantidadMaximaCursos) {
        this.nombre = nombre;
        this.cantidadMaximaCursos = cantidadMaximaCursos;
        this.linea=linea;
        this.seccions = new ArrayList<>();
    }

    public List<Seccion> getSecciones() {
        return seccions;
    }

    public void asignarSeccion(Seccion seccion) {
        this.seccions.add(seccion);
    }

    public Object[] getObjetRow() {
        final Object[] row = new Object[4];
        row[1] = linea;
        row[2] = nombre;
        row[3] = cantidadMaximaCursos;
        return row;
    }

    // GETTERS Y SETTERS


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadMaximaCursos() {
        return cantidadMaximaCursos;
    }

    public void setCantidadMaximaCursos(int cantidadMaximaCursos) {
        this.cantidadMaximaCursos = cantidadMaximaCursos;
    }

    public Linea getLinea() {
        return linea;
    }

    public void setLinea(Linea linea) {
        this.linea = linea;
    }
}

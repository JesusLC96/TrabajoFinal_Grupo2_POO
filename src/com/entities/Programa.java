package com.entities;

import java.util.ArrayList;
import java.util.List;

public class Programa {
    private String nombre;
    private int cantidadMaximaCursos;
    private Linea linea;
    private List<Curso> cursos;

    public Programa(Linea linea, String nombre,  int cantidadMaximaCursos) {
        this.nombre = nombre;
        this.cantidadMaximaCursos = cantidadMaximaCursos;
        this.linea=linea;
        this.cursos = new ArrayList<>();
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void agregarCurso(Curso curso) {
        this.cursos.add(curso);
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

package com.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Programa {
    private String nombre;
    private int cantidadMaximaCursos;
    private List<Curso> cursos;

    public Programa(String nombre, int cantidadMaximaCursos) {
        this.nombre = nombre;
        this.cantidadMaximaCursos = cantidadMaximaCursos;
        this.cursos = new ArrayList<>();
    }

    public void setCantidadMaximaCursos(int cantidadMaximaCursos) {
        this.cantidadMaximaCursos = cantidadMaximaCursos;
    }

    public int getCantidadMaximaCursos() {
        return cantidadMaximaCursos;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void agregarCurso(Curso curso) {
        this.cursos.add(curso);
    }
}

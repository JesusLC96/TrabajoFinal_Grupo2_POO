package com.entities;

public class Especializacion extends Programa {
    public Especializacion(String nombre, Linea linea, int cantidadMaximaCursos) {
        super(nombre, linea, cantidadMaximaCursos);
    }

    @Override
    public void agregarCurso(Curso curso) {
        if (getCursos().size() < getCantidadMaximaCursos()) {
            super.agregarCurso(curso);
        }
    }
}

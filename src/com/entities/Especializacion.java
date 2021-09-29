package com.entities;

public class Especializacion extends Programa {
    public Especializacion(String nombre, int cantidadMaximaCursos) {
        super(nombre, cantidadMaximaCursos);
    }

    @Override
    public void agregarCurso(Curso curso) {
        if (getCursos().size() < getCantidadMaximaCursos()) {
            super.agregarCurso(curso);
        }
    }
}

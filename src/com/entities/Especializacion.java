package com.entities;

public class Especializacion extends Programa {
    public Especializacion(Linea linea, String nombre,  int cantidadMaximaCursos) {
        super(linea,nombre, cantidadMaximaCursos);
    }

    @Override
    public void agregarCurso(Curso curso) {
        if (getCursos().size() < getCantidadMaximaCursos()) {
            super.agregarCurso(curso);
        }
    }
}

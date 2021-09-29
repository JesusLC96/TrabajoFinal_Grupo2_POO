package com.entities;

import java.util.ArrayList;
import java.util.List;

public class Seccion {
    int capacidad;
    int año;
    Profesor profesor;
    List<Estudiante> estudiantes;

    public Seccion(int capacidad, int año, Profesor profesor) {
        this.capacidad = capacidad;
        this.año = año;
        this.profesor = profesor;
        this.estudiantes = new ArrayList<>();
    }

    public void matricularEstudiante(Estudiante estudiante) {
        try {
            if (estudiantes.size() == capacidad) {
                throw new Exception("Ya no hay vacantes libres");
            } else {
                estudiantes.add(estudiante);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

package com.entities;

import com.factories.PersonaFactory;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    PersonaFactory personaFactory = new PersonaFactory();

    List<Persona> estudiantes;
    List<Persona> profesores;
    List<Seccion> secciones;

    private static Empresa instance = new Empresa();

    private Empresa() {
        this.secciones = new ArrayList<>();
    }

    public static Empresa getInstance() {
        return instance;
    }

    public void crearEstudiante(String nombres, String apellidos, String documento) {
        Persona estudiante = personaFactory.obtenerPersona("Estudiante",nombres, apellidos, documento);

        estudiantes.add(estudiante);
    }

    public void crearProfesor(String nombres, String apellidos, String documento) {
        Persona profesor = personaFactory.obtenerPersona("Profesor",nombres, apellidos, documento);

        profesores.add(profesor);
    }

    public void crearSeccion(int capacidad, int año, Curso curso, Profesor profesor) {
        Seccion seccion = new Seccion(capacidad, año, profesor);

        secciones.add(seccion);
    }
}

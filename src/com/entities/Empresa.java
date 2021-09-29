package com.entities;

import com.factories.PersonaFactory;
import com.factories.ProgramaFactory;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    PersonaFactory personaFactory = new PersonaFactory();
    ProgramaFactory programaFactory = new ProgramaFactory();

    List<Persona> estudiantes;
    List<Persona> profesores;
    List<Programa> programas;
    List<Curso> cursos;

    private static Empresa instance = new Empresa();

    private Empresa() {
        this.estudiantes = new ArrayList<>();
        this.profesores = new ArrayList<>();
        this.programas = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    public static Empresa getInstance() {
        return instance;
    }

    public List<Persona> getEstudiantes() {
        return estudiantes;
    }

    public List<Persona> getProfesores() {
        return profesores;
    }

    public List<Programa> getProgramas() {
        return programas;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void crearEstudiante(String nombres, String apellidos, String documento) {
        Persona estudiante = personaFactory.obtenerPersona("Estudiante",nombres, apellidos, documento);

        estudiantes.add(estudiante);
    }

    public void crearProfesor(String nombres, String apellidos, String documento) {
        Persona profesor = personaFactory.obtenerPersona("Profesor",nombres, apellidos, documento);

        profesores.add(profesor);
    }

    public void crearPrograma(String tipoPrograma, String nombre, Linea linea, int cantidadMaximaCursos) {
        Programa programa = programaFactory.obtenerPrograma(tipoPrograma, nombre, linea, cantidadMaximaCursos);

        programas.add(programa);
    }

    public void crearCurso(String nombre) {
        Curso curso = new Curso(nombre);

        cursos.add(curso);
    }

    public void asignarCurso(Programa programa, Curso curso) {
        programa.agregarCurso(curso);
    }
}

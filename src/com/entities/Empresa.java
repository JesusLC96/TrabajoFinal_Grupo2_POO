package com.entities;

import com.factories.ProgramaFactory;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

public class Empresa {

    List<Profesor> profesores;
    List<Programa> programas;
    List<Curso> cursos;
    List<Seccion> seccions;

    private static Empresa instance = new Empresa();

    private Empresa() {
        this.programas = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.profesores = new ArrayList<>();
        this.seccions = new ArrayList<>();
    }

    public static Empresa getInstance() {
        return instance;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public List<Programa> getProgramas() {
        return programas;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public List<Seccion> getSeccions() {
        return seccions;
    }

    public void crearProfesor(String nombres, String apellidos, String documento) {
        //Persona profesor = personaFactory.obtenerPersona("Profesor",nombres, apellidos, documento);
        Profesor profesor = new Profesor(nombres,apellidos,documento);
        profesores.add(profesor);
    }

    public void crearPrograma(String tipoPrograma, String linea, String nombre, int cantidadMaximaCursos) {
        Programa programa;
        switch (linea){
            case "BI":
                programa = ProgramaFactory.obtenerPrograma(tipoPrograma,Linea.BI, nombre, cantidadMaximaCursos);
                programas.add(programa);
                break;
            case "SAP":
                programa = ProgramaFactory.obtenerPrograma(tipoPrograma,Linea.SAP, nombre, cantidadMaximaCursos);
                programas.add(programa);
                break;
            case "EXCEL":
                programa = ProgramaFactory.obtenerPrograma(tipoPrograma,Linea.EXCEL, nombre, cantidadMaximaCursos);
                programas.add(programa);
                break;
            case "PMP":
                programa = ProgramaFactory.obtenerPrograma(tipoPrograma,Linea.PMP, nombre, cantidadMaximaCursos);
                programas.add(programa);
                break;
            default:
                programa=null;
        }
//        Programa programa = ProgramaFactory.obtenerPrograma(tipoPrograma,Linea.SAP, nombre, cantidadMaximaCursos);
//        programas.add(programa);
    }

    public void actualizarPrograma(Integer index, String nuevoNombre,Integer nuevaCantidad){
        programas.get(index).setNombre(nuevoNombre);
        programas.get(index).setCantidadMaximaCursos(nuevaCantidad);
    }

    public void crearCurso(String nombre) {
        Curso curso = new Curso(nombre);

        cursos.add(curso);
    }

    public void crearSeccion(String codigo, Curso curso, Profesor profesor, int cantidad, int año){
        Seccion seccion = new Seccion(codigo,curso,profesor,cantidad,año);
        seccions.add(seccion);
    }

}

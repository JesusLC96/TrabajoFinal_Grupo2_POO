package com.entities;

import java.util.ArrayList;
import java.util.List;

public class Alumno extends Usuario{
    private String nombre;
    private String apellido;
    private int edad;
    private List<Curso> cursosInscritos = new ArrayList<>();

    public Alumno(String username, String password, String nombre, String apellido, int edad) {
        super(username, password);
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public List<Curso> getCursosInscritos() {
        return cursosInscritos;
    }

    public void setCursosInscritos(List<Curso> cursosInscritos) {
        this.cursosInscritos = cursosInscritos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }
}

package com.clases;

import java.util.ArrayList;
import java.util.List;

public class Linea {

    private String nombreLinea;
    private List<CategoriaCurso> listaTodoslosCursos;

    public Linea(String nombreLinea) {
        this.nombreLinea = nombreLinea;
        this.listaTodoslosCursos = new ArrayList<>();
    }

    public Linea() {
    }

    public void asignarCurso(String nombreCategoria, String nombreCurso, int cantVacantes,double precio, boolean examenSimulacro){
        if (nombreCategoria.equals("Curso")) {
            CategoriaCurso nuevocurso = new Curso(nombreCategoria,nombreCurso, cantVacantes,precio, examenSimulacro);
            listaTodoslosCursos.add(nuevocurso);
        } else if (nombreCategoria.equals("Diplomado")){
            CategoriaCurso nuevocurso = new Diplomado(nombreCategoria,nombreCurso, cantVacantes,precio, examenSimulacro);
            listaTodoslosCursos.add(nuevocurso);
        } else if (nombreCategoria.equals("Especialización")){
            CategoriaCurso nuevocurso = new Especializacion(nombreCategoria, nombreCurso, cantVacantes,precio, examenSimulacro);
            listaTodoslosCursos.add(nuevocurso);
        }
    }

    public List<CategoriaCurso> getListaTodoslosCursos() {
        return listaTodoslosCursos;
    }

    public String getNombreLinea() {
        return nombreLinea;
    }
}

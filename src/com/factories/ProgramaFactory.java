package com.factories;

import com.entities.Diplomado;
import com.entities.Especializacion;
import com.entities.Linea;
import com.entities.Programa;

public class ProgramaFactory {
    public Programa obtenerPrograma(String tipoPrograma, String nombre, Linea linea, int cantidadMaximaCursos){
        if(tipoPrograma == null){
            return null;
        }
        if(tipoPrograma.equalsIgnoreCase("Especialización")){
            return new Especializacion(nombre, linea, cantidadMaximaCursos);

        } else if(tipoPrograma.equalsIgnoreCase("Diplomado")){
            return new Diplomado(nombre, linea, cantidadMaximaCursos);
        }

        return null;
    }
}

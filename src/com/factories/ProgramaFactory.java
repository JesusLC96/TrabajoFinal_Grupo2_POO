package com.factories;

import com.entities.Diplomado;
import com.entities.Especializacion;
import com.entities.Linea;
import com.entities.Programa;

public class ProgramaFactory {
    public static Programa obtenerPrograma(String tipoPrograma, Linea linea, String nombre,  int cantidadMaximaCursos){
        if(tipoPrograma == null){
            return null;
        }
        if(tipoPrograma.equalsIgnoreCase("Especialización")){
            return new Especializacion(linea, nombre,  cantidadMaximaCursos);

        } else if(tipoPrograma.equalsIgnoreCase("Diplomado")){
            return new Diplomado(linea, nombre,  cantidadMaximaCursos);
        }

        return null;
    }
}

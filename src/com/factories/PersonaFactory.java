package com.factories;

import com.entities.Estudiante;
import com.entities.Persona;
import com.entities.Profesor;

public class PersonaFactory {
    public Persona obtenerPersona(String tipoPersona, String nombres, String apellidos, String documento){
        if(tipoPersona == null){
            return null;
        }
        if(tipoPersona.equalsIgnoreCase("Estudiante")){
            return new Estudiante(nombres, apellidos, documento);

        } else if(tipoPersona.equalsIgnoreCase("Profesor")){
            return new Profesor(nombres, apellidos, documento);
        }

        return null;
    }
}

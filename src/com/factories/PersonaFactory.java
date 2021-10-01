package com.factories;

import com.entities.Estudiante;
import com.entities.Persona;
import com.entities.Profesor;
import com.exceptions.InvalidPersonTypeException;
import com.utils.TipoPersonaEnum;

public class PersonaFactory {
    public Persona obtenerPersona(TipoPersonaEnum tipoPersona, String nombres, String apellidos, String documento) throws InvalidPersonTypeException{
        switch (tipoPersona) {
            case Estudiante:
                return new Estudiante(nombres, apellidos, documento);
            case Profesor:
                return new Profesor(nombres, apellidos, documento);
            default:
                throw new InvalidPersonTypeException();
        }
    }
}

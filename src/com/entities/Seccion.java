package com.entities;

import java.util.ArrayList;
import java.util.List;

public class Seccion {
    int capacidad;
    int año;
    Profesor profesor;

    public Seccion(int capacidad, int año, Profesor profesor) {
        this.capacidad = capacidad;
        this.año = año;
        this.profesor = profesor;
    }

}

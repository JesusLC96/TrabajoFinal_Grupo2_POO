package com;

import com.entities.Especializacion;
import com.entities.Linea;
import com.entities.Programa;
import com.vistas.Login;
import com.vistas.Portal;

public class Main {

    public static void main(String[] args) {
        cargarPortal();
        //test();
    }

    public static void cargarPortal(){
        Login login = Login.getInstance();
        login.load();
    }
}

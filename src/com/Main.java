package com;

import com.entities.Empresa;
import com.vistas.PanelAdmin;
import com.vistas.Portal;

public class Main {
    public static void main(String[] args) {
        cargarPortal();
    }

    public static void cargarPortal(){
        System.out.println();
        Portal portal = new Portal();
        portal.load();
    }
}

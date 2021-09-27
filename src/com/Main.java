package com;

import com.vistas.PanelAdmin;
import com.vistas.Portal;

public class Main {
    public static void main(String[] args) {
        cargarPortal();
    }

    public static void cargarPortal(){
        Portal portal = new Portal();
        portal.load();
    }
}

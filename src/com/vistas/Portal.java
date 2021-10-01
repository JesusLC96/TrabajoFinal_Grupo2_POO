package com.vistas;

import javax.swing.*;

public class Portal {
    private static Portal portal = new Portal();
    private JButton personaButton;
    private JButton programasButton;
    private JButton matriculasButton;
    private JButton extraButton;

    private JFrame frame = new JFrame();
    private JPanel myPortal;
    private PortalProgramas portalProgramas;
    private PortalPersonal portalPersonal;


    public Portal(){
        programasButton.addActionListener(e -> loadPortalProgramas());
        personaButton.addActionListener(e ->loadPortalPersonal());
        //matriculasButton.addActionListener(e->);
        //extraButton.addActionListener(e->);
    }

    public void loadPortalProgramas(){
        portalProgramas = PortalProgramas.getInstance();
        portalProgramas.load();
    }

    public void loadPortalPersonal(){
        portalPersonal = PortalPersonal.getInstance();
        portalPersonal.load();
    }

    public void IngresarPanelAlumno(){
//        this.login = Login.returnLogin();
//        this.login.load();
    }

    public static Portal getInstance(){
        return portal;
    }

    public void load(){
        this.frame.add(myPortal); // agregar panel al objeto
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // detener programa al cerrar
        this.frame.setUndecorated(false); // mostrar ventanas windows
        this.frame.pack();  //mostrar contenido
        this.frame.setLocationRelativeTo(null); //mostrar al centro
        this.frame.setVisible(true);    // que sea visible
        this.frame.setResizable(false); // bloqueo cambiar tamaño de ventana
    }
}


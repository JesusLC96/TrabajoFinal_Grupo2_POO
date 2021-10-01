package com.vistas;

import javax.swing.*;

public class Portal {
    private static Portal portal = new Portal();
    private JButton personaButton;
    private JButton programasButton;
    private JButton seccionesButton;
    private JButton gestiónDeCursosButton;

    private JFrame frame = new JFrame();
    private JPanel myPortal;
    private PortalProgramas portalProgramas;
    private PortalPersonal portalPersonal;
    private PortalCurso portalCurso;
    private PortalSeccion portalSeccion;

    public Portal(){
        programasButton.addActionListener(e -> loadPortalProgramas());
        personaButton.addActionListener(e ->loadPortalPersonal());
        seccionesButton.addActionListener(e->loadPortalSecciones());
        gestiónDeCursosButton.addActionListener(e-> loadPortalCurso());
    }

    public void loadPortalProgramas(){
        portalProgramas = PortalProgramas.getInstance();
        portalProgramas.load();
    }

    public void loadPortalPersonal(){
        portalPersonal = PortalPersonal.getInstance();
        portalPersonal.load();
    }

    public void loadPortalCurso(){
        portalCurso = PortalCurso.getInstance();
        portalCurso.load();
    }

    public void loadPortalSecciones(){
        portalSeccion = PortalSeccion.getInstance();
        portalSeccion.load();
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


package com.vistas;

import javax.swing.*;

public class Portal {
    private JButton administradorButton;
    private JButton alumnoButton;
    private JFrame frame = new JFrame();
    private JPanel myPortal;
    private PanelAdmin panelAdmin;
    private Login login;


    public Portal(){
        administradorButton.addActionListener(e -> ingresarPanellAdmin()); //Ingresar a Panel Admin
        alumnoButton.addActionListener(e -> IngresarPanelAlumno()); //Ingresar a Panel Alumno
    }

    public void ingresarPanellAdmin(){
        this.panelAdmin = PanelAdmin.returnPanelAdmin();
        this.panelAdmin.load();
    }

    public void IngresarPanelAlumno(){
        this.login = Login.returnLogin();
        this.login.load();
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


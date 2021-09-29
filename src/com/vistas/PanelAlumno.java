package com.vistas;

import com.entities.Alumno;

import javax.swing.*;

public class PanelAlumno {
    private JPanel myPanelAlumno;
    private JButton registrarmeButton;
    private JButton buscarButton;
    private JButton salirButton;
    private JTable tablaCursosDisponibles;
    private JFrame frame = new JFrame();
    private Alumno alumno;

    public PanelAlumno(Alumno alumno){
        this.alumno=alumno;
    }

    public void load(){
        this.frame.add(myPanelAlumno); // agregar panel al objeto
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // detener programa al cerrar
        this.frame.setUndecorated(false); // mostrar ventanas windows
        this.frame.pack();  //mostrar contenido
        this.frame.setLocationRelativeTo(null); //mostrar al centro
        this.frame.setVisible(true);    // que sea visible
        this.frame.setResizable(true); // bloqueo cambiar tamaño de ventana
    }
}

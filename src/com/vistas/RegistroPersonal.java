package com.vistas;
//
import com.entities.Empresa;

import javax.swing.*;

//
public class RegistroPersonal {
    private static RegistroPersonal registroPersonal = new RegistroPersonal();
    private JPanel myRegistroCurso;
    public  JComboBox comboBoxTipoPrograma;
    public  JComboBox comboBoxLinea;
    public  JTextField textFieldNombrePrograma;
    public  JTextField textFieldCantMaxCursos;
    public  JButton registrarNuevoProgramaButton;
    private JFrame frame = new JFrame();

    Empresa empresa;
    PortalProgramas portalProgramas;
//    private Portal panelAdmin;
//
//    public static String a;
//
    private RegistroPersonal(){
//
        registrarNuevoProgramaButton.addActionListener(e -> enviarDatos());
    }
//
    public void enviarDatos(){
        empresa = Empresa.getInstance();
        empresa.crearPrograma(comboBoxTipoPrograma.getSelectedItem().toString(),comboBoxLinea.getSelectedItem().toString(),textFieldNombrePrograma.getText(),Integer.parseInt(this.textFieldCantMaxCursos.getText()));
        portalProgramas = PortalProgramas.getInstance();
        portalProgramas.listarPrograma();
    }
//
    public static RegistroPersonal getInstance(){
        return registroPersonal;
    }
    public void load(){
        this.frame.add(myRegistroCurso); // agregar panel al objeto
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // detener programa al cerrar
        this.frame.setUndecorated(false); // mostrar ventanas windows
        this.frame.pack();  //mostrar contenido
        this.frame.setLocationRelativeTo(null); //mostrar al centro
        this.frame.setVisible(true);    // que sea visible
        this.frame.setSize(650,350);
        this.frame.setResizable(true); // bloqueo cambiar tamaño de ventana
    }
}

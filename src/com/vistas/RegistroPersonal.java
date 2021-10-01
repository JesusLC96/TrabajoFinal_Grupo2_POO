package com.vistas;
//
import com.entities.Empresa;

import javax.swing.*;

//
public class RegistroPersonal {
    private static RegistroPersonal registroPersonal = new RegistroPersonal();
    private JPanel myRegistroPersonal;
    private JTextField textFieldNombres;
    public  JTextField textFieldApellidos;
    public  JTextField textFieldDocumento;

    public  JButton registrarNuevoPersonalButton;

    private JFrame frame = new JFrame();

    Empresa empresa;
    PortalPersonal portalPersonal;

    private RegistroPersonal(){
        registrarNuevoPersonalButton.addActionListener(e -> enviarDatos());
    }

    public void enviarDatos(){
        empresa = Empresa.getInstance();
        //empresa.crearPrograma(comboBoxTipoPrograma.getSelectedItem().toString(),comboBoxLinea.getSelectedItem().toString(),textFieldApellidos.getText(),Integer.parseInt(this.textFieldCapacidad.getText()));
        empresa.crearProfesor(textFieldNombres.getText(),textFieldApellidos.getText(),textFieldDocumento.getText());
        portalPersonal = PortalPersonal.getInstance();
        portalPersonal.listarPersonal();
    }
//
    public static RegistroPersonal getInstance(){
        return registroPersonal;
    }
    public void load(){
        this.frame.add(myRegistroPersonal); // agregar panel al objeto
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // detener programa al cerrar
        this.frame.setUndecorated(false); // mostrar ventanas windows
        this.frame.pack();  //mostrar contenido
        this.frame.setLocationRelativeTo(null); //mostrar al centro
        this.frame.setVisible(true);    // que sea visible
        this.frame.setSize(650,350);
        this.frame.setResizable(true); // bloqueo cambiar tamaño de ventana
    }
}
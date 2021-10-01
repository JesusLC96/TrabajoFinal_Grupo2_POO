package com.vistas;
//
import com.entities.Empresa;
import com.exceptions.InvalidProgramTypeException;
import com.utils.LineaProgramaEnum;
import com.utils.TipoProgramaEnum;

import javax.swing.*;

//
public class RegistroPrograma {
    private static RegistroPrograma registroPrograma = new RegistroPrograma();
    private JPanel myRegistroPrograma;
    public  JComboBox comboBoxTipoPrograma;
    public  JComboBox comboBoxLinea;
    public  JTextField textFieldNombrePrograma;
    public  JTextField textFieldCantMaxCursos;
    public  JButton registrarNuevoProgramaButton;
    private JFrame frame = new JFrame();

    Empresa empresa;
    PortalProgramas portalProgramas;

    private RegistroPrograma(){
        registrarNuevoProgramaButton.addActionListener(e -> enviarDatos());
    }

    public void enviarDatos(){
        empresa = Empresa.getInstance();
        try {
            empresa.crearPrograma(TipoProgramaEnum.valueOf(comboBoxTipoPrograma.getSelectedItem().toString()), LineaProgramaEnum.valueOf(comboBoxLinea.getSelectedItem().toString()),textFieldNombrePrograma.getText(),Integer.parseInt(this.textFieldCantMaxCursos.getText()));
        } catch (InvalidProgramTypeException e) {
            System.out.println(e.getMessage());
        }
        portalProgramas = PortalProgramas.getInstance();
        portalProgramas.listarPrograma();
    }

    public static RegistroPrograma getInstance(){
        return registroPrograma;
    }

    public void load(){
        this.frame.add(myRegistroPrograma); // agregar panel al objeto
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // detener programa al cerrar
        this.frame.setUndecorated(false); // mostrar ventanas windows
        this.frame.pack();  //mostrar contenido
        this.frame.setLocationRelativeTo(null); //mostrar al centro
        this.frame.setVisible(true);    // que sea visible
        this.frame.setSize(650,350);
        this.frame.setResizable(true); // bloqueo cambiar tamaño de ventana
    }
}

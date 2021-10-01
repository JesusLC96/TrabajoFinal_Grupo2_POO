package com.vistas;
//
import com.entities.Empresa;
import com.entities.Profesor;

import javax.swing.*;
import java.util.List;

//
public class RegistroCurso {
    private static RegistroCurso registroCurso = new RegistroCurso();
    private JPanel myRegistroCurso;
    private JTextField textFieldCurso;


    public  JButton registrarNuevoPersonalButton;
    //private JComboBox pruebacombo;

    private JFrame frame = new JFrame();

    Empresa empresa;
    PortalCurso portalCurso;

    private RegistroCurso(){
        registrarNuevoPersonalButton.addActionListener(e -> enviarDatos());

        empresa = Empresa.getInstance();
        List<Profesor> profe = empresa.getProfesores();

        //pruebacombo.setModel(new DefaultComboBoxModel<Profesor>(profe.toArray(new Profesor[0])));
    }

    public void enviarDatos(){
        empresa = Empresa.getInstance();
        //empresa.crearPrograma(comboBoxTipoPrograma.getSelectedItem().toString(),comboBoxLinea.getSelectedItem().toString(),textFieldApellidos.getText(),Integer.parseInt(this.textFieldCapacidad.getText()));
        empresa.crearCurso(textFieldCurso.getText());
        portalCurso = PortalCurso.getInstance();
        portalCurso.listarCursos();
    }
//
    public static RegistroCurso getInstance(){
        return registroCurso;
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

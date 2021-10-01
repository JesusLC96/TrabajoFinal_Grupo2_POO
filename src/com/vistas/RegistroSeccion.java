package com.vistas;
//
import com.entities.Curso;
import com.entities.Empresa;
import com.entities.Profesor;
import com.renders.CursoComboBoxRender;
import com.renders.ProfesorComboBoxRender;

import javax.swing.*;

//
public class RegistroSeccion {
    private JPanel myRegistroPersonal;
    public  JTextField textFieldCapacidad;
    private JComboBox comboBoxAño;
    private JComboBox<Curso> comboBoxCursos;
    private JComboBox<Profesor> comboBoxProfesores;

    private JFrame frame = new JFrame();
    public  JButton registrarNuevaSeccionButton;
    private JTextField textFieldCodigo;

    Empresa empresa;
    PortalSeccion portalSeccion;
    Profesor profesor;
    Curso curso;

    public RegistroSeccion(){
        empresa = Empresa.getInstance();

        comboBoxCursos.setModel(new DefaultComboBoxModel<Curso>(empresa.getCursos().toArray(new Curso[0])));
        comboBoxCursos.setRenderer(new CursoComboBoxRender());

        comboBoxProfesores.setModel(new DefaultComboBoxModel<Profesor>(empresa.getProfesores().toArray(new Profesor[0])));
        comboBoxProfesores.setRenderer(new ProfesorComboBoxRender());

        registrarNuevaSeccionButton.addActionListener(e -> enviarDatos());
    }

    public void enviarDatos(){
        empresa = Empresa.getInstance();

        Curso curso = Curso.class.cast(comboBoxCursos.getSelectedItem());
        Profesor profesor = Profesor.class.cast(comboBoxProfesores.getSelectedItem());

        empresa.crearSeccion(textFieldCodigo.getText(),curso,profesor,Integer.parseInt(this.textFieldCapacidad.getText()),Integer.parseInt(comboBoxAño.getSelectedItem().toString()));

        portalSeccion = PortalSeccion.getInstance();
        portalSeccion.listarSecciones();
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

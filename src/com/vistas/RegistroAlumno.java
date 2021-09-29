package com.vistas;

import com.entities.Alumno;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class RegistroAlumno {
    private static RegistroAlumno registroAlumno = new RegistroAlumno();
    private List<Alumno> listaAlumno = new ArrayList<>();
    private JPanel myRegistroAlumno;
    private JTextField textFieldUser;
    private JTextField textFieldNombres;
    private JTextField textFieldApellidos;
    private JTextField textFieldEdad;
    private JPasswordField passwordFieldPass;
    private JButton registrarmeButton;
    private JFrame frame = new JFrame();
    private Login login;


    private RegistroAlumno(){
        instanciarLogin();
        registrarmeButton.addActionListener(e -> registrarNuevoAlumno());
    }

    public void instanciarLogin(){
        login = Login.returnLogin();
    }

    public void registrarNuevoAlumno(){
        String usuario = this.textFieldUser.getText();
        String password = this.passwordFieldPass.getText();
        String nombres = this.textFieldNombres.getText();
        String apellidos = this.textFieldApellidos.getText();
        int edad = Integer.parseInt(this.textFieldEdad.getText());

        if(!textFieldUser.getText().isEmpty() && !passwordFieldPass.getText().isEmpty()) {
            if (listaAlumno.stream().noneMatch(item -> item.getUsername().equals(textFieldUser.getText()))) {
                Alumno nuevoAlumno = new Alumno(usuario,password,nombres,apellidos,edad);
                listaAlumno.add(nuevoAlumno);
                System.out.println(listaAlumno);
                frame.dispose();
                JOptionPane.showMessageDialog( null, "Registro correcto");
            } else JOptionPane.showMessageDialog( null, "El nombre de usuario ya existe");
        } else JOptionPane.showMessageDialog( null, "Por favor de ingresar los datos completos");

    }

    public static RegistroAlumno returnRegistroAlumno(){
        return registroAlumno;
    }

    public List<Alumno> getListaAlumno() {
        return listaAlumno;
    }

    public void load(){
        this.frame.add(myRegistroAlumno); // agregar panel al objeto
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // detener programa al cerrar
        this.frame.setUndecorated(false); // mostrar ventanas windows
        this.frame.pack();  //mostrar contenido
        this.frame.setLocationRelativeTo(null); //mostrar al centro
        this.frame.setVisible(true);    // que sea visible
        this.frame.setSize(425,350);
        this.frame.setResizable(true); // bloqueo cambiar tamaño de ventana
    }
}

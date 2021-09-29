package com.vistas;

import com.entities.Alumno;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Login {
    private static Login login = new Login();
    private JPanel myLogin;
    private JTextField textUser;
    private JPasswordField textPass;
    private JButton logInButton;
    private JButton signInButton;
    private JFrame frame = new JFrame();
    private List<Alumno> listausuarios;
    private RegistroAlumno registroAlumno;
    private String nombreTemporal;
    private Alumno alumnoSesion;

    public Login() {
        instanciarPortalRegistroAlumno();
        obtenerListaAlumnos();
        this.listausuarios = new ArrayList<>();
        //signInButton.addActionListener(e -> registarAlumno());
        signInButton.addActionListener(e -> portalRegistroAlumno());// registarAlumno());
        logInButton.addActionListener(e -> login());
    }

    public void instanciarPortalRegistroAlumno(){
        this.registroAlumno = RegistroAlumno.returnRegistroAlumno();
    }

    public void obtenerListaAlumnos(){
        listausuarios = registroAlumno.getListaAlumno();
    }

    public void login(){
        if (validarLogin(textUser.getText(),textPass.getText())){
            JOptionPane.showMessageDialog( null, "Bienvenido " + nombreTemporal);
            PanelAlumno panelAlumno = new PanelAlumno(alumnoSesion);
            panelAlumno.load();
            frame.dispose();
            System.out.println("Hola");

        } else JOptionPane.showMessageDialog( null, "Inicio de sesión incorrecto");
    }

    public boolean validarLogin(String usuario, String password){
        for (Alumno login:registroAlumno.getListaAlumno()){
            if (login.getUsername().equals(usuario) && login.getPassword().equals(password)){
                this.nombreTemporal = login.getNombre() +" " + login.getApellido();
                this.alumnoSesion = login;
                return true;

            }
        } return false;
    }

    public void portalRegistroAlumno(){
        registroAlumno.load();
    }

    public void load(){
        this.frame.add(myLogin); // agregar panel al objeto
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // detener programa al cerrar
        this.frame.setUndecorated(false); // mostrar ventanas windows
        this.frame.pack();  //mostrar contenido
        this.frame.setLocationRelativeTo(null); //mostrar al centro
        this.frame.setVisible(true);    // que sea visible
        this.frame.setResizable(false); // bloqueo cambiar tamaño de ventana
    }

    public static Login returnLogin(){
        return login;
    }
}


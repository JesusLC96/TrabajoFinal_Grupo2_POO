package com.vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class PortalCursos {
    private static PortalCursos panel = new PortalCursos();
    private JFrame frame = new JFrame();
    private JPanel myPortalCursos;
    private JButton registroButton;
    private JButton eliminarButton;
    private JButton actualizarButton;
    private JButton reporteButton;
    private JTable tablaCursos;
    private DefaultTableModel tbmodel = (DefaultTableModel) tablaCursos.getModel();
    TableRowSorter<DefaultTableModel> tr;


    private PortalCursos() {

        listar();

        //registroButton.addActionListener(e ->loadRegistro());
        //eliminarButton.addActionListener(e -> eliminarCurso());
        //actualizarButton.addActionListener(e -> modificarCurso());
        //reporteButton.addActionListener(e ->  );


    }

    public void listar(){
        Object[] column = {"Linea","Categoría","Nombre Curso","Vacantes","Precio","Bonus","Precio Final"};
        tbmodel.setColumnIdentifiers(column);
        tablaCursos.setModel(tbmodel);
        tablaCursos.setAutoCreateRowSorter(true);
        tr = new TableRowSorter<>(tbmodel);
        tablaCursos.setRowSorter(tr);


        //Estilos tabla Cursos
        tablaCursos.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
        tablaCursos.getTableHeader().setOpaque(false);
        tablaCursos.getTableHeader().setBackground(new Color(78,145,140));
        tablaCursos.setRowHeight(25);
    }

    public static PortalCursos getInstance(){
        return panel;
    }

    public void load(){
        this.frame.add(myPortalCursos); // agregar panel al objeto
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // detener programa al cerrar
        this.frame.setUndecorated(false); // mostrar ventanas windows
        this.frame.pack();  //mostrar contenido
        this.frame.setLocationRelativeTo(null); //mostrar al centro
        this.frame.setVisible(true);    // que sea visible
        this.frame.setResizable(true); // bloqueo cambiar tamaño de ventana
        this.frame.setSize(800,500);
    }
}

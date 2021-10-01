package com.vistas;

import com.entities.Empresa;
import com.entities.Seccion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class ListaSecciones {
    private static ListaSecciones listaSecciones = new ListaSecciones();
    private JFrame frame = new JFrame();
    private JPanel myPortalCursos;
    private JButton registroButton;
    private JButton eliminarButton;
    private JTable tablaSecciones;
    private DefaultTableModel tbmodel = (DefaultTableModel) tablaSecciones.getModel();
    TableRowSorter<DefaultTableModel> tr;

    //private RegistroSeccion registroSeccion;
    private Empresa empresa;

    private ListaSecciones() {
        listarSecciones();
        registroButton.addActionListener(e -> registroSeccion());
        eliminarButton.addActionListener(e -> eliminarSeccion());

    }

    public void listarSecciones(){
        Object[] column = {"Curso","Profesor","Cantidad","Año"};
        tbmodel.setColumnIdentifiers(column);
        tablaSecciones.setModel(tbmodel);
        tablaSecciones.setAutoCreateRowSorter(true);
        tr = new TableRowSorter<>(tbmodel);
        tablaSecciones.setRowSorter(tr);

        ////
        int rowCount = tbmodel.getRowCount();
        for(int i = rowCount-1; i>=0; i--){
            tbmodel.removeRow(i);
        }

        empresa = Empresa.getInstance();
        for (Seccion s:empresa.getSeccions()) {
            final Object[] tbRow = s.getObjetRow();
            tbmodel.addRow(tbRow);
        }

        //Estilos tabla Cursos
        tablaSecciones.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
        tablaSecciones.getTableHeader().setEnabled(false);
        tablaSecciones.getTableHeader().setOpaque(false);
        tablaSecciones.getTableHeader().setBackground(new Color(78,145,140));
        tablaSecciones.setRowHeight(25);
    }

    public void registroSeccion(){
        RegistroSeccion registroSeccion = new RegistroSeccion();
        //registroSeccion = RegistroSeccion.getInstance();
        registroSeccion.load();
    }

    public void eliminarSeccion(){
        empresa = Empresa.getInstance();
        int posicion = tablaSecciones.getSelectedRow();

        if (posicion>=0){
            empresa.getSeccions().remove(posicion);
            tbmodel.removeRow(posicion);
            JOptionPane.showMessageDialog( null, "Se elimino correctamente "+ posicion);
        }else {
            JOptionPane.showMessageDialog( null, "Error al eliminar");
        }
    }

    public static ListaSecciones getInstance(){
        return listaSecciones;
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

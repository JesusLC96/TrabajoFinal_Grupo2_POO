package com.vistas;

import com.entities.Curso;
import com.entities.Empresa;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class PortalCurso {
    private static PortalCurso portalCurso = new PortalCurso();
    private JFrame frame = new JFrame();
    private JPanel myPortalCursos;
    private JButton registroButton;
    private JButton eliminarButton;
    private JTable tablaProgramas;
    private DefaultTableModel tbmodel = (DefaultTableModel) tablaProgramas.getModel();
    TableRowSorter<DefaultTableModel> tr;

    private RegistroCurso registroCurso;

    private Empresa empresa;
    private RegistroPersonal registroPersonal;
    private PortalCurso() {
        listarCursos();
        registroButton.addActionListener(e -> registroCurso());
        eliminarButton.addActionListener(e -> eliminarCurso());

    }

    public void listarCursos(){
        Object[] column = {"Nombre"};
        tbmodel.setColumnIdentifiers(column);
        tablaProgramas.setModel(tbmodel);
        tablaProgramas.setAutoCreateRowSorter(true);
        tr = new TableRowSorter<>(tbmodel);
        tablaProgramas.setRowSorter(tr);

        ////
        int rowCount = tbmodel.getRowCount();
        for(int i = rowCount-1; i>=0; i--){
            tbmodel.removeRow(i);
        }

        empresa = Empresa.getInstance();
        for (Curso c:empresa.getCursos()) {
            final Object[] tbRow = c.getObjetRow();
            tbmodel.addRow(tbRow);
        }

        //Estilos tabla Cursos
        tablaProgramas.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
        tablaProgramas.getTableHeader().setEnabled(false);
        tablaProgramas.getTableHeader().setOpaque(false);
        tablaProgramas.getTableHeader().setBackground(new Color(78,145,140));
        tablaProgramas.setRowHeight(25);
    }

    public void registroCurso(){
        registroCurso = RegistroCurso.getInstance();
        registroCurso.load();
    }

    public void eliminarCurso(){
        empresa = Empresa.getInstance();
        int posicion = tablaProgramas.getSelectedRow();

        if (posicion>=0){
            empresa.getCursos().remove(posicion);
            tbmodel.removeRow(posicion);
            JOptionPane.showMessageDialog( null, "Se elimino correctamente "+ posicion);
        }else {
            JOptionPane.showMessageDialog( null, "Error al eliminar");
        }
    }

    public static PortalCurso getInstance(){
        return portalCurso;
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

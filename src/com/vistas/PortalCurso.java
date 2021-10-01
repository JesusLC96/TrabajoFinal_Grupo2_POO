package com.vistas;

import com.entities.Empresa;
import com.entities.Profesor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class PortalCurso {
    private static PortalCurso portalCurso = new PortalCurso();
    private JFrame frame = new JFrame();
    private JPanel myPortalPersonal;
    private JButton registroButton;
    private JButton eliminarButton;
    private JTable tablaProgramas;
    private DefaultTableModel tbmodel = (DefaultTableModel) tablaProgramas.getModel();
    TableRowSorter<DefaultTableModel> tr;

    private Empresa empresa;
    private RegistroPersonal registroPersonal;
    private PortalCurso() {
        listarPersonal();
        registroButton.addActionListener(e -> registroPersonal());
        eliminarButton.addActionListener(e -> eliminarPersonal());

    }

    public void listarPersonal(){
        Object[] column = {"Nombres","Apellidos","Documento"};
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
        for (Profesor p:empresa.getProfesores()) {
            final Object[] tbRow = p.getObjetRow();
            tbmodel.addRow(tbRow);
        }

        //Estilos tabla Cursos
        tablaProgramas.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
        tablaProgramas.getTableHeader().setEnabled(false);
        tablaProgramas.getTableHeader().setOpaque(false);
        tablaProgramas.getTableHeader().setBackground(new Color(78,145,140));
        tablaProgramas.setRowHeight(25);
    }

    public void registroPersonal(){
        registroPersonal = RegistroPersonal.getInstance();
        registroPersonal.load();
    }

    public void eliminarPersonal(){
        empresa = Empresa.getInstance();
        int posicion = tablaProgramas.getSelectedRow();

        if (posicion>=0){
            empresa.getProfesores().remove(posicion);
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
        this.frame.add(myPortalPersonal); // agregar panel al objeto
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // detener programa al cerrar
        this.frame.setUndecorated(false); // mostrar ventanas windows
        this.frame.pack();  //mostrar contenido
        this.frame.setLocationRelativeTo(null); //mostrar al centro
        this.frame.setVisible(true);    // que sea visible
        this.frame.setResizable(true); // bloqueo cambiar tamaño de ventana
        this.frame.setSize(800,500);
    }
}

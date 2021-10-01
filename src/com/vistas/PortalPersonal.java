package com.vistas;

import com.entities.Empresa;
import com.entities.Programa;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class PortalPersonal {
    private static PortalPersonal panel = new PortalPersonal();
    private JFrame frame = new JFrame();
    private JPanel myPortalProgramas;
    private JButton registroButton;
    private JButton eliminarButton;
    private JButton actualizarButton;
    private JButton reporteButton;
    private JTable tablaProgramas;
    private DefaultTableModel tbmodel = (DefaultTableModel) tablaProgramas.getModel();
    TableRowSorter<DefaultTableModel> tr;

    private Empresa empresa;
    private RegistroPrograma registroPrograma;
    private ModificarPrograma modificarPrograma;

    private PortalPersonal() {
        listarPrograma();
        registroButton.addActionListener(e -> registrarPrograma());
        eliminarButton.addActionListener(e -> eliminarPrograma());
        actualizarButton.addActionListener(e -> actualizarPrograma());
    }

    public void listarPrograma(){
        Object[] column = {"Programa","Línea","Nombre","Cantidad de Curso"};
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
        for (Programa p:empresa.getProgramas()) {
            final Object[] tbRow = p.getObjetRow();
            tbRow[0] =p.getClass().getSimpleName();
            tbmodel.addRow(tbRow);
        }

        //Estilos tabla Cursos
        tablaProgramas.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
        tablaProgramas.getTableHeader().setEnabled(false);
        tablaProgramas.getTableHeader().setOpaque(false);
        tablaProgramas.getTableHeader().setBackground(new Color(78,145,140));
        tablaProgramas.setRowHeight(25);
    }

    public void registrarPrograma(){
        registroPrograma = RegistroPrograma.getInstance();
        registroPrograma.load();
    }

    public void actualizarPrograma(){
        int posicion = tablaProgramas.getSelectedRow();
        ModificarPrograma modificarCurso = new ModificarPrograma(posicion);
        modificarCurso.load();
    }

    public void eliminarPrograma(){
        empresa = Empresa.getInstance();
        int posicion = tablaProgramas.getSelectedRow();

        if (posicion>=0){
            empresa.getProgramas().remove(posicion);
            tbmodel.removeRow(posicion);
            JOptionPane.showMessageDialog( null, "Se elimino correctamente "+ posicion);
        }else {
            JOptionPane.showMessageDialog( null, "Error al eliminar");
        }
    }

    public static PortalPersonal getInstance(){
        return panel;
    }

    public void load(){
        this.frame.add(myPortalProgramas); // agregar panel al objeto
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // detener programa al cerrar
        this.frame.setUndecorated(false); // mostrar ventanas windows
        this.frame.pack();  //mostrar contenido
        this.frame.setLocationRelativeTo(null); //mostrar al centro
        this.frame.setVisible(true);    // que sea visible
        this.frame.setResizable(true); // bloqueo cambiar tamaño de ventana
        this.frame.setSize(800,500);
    }
}

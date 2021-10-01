package com.vistas;

import com.entities.Empresa;
import com.entities.Programa;
import com.entities.Seccion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;


public class ReportePrograma {

    private JPanel myReportePrograma;
    private JTextField textModPrograma;
    private JTextField textModLinea;
    private JTextField textModNombre;
    private JTextField textModCantidad;
    private JTable tableSeccionesAsignadas;
    private JFrame frame = new JFrame();
    private int index;
    private DefaultTableModel tbmodel = (DefaultTableModel) tableSeccionesAsignadas.getModel();
    TableRowSorter<DefaultTableModel> tr;
    Programa programa;

    private Empresa empresa;

    public ReportePrograma(int indice) {
        this.index=indice;
        empresa = Empresa.getInstance();
        programa = empresa.getProgramas().get(index);
        textModPrograma.setText(programa.getClass().getSimpleName());
        textModLinea.setText(programa.getLinea().toString());
        textModNombre.setText(programa.getNombre());
        textModCantidad.setText(String.valueOf(programa.getCantidadMaximaCursos()));
        listarSecciones();
    }

    public void listarSecciones(){
        Object[] column = {"Código","Curso","Profesor","Cantidad","Año"};
        tbmodel.setColumnIdentifiers(column);
        tableSeccionesAsignadas.setModel(tbmodel);
        tableSeccionesAsignadas.setAutoCreateRowSorter(true);
        tr = new TableRowSorter<>(tbmodel);
        tableSeccionesAsignadas.setRowSorter(tr);

        ////
        int rowCount = tbmodel.getRowCount();
        for(int i = rowCount-1; i>=0; i--){
            tbmodel.removeRow(i);
        }

        for (Seccion s:programa.getSecciones()) {
            final Object[] tbRow = s.getObjetRow();
            tbmodel.addRow(tbRow);
        }

        //Estilos tabla Cursos
        tableSeccionesAsignadas.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
        tableSeccionesAsignadas.getTableHeader().setEnabled(false);
        tableSeccionesAsignadas.getTableHeader().setOpaque(false);
        tableSeccionesAsignadas.getTableHeader().setBackground(new Color(78,145,140));
        tableSeccionesAsignadas.setRowHeight(25);
    }

    public void load(){
        this.frame.add(myReportePrograma); // agregar panel al objeto
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // detener programa al cerrar
        this.frame.setUndecorated(false); // mostrar ventanas windows
        this.frame.pack();  //mostrar contenido
        this.frame.setLocationRelativeTo(null); //mostrar al centro
        this.frame.setVisible(true);    // que sea visible
        this.frame.setSize(650,350);
        this.frame.setResizable(true); // bloqueo cambiar tamaño de ventana
    }
}

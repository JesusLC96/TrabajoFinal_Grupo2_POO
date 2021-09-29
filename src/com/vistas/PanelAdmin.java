package com.vistas;

import com.entities.Diplomado;
import com.entities.Programa;
import com.entities.Linea;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.*;
import java.util.List;

public class PanelAdmin {
    private static PanelAdmin panel = new PanelAdmin();
    private JFrame frame = new JFrame();
    private JPanel myPanelAdmin;
    private JButton registroButton;
    private JButton eliminarButton;
    private JButton actualizarButton;
    private JButton reporteButton;
    private JTable tablaCursos;
    private List<Programa> listaCursos = new ArrayList<>();
    private List<Linea> listaLinea = new ArrayList<>();
    private DefaultTableModel tbmodel = (DefaultTableModel) tablaCursos.getModel();
    TableRowSorter<DefaultTableModel> tr;

//    private Linea bi = new Linea("BI");
//    private Linea sap = new Linea("SAP");
//    private Linea excel = new Linea("EXCEL");
//    private Linea pmp = new Linea("PMP");

    private PanelAdmin() {
        // agregar lineas a una lista
//        listaLinea.add(bi);
//        listaLinea.add(sap);
//        listaLinea.add(excel);
//        listaLinea.add(pmp);

//        // Cursos pre-registrados
//        bi.asignarCurso("Curso","Analítica BI", 23,500, true);
//        bi.asignarCurso("Curso","Power BI Básico", 12,600, false);
//        bi.asignarCurso("Curso","Power BI Avanzado", 25,500, true);
//        sap.asignarCurso("Diplomado","Dimplomado SAP",50,100,false);
//        excel.asignarCurso("Especialización","Certificación Excel",70,1200,true);
//        pmp.asignarCurso("Diplomado","Diplomado Project Manager",20,1000,true);

        listar();

        registroButton.addActionListener(e ->loadRegistro());
        eliminarButton.addActionListener(e -> eliminarCurso());
        actualizarButton.addActionListener(e -> modificarCurso());
        //reporteButton.addActionListener(e ->  );


    }

    public void loadRegistro(){
        RegistroCurso registro = new RegistroCurso();
        registro.load();
    }

    public void eliminarCurso(){
        int posicion = tablaCursos.getSelectedRow();

        if (posicion>=0){
            listaCursos.remove(posicion);
            tbmodel.removeRow(posicion);

            JOptionPane.showMessageDialog( null, "Se elimino correctamente "+ posicion);
        }else {
            JOptionPane.showMessageDialog( null, "Error al eliminar");
        }
    }

    public void registrarCurso(String linea, String categoria, String nombre, int cantidad, double precio, boolean bonus){// throws  MyException{

//        if (linea.equals("BI")) {
//            bi.asignarCurso(categoria,nombre, cantidad, precio, bonus);
//            agregarATabla(bi);
//
//        } else if (linea.equals("SAP")) {
//            sap.asignarCurso(categoria,nombre, cantidad, precio, bonus);
//            agregarATabla(sap);
//
//        } else if (linea.equals("EXCEL")) {
//            excel.asignarCurso(categoria,nombre, cantidad, precio, bonus);
//            agregarATabla(excel);
//
//        } else if (linea.equals("PMP")) {
//            pmp.asignarCurso(categoria,nombre, cantidad, precio, bonus);
//            agregarATabla(pmp);
//        }

    }

    public void agregarATabla(Linea linea){
//        listaCursos.add(linea.getListaTodoslosCursos().get(linea.getListaTodoslosCursos().size()-1));
//        final Object[] tbRow = linea.getListaTodoslosCursos().get(linea.getListaTodoslosCursos().size()-1).getObjetRow();
//        tbRow[0]=linea.getNombreLinea();
//        tbmodel.addRow(tbRow);
    }

    public void modificarCurso(){
        int posicion = tablaCursos.getSelectedRow();
        ModificarCurso modificarCurso = new ModificarCurso(listaCursos,posicion);
        modificarCurso.load();
        //modificarCurso.obtenerlistaCursos(listaCursos,posicion);
    }

    public void actualizarCurso(int indice,String a, String b, int c, double d){

//        listaCursos.get(indice).setNombreCategoria(a);
//        listaCursos.get(indice).setNombreCurso(b);
//        listaCursos.get(indice).setCantVacantes(c);
//        listaCursos.get(indice).setPrecio(d);
//
//        tablaCursos.setValueAt(a,indice,1);
//        tablaCursos.setValueAt(b,indice,2);
//        tablaCursos.setValueAt(c,indice,3);
//        tablaCursos.setValueAt(d,indice,4);
//
//        System.out.println(a+b+c+d);

    }

    public void listar(){
//        Object[] column = {"Linea","Categoría","Nombre Curso","Vacantes","Precio","Bonus"};
//        tbmodel.setColumnIdentifiers(column);
//        tablaCursos.setModel(tbmodel);
//        tablaCursos.setAutoCreateRowSorter(true);
//        tr = new TableRowSorter<>(tbmodel);
//        tablaCursos.setRowSorter(tr);
//
//            for (Linea d:listaLinea){
//                String nombreLinea= d.getNombreLinea();
//                listaCursos.addAll(d.getListaTodoslosCursos());
//                for(Programa c: d.getListaTodoslosCursos()){
//                    final Object[] tbRow = c.getObjetRow();
//                    tbRow[0]=nombreLinea;
//                    tbmodel.addRow(tbRow);
//                }
//            }
//        //Estilos tabla Cursos
//        tablaCursos.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
//        tablaCursos.getTableHeader().setOpaque(false);
//        tablaCursos.getTableHeader().setBackground(new Color(78,145,140));
//        tablaCursos.setRowHeight(25);
    }

    public static PanelAdmin returnPanelAdmin(){
        return panel;
    }

    public void load(){
        this.frame.add(myPanelAdmin); // agregar panel al objeto
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // detener programa al cerrar
        this.frame.setUndecorated(false); // mostrar ventanas windows
        this.frame.pack();  //mostrar contenido
        this.frame.setLocationRelativeTo(null); //mostrar al centro
        this.frame.setVisible(true);    // que sea visible
        this.frame.setResizable(true); // bloqueo cambiar tamaño de ventana
    }

    public List<Programa> getListaCursos() {
        return listaCursos;
    }
}

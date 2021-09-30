package com.vistas;
//
import javax.swing.*;

//
public class RegistroCurso {
    private JPanel myRegistroCurso;
    public  JComboBox comboBoxLinea;
    public  JComboBox comboBoxCategoria;
    public  JTextField textFieldNombreCurso;
    public  JTextField textFieldCantVacantes;
    public  JTextField textFieldPrecio;
    public  JCheckBox checkBoxIncluyeBonus;
    public  JButton registrarNuevoCursoButton;
    private JFrame frame = new JFrame();
//    private Portal panelAdmin;
//
//    public static String a;
//
    public RegistroCurso(){
//
//        registrarNuevoCursoButton.addActionListener(e -> enviarDatos());
    }
//
//    public void enviarDatos(){
//       String linea = this.comboBoxLinea.getSelectedItem().toString();
//       String cate = this.comboBoxCategoria.getSelectedItem().toString();
//       String nomb = this.textFieldNombreCurso.getText();
//       int cant = Integer.parseInt(this.textFieldCantVacantes.getText());
//       double prec = Double.parseDouble(this.textFieldPrecio.getText());
//       boolean bonus = this.checkBoxIncluyeBonus.isSelected();
//
//       this.panelAdmin = Portal.returnPanelAdmin();
//       this.panelAdmin.registrarCurso(linea,cate,nomb,cant,prec,bonus);
//
//    }
//
//    public void load(){
//        this.frame.add(myRegistroCurso); // agregar panel al objeto
//        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // detener programa al cerrar
//        this.frame.setUndecorated(false); // mostrar ventanas windows
//        this.frame.pack();  //mostrar contenido
//        this.frame.setLocationRelativeTo(null); //mostrar al centro
//        this.frame.setVisible(true);    // que sea visible
//        this.frame.setSize(650,350);
//        this.frame.setResizable(true); // bloqueo cambiar tamaño de ventana
//    }
}

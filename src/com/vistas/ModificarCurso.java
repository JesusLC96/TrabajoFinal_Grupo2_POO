package com.vistas;

import com.entities.Programa;

import javax.swing.*;
import java.util.List;

public class ModificarCurso {
    private JPanel myModificarCurso;
    private JTextField textModCategoria;
    private JTextField textModCurso;
    private JTextField textModVacantes;
    private JTextField textModPrecio;
    private JButton buttonActualizarCurso;
    private JFrame frame = new JFrame();
    private List<Programa> listatemporal;
    private int index;
    private PanelAdmin panelAdmin;

    public ModificarCurso(List<Programa> lista, int indice) {
        this.index = indice;
        this.listatemporal = lista;

        textModCategoria.setText(listatemporal.get(index).getNombreCategoria());
        textModCurso.setText(listatemporal.get(index).getNombreCurso());
        textModVacantes.setText(String.valueOf(listatemporal.get(index).getCantVacantes()));
        textModPrecio.setText(String.valueOf(listatemporal.get(index).getPrecio()));
        buttonActualizarCurso.addActionListener(e -> actualizarCurso());

    }

    public void actualizarCurso(){
        String categoria = textModCategoria.getText();
        String curso = textModCurso.getText();
        int vacantes = Integer.parseInt(textModVacantes.getText());
        double precio= Double.parseDouble(textModPrecio.getText());
        this.panelAdmin = PanelAdmin.returnPanelAdmin();
        this.panelAdmin.actualizarCurso(index,categoria,curso,vacantes,precio);
        JOptionPane.showMessageDialog( null, "Se actualizó correctamente");

    }

    public void load(){
        this.frame.add(myModificarCurso); // agregar panel al objeto
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // detener programa al cerrar
        this.frame.setUndecorated(false); // mostrar ventanas windows
        this.frame.pack();  //mostrar contenido
        this.frame.setLocationRelativeTo(null); //mostrar al centro
        this.frame.setVisible(true);    // que sea visible
        this.frame.setSize(650,350);
        this.frame.setResizable(true); // bloqueo cambiar tamaño de ventana
    }
}

package com.clases;

public class Curso extends CategoriaCurso{
    private boolean examenSimulacro;

    public Curso(String nombreCategoria,String nombreCurso,int cantVacantes, double precio, boolean examenSimulacro) {
        super(nombreCategoria,nombreCurso,cantVacantes, precio);
        this.examenSimulacro = examenSimulacro;
    }

    public boolean isExamenSimulacro() {
        return examenSimulacro;
    }

    @Override
    public Object[] getObjetRow() {
        final Object[] row = new Object[6];
        row[1] = super.getNombreCategoria();
        row[2] = super.getNombreCurso();
        row[3] = super.getCantVacantes();
        row[4] = super.getPrecio();
        row[5] = examenSimulacro;
        return row;
    }

}

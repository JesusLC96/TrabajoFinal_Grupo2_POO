package com.clases;

public abstract class CategoriaCurso {
    private String nombreCategoria;
    private String nombreCurso;
    private int cantVacantes;
    private double precio;

    public CategoriaCurso(String nombreCategoria, String nombreCurso, int cantVacantes,double precio) {
        this.nombreCurso = nombreCurso;
        this.nombreCategoria = nombreCategoria;
        this.cantVacantes = cantVacantes;
        this.precio = precio;
    }

    public abstract Object[] getObjetRow();

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public int getCantVacantes() {
        return cantVacantes;
    }

    public double getPrecio() {
        return precio;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public void setCantVacantes(int cantVacantes) {
        this.cantVacantes = cantVacantes;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

package com.clases;

public class Especializacion extends CategoriaCurso{

    private boolean cursoOficialAdicional;

        public Especializacion(String nombreCategoria, String nombreCurso, int cantVacantes, double precio, boolean cursoOficialAdicional) {
        super(nombreCategoria, nombreCurso, cantVacantes, precio);
        this.cursoOficialAdicional = cursoOficialAdicional;
    }

    @Override
    public Object[] getObjetRow() {
        final Object[] row = new Object[6];
        row[1] = super.getNombreCategoria();
        row[2] = super.getNombreCurso();
        row[3] = super.getCantVacantes();
        row[4] = super.getPrecio();
        row[5] = cursoOficialAdicional;
        return row;
    }
}

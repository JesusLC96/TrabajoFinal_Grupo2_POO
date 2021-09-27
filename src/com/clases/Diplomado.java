package com.clases;

public class Diplomado extends CategoriaCurso{

    private boolean voucherExamenCertificación;

    public Diplomado(String nombreCategoria, String nombreCurso, int cantVacantes, double precio, boolean voucherExamenCertificación) {
        super(nombreCategoria,nombreCurso, cantVacantes, precio);
        this.voucherExamenCertificación = voucherExamenCertificación;
    }

    @Override
    public Object[] getObjetRow() {
        final Object[] row = new Object[6];
        row[1] = super.getNombreCategoria();
        row[2] = super.getNombreCurso();
        row[3] = super.getCantVacantes();
        row[4] = super.getPrecio();
        row[5] = voucherExamenCertificación;
        return row;
    }


}

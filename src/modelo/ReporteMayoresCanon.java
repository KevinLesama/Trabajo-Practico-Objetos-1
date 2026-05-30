package modelo;

public class ReporteMayoresCanon {

    private UnidadVenta unidad;
    private double canon;

    public ReporteMayoresCanon(UnidadVenta unidad, double canon) {
        this.unidad = unidad;
        this.canon = canon;
    }

    public UnidadVenta getUnidad() {
        return unidad;
    }

    public double getCanon() {
        return canon;
    }

    @Override
    public String toString() {
        return unidad.getNombreComercial()
                + "  Canon: $" + canon;
    }
}
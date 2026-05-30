package modelo;

public class PuestoDesarmable extends UnidadVenta {

    private int cantCarpas;
    private int tiempoMontaje;

    public PuestoDesarmable(String nombreComercial,
                            String codigo,
                            double superficie,
                            Festival festivalActual,
                            Personal responsable,
                            int cantCarpas,
                            int tiempoMontaje) {

        super(nombreComercial,
                codigo,
                superficie,
                festivalActual,
                responsable);

        this.cantCarpas = cantCarpas;
        this.tiempoMontaje = tiempoMontaje;
    }

    @Override
    public double calcularCanon(ConfiguracionCostos cfg) {

        return (getSuperficie()
                * cfg.getCostoSuperficie())
                -
                (tiempoMontaje
                        * cfg.getCostoMontajePorMin());
    }

    public int getCantCarpas() {
        return cantCarpas;
    }

    public int getTiempoMontaje() {
        return tiempoMontaje;
    }

    @Override
    public String toString() {
        return "Puesto - "
                + getNombreComercial();
    }
}
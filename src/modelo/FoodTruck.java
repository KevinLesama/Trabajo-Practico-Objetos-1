package modelo;

public class FoodTruck extends UnidadVenta {

    private String patente;
    private boolean requiereElectricidad;

    public FoodTruck(String nombreComercial,
                     String codigo,
                     double superficie,
                     Festival festivalActual,
                     Personal responsable,
                     String patente,
                     boolean requiereElectricidad) {

        super(nombreComercial,
                codigo,
                superficie,
                festivalActual,
                responsable);

        this.patente = patente;
        this.requiereElectricidad = requiereElectricidad;
    }

    @Override
    public double calcularCanon(ConfiguracionCostos cfg) {

        double canon =
                getSuperficie()
                        * cfg.getCostoSuperficie();

        if (requiereElectricidad) {
            canon += cfg.getCostoElectricidad();
        }

        return canon;
    }

    public String getPatente() {
        return patente;
    }

    public boolean isRequiereElectricidad() {
        return requiereElectricidad;
    }

    @Override
    public String toString() {
        return "FoodTruck  "
                + getNombreComercial();
    }
}
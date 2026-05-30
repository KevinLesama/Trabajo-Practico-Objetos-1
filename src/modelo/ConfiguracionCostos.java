package modelo;

public class ConfiguracionCostos {

    private double costoSuperficie;
    private double costoElectricidad;
    private double costoMontajePorMin;
    private double sueldoBase;

    public ConfiguracionCostos(double costoSuperficie, double costoElectricidad,
            double costoMontajePorMin, double sueldoBase) {

        this.costoSuperficie = costoSuperficie;
        this.costoElectricidad = costoElectricidad;
        this.costoMontajePorMin = costoMontajePorMin;
        this.sueldoBase = sueldoBase;
    }

    public double getCostoSuperficie() {
        return costoSuperficie;
    }

    public void setCostoSuperficie(double costoSuperficie) {
        this.costoSuperficie = costoSuperficie;
    }

    public double getCostoElectricidad() {
        return costoElectricidad;
    }

    public void setCostoElectricidad(double costoElectricidad) {
        this.costoElectricidad = costoElectricidad;
    }

    public double getCostoMontajePorMin() {
        return costoMontajePorMin;
    }

    public void setCostoMontajePorMin(double costoMontajePorMin) {
        this.costoMontajePorMin = costoMontajePorMin;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }
}
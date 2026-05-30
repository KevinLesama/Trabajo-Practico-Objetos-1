package modelo;

public class Plato {

    private static int contador = 1;

    private int idPlato;
    private String nombre;
    private double precioVenta;
    private double costoProduccion;

    public Plato(String nombre, double precioVenta, double costoProduccion) {

        this.idPlato = contador++;

        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.costoProduccion = costoProduccion;
    }

    public int getIdPlato() {
        return idPlato;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public double getCostoProduccion() {
        return costoProduccion;
    }

    @Override
    public String toString() {
        return nombre + " ($" + precioVenta + ")";
    }
}
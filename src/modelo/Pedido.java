package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {

    private static int contador = 1;

    private int idPedido;
    private LocalDate fecha;
    private Festival festival;
    private UnidadVenta unidad;
    private ArrayList<ItemPedido> items;

    public Pedido(LocalDate fecha,
                  Festival festival,
                  UnidadVenta unidad) {

        this.idPedido = contador++;

        this.fecha = fecha;
        this.festival = festival;
        this.unidad = unidad;

        this.items = new ArrayList<>();
    }

    public void agregarItem(ItemPedido item) {

        if (item != null) {
            items.add(item);
        }
    }

    public double totalPedido() {

        double total = 0;

        for (ItemPedido item : items) {
            total += item.subtotal();
        }

        return total;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Festival getFestival() {
        return festival;
    }

    public UnidadVenta getUnidad() {
        return unidad;
    }

    public ArrayList<ItemPedido> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Pedido #" + idPedido +
                " - Total: $" + totalPedido();
    }
}
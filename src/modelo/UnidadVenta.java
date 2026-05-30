package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class UnidadVenta {

    private static int contador = 1;

    private int idUnidadVenta;
    private String nombreComercial;
    private String codigo;
    private double superficie;
    private Festival festivalActual;

    private ArrayList<Plato> platos;
    private ArrayList<Personal> staff;
    private Personal responsable;
    private ArrayList<Pedido> pedidos;

    public UnidadVenta(String nombreComercial,
                       String codigo,
                       double superficie,
                       Festival festivalActual,
                       Personal responsable) {

        this.idUnidadVenta = contador++;

        this.nombreComercial = nombreComercial;
        this.codigo = codigo;
        this.superficie = superficie;
        this.festivalActual = festivalActual;
        this.responsable = responsable;

        this.platos = new ArrayList<>();
        this.staff = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public boolean esCodigoValido() {
        return codigo != null && codigo.length() == 10;
    }

    public abstract double calcularCanon(ConfiguracionCostos cfg);

    public double calcularRentabilidadNeta(ConfiguracionCostos cfg) {

        double ingresos = 0;
        double costosProduccion = 0;
        double costosSueldos = 0;

        for (Pedido pedido : pedidos) {

            ingresos += pedido.totalPedido();

            for (ItemPedido item : pedido.getItems()) {
                costosProduccion +=
                        item.getPlato().getCostoProduccion()
                        * item.getCantidad();
            }
        }

        for (Personal empleado : staff) {
            costosSueldos += empleado.calcularSueldo(cfg);
        }

        return ingresos
                - costosProduccion
                - costosSueldos
                - calcularCanon(cfg);
    }

    public double calcularRentabilidadNetaEntreFechas(
            LocalDate desde,
            LocalDate hasta,
            ConfiguracionCostos cfg) {

        double ingresos = 0;
        double costosProduccion = 0;
        double costosSueldos = 0;

        for (Pedido pedido : pedidos) {

            LocalDate fecha = pedido.getFecha();

            if (!fecha.isBefore(desde)
                    && !fecha.isAfter(hasta)) {

                ingresos += pedido.totalPedido();

                for (ItemPedido item : pedido.getItems()) {

                    costosProduccion +=
                            item.getPlato().getCostoProduccion()
                            * item.getCantidad();
                }
            }
        }

        for (Personal empleado : staff) {
            costosSueldos += empleado.calcularSueldo(cfg);
        }

        return ingresos
                - costosProduccion
                - costosSueldos
                - calcularCanon(cfg);
    }

    public void agregarPlato(Plato plato) {

        if (plato != null) {
            platos.add(plato);
        }
    }

    public void agregarPersonal(Personal personal) {

        if (personal != null) {
            staff.add(personal);
        }
    }

    public void agregarPedido(Pedido pedido) {

        if (pedido != null) {
            pedidos.add(pedido);
        }
    }

    public int getIdUnidadVenta() {
        return idUnidadVenta;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getSuperficie() {
        return superficie;
    }

    public Festival getFestivalActual() {
        return festivalActual;
    }

    public ArrayList<Plato> getPlatos() {
        return platos;
    }

    public ArrayList<Personal> getStaff() {
        return staff;
    }

    public Personal getResponsable() {
        return responsable;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setResponsable(Personal responsable) {

        if (staff.contains(responsable)) {
            this.responsable = responsable;
        }
    }

    @Override
    public String toString() {
        return nombreComercial +
                " (" + codigo + ")";
    }
}
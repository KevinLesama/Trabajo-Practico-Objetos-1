package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Sistema {

    private ArrayList<Festival> festivales;
    private ArrayList<UnidadVenta> unidades;
    private ArrayList<Personal> personal;
    private ArrayList<Pedido> pedidos;

    public Sistema() {

        festivales = new ArrayList<>();
        unidades = new ArrayList<>();
        personal = new ArrayList<>();
        pedidos = new ArrayList<>();
    }

    // ==========================
    // ALTAS Y BAJAS
    // ==========================

    public boolean agregarFestival(Festival f) {

        if (f == null || festivales.contains(f))
            return false;

        festivales.add(f);
        return true;
    }

    public boolean eliminarFestival(Festival f) {

        return festivales.remove(f);
    }

    public boolean agregarUnidad(UnidadVenta u) {

        if (u == null || unidades.contains(u))
            return false;

        unidades.add(u);
        return true;
    }

    public boolean eliminarUnidad(UnidadVenta u) {

        return unidades.remove(u);
    }

    public boolean agregarPersonal(Personal p) {

        if (p == null || personal.contains(p))
            return false;

        personal.add(p);
        return true;
    }

    public boolean eliminarPersonal(Personal p) {

        return personal.remove(p);
    }

    // ==========================
    // BUSQUEDAS
    // ==========================

    public Personal buscarPersonalPorDni(long dni) {

        for (Personal p : personal) {

            if (p.getDni() == dni) {
                return p;
            }
        }

        return null;
    }

    public UnidadVenta buscarUnidadPorCodigo(String codigo) {

        for (UnidadVenta u : unidades) {

            if (u.getCodigo().equals(codigo)) {
                return u;
            }
        }

        return null;
    }

    // ==========================
    // REGISTRAR PEDIDO
    // ==========================

    public boolean registrarPedido(Pedido pedido) {

        if (pedido == null) {
            return false;
        }

        UnidadVenta unidad =
                buscarUnidadPorCodigo(
                        pedido.getUnidad().getCodigo());

        if (unidad == null) {
            return false;
        }

        boolean festivalExiste = false;

        for (Festival f : festivales) {

            if (f.equals(pedido.getFestival())) {
                festivalExiste = true;
                break;
            }
        }

        if (!festivalExiste) {
            return false;
        }

        pedidos.add(pedido);

        unidad.agregarPedido(pedido);

        return true;
    }

    // ==========================
    // FILTRO EDAD
    // ==========================

    public ArrayList<Personal> filtrarPersonalPorEdad(
            LocalDate desde,
            LocalDate hasta) {

        ArrayList<Personal> resultado =
                new ArrayList<>();

        for (Personal p : personal) {

            LocalDate nacimiento =
                    p.getFechaNacimiento();

            if (!nacimiento.isBefore(desde)
                    && !nacimiento.isAfter(hasta)) {

                resultado.add(p);
            }
        }

        return resultado;
    }

    public ArrayList<Festival> getFestivales() {
        return festivales;
    }

    public ArrayList<UnidadVenta> getUnidades() {
        return unidades;
    }

    public ArrayList<Personal> getPersonal() {
        return personal;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
    public ArrayList<ReporteVenta> reporteRecaudacion(Festival festival) {

        ArrayList<ReporteVenta> reportes =
                new ArrayList<>();

        for (UnidadVenta unidad : unidades) {

            if (unidad.getFestivalActual().equals(festival)) {

                double total = 0;

                for (Pedido pedido : unidad.getPedidos()) {

                    if (pedido.getFestival().equals(festival)) {
                        total += pedido.totalPedido();
                    }
                }

                reportes.add(
                        new ReporteVenta(
                                unidad,
                                total));
            }
        }

        return reportes;
    }
    public ArrayList<ReporteVenta> rankingUnidades() {

        ArrayList<ReporteVenta> ranking =
                new ArrayList<>();

        for (UnidadVenta unidad : unidades) {

            double total = 0;

            for (Pedido pedido : unidad.getPedidos()) {

                total += pedido.totalPedido();
            }

            ranking.add(
                    new ReporteVenta(
                            unidad,
                            total));
        }

        for (int i = 0; i < ranking.size() - 1; i++) {

            for (int j = i + 1; j < ranking.size(); j++) {

                if (ranking.get(j).getTotalRecaudado()
                        > ranking.get(i).getTotalRecaudado()) {

                    ReporteVenta aux = ranking.get(i);

                    ranking.set(i, ranking.get(j));

                    ranking.set(j, aux);
                }
            }
        }

        return ranking;
    }
    public Plato platoEstrella(
            UnidadVenta unidad,
            Festival festival) {

        Plato mejorPlato = null;

        int mayorCantidad = 0;

        for (Plato plato : unidad.getPlatos()) {

            int cantidadVendida = 0;

            for (Pedido pedido : unidad.getPedidos()) {

                if (pedido.getFestival().equals(festival)) {

                    for (ItemPedido item : pedido.getItems()) {

                        if (item.getPlato().equals(plato)) {

                            cantidadVendida +=
                                    item.getCantidad();
                        }
                    }
                }
            }

            if (cantidadVendida > mayorCantidad) {

                mayorCantidad = cantidadVendida;

                mejorPlato = plato;
            }
        }

        return mejorPlato;
    }
    public ArrayList<Personal> auditoriaPersonal(
            Festival festival) {

        ArrayList<Personal> resultado =
                new ArrayList<>();

        for (UnidadVenta unidad : unidades) {

            if (unidad.getFestivalActual().equals(festival)) {

                for (Personal empleado : unidad.getStaff()) {

                    if (!resultado.contains(empleado)) {

                        resultado.add(empleado);
                    }
                }
            }
        }

        return resultado;
    }
    public ArrayList<ReporteMayoresCanon>
    calcularUnidadesMayorCanon(
            Festival festival) {

        ArrayList<ReporteMayoresCanon> reporte =
                new ArrayList<>();

        ConfiguracionCostos cfg =
                festival.getConfiguracion();

        for (UnidadVenta unidad : unidades) {

            if (unidad.getFestivalActual().equals(festival)) {

                reporte.add(
                        new ReporteMayoresCanon(
                                unidad,
                                unidad.calcularCanon(cfg)));
            }
        }

        for (int i = 0; i < reporte.size() - 1; i++) {

            for (int j = i + 1; j < reporte.size(); j++) {

                if (reporte.get(j).getCanon()
                        > reporte.get(i).getCanon()) {

                    ReporteMayoresCanon aux =
                            reporte.get(i);

                    reporte.set(i,
                            reporte.get(j));

                    reporte.set(j,
                            aux);
                }
            }
        }

        ArrayList<ReporteMayoresCanon> top3 =
                new ArrayList<>();

        for (int i = 0;
             i < reporte.size() && i < 3;
             i++) {

            top3.add(reporte.get(i));
        }

        return top3;
    }
    
}
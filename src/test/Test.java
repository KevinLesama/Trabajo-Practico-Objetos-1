package test;
import java.time.LocalDate;
import java.util.ArrayList;
import modelo.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Sistema sistema = new Sistema();

	        // =====================================================
	        // CONFIGURACION
	        // =====================================================

	        ConfiguracionCostos cfg =
	                new ConfiguracionCostos(
	                        500,
	                        2000,
	                        10,
	                        100000);

	        // =====================================================
	        // FESTIVALES
	        // =====================================================

	        Festival festivalVerano =
	                new Festival(
	                        "Festival Verano Gourmet",
	                        "VERANO",
	                        LocalDate.of(2026, 1, 10),
	                        LocalDate.of(2026, 1, 15),
	                        cfg);

	        Festival festivalInvierno =
	                new Festival(
	                        "Festival Invierno Gourmet",
	                        "INVIERNO",
	                        LocalDate.of(2026, 7, 10),
	                        LocalDate.of(2026, 7, 15),
	                        cfg);

	        sistema.agregarFestival(festivalVerano);
	        sistema.agregarFestival(festivalInvierno);

	        // =====================================================
	        // PERSONAL
	        // =====================================================

	        Cocinero coc1 =
	                new Cocinero(
	                        "Juan",
	                        "Perez",
	                        11111111,
	                        LocalDate.of(1990, 5, 10),
	                        LocalDate.of(2020, 1, 1),
	                        "Parrilla",
	                        25000);

	        Cocinero coc2 =
	                new Cocinero(
	                        "Maria",
	                        "Lopez",
	                        22222222,
	                        LocalDate.of(1988, 3, 20),
	                        LocalDate.of(2018, 2, 1),
	                        "Pastas",
	                        30000);

	        Cajero caj1 =
	                new Cajero(
	                        "Pedro",
	                        "Gomez",
	                        33333333,
	                        LocalDate.of(1995, 10, 15),
	                        LocalDate.of(2021, 4, 1),
	                        Turno.MANIANA);

	        Cajero caj2 =
	                new Cajero(
	                        "Lucia",
	                        "Martinez",
	                        44444444,
	                        LocalDate.of(1997, 8, 5),
	                        LocalDate.of(2022, 3, 1),
	                        Turno.NOCHE);

	        sistema.agregarPersonal(coc1);
	        sistema.agregarPersonal(coc2);
	        sistema.agregarPersonal(caj1);
	        sistema.agregarPersonal(caj2);

	        // =====================================================
	        // UNIDADES
	        // =====================================================

	        FoodTruck foodTruck =
	                new FoodTruck(
	                        "Truck Burgers",
	                        "FT12345678",
	                        40,
	                        festivalVerano,
	                        coc1,
	                        "ABC123",
	                        true);

	        PuestoDesarmable puesto =
	                new PuestoDesarmable(
	                        "Puesto Pastas",
	                        "PD12345678",
	                        25,
	                        festivalVerano,
	                        coc2,
	                        3,
	                        120);

	        foodTruck.agregarPersonal(coc1);
	        foodTruck.agregarPersonal(caj1);

	        puesto.agregarPersonal(coc2);
	        puesto.agregarPersonal(caj2);

	        sistema.agregarUnidad(foodTruck);
	        sistema.agregarUnidad(puesto);

	        // =====================================================
	        // PLATOS
	        // =====================================================

	        Plato hamburguesa =
	                new Plato("Hamburguesa", 12000, 4500);

	        Plato papas =
	                new Plato("Papas Fritas", 5000, 1800);

	        Plato ravioles =
	                new Plato("Ravioles", 10000, 3500);

	        Plato sorrentinos =
	                new Plato("Sorrentinos", 11000, 4000);

	        foodTruck.agregarPlato(hamburguesa);
	        foodTruck.agregarPlato(papas);

	        puesto.agregarPlato(ravioles);
	        puesto.agregarPlato(sorrentinos);

	        // =====================================================
	        // PEDIDO 1
	        // =====================================================

	        Pedido pedido1 =
	                new Pedido(
	                        LocalDate.of(2026, 1, 11),
	                        festivalVerano,
	                        foodTruck);

	        pedido1.agregarItem(
	                new ItemPedido(hamburguesa, 5));

	        pedido1.agregarItem(
	                new ItemPedido(papas, 10));

	        sistema.registrarPedido(pedido1);

	        // =====================================================
	        // PEDIDO 2
	        // =====================================================

	        Pedido pedido2 =
	                new Pedido(
	                        LocalDate.of(2026, 1, 12),
	                        festivalVerano,
	                        foodTruck);

	        pedido2.agregarItem(
	                new ItemPedido(hamburguesa, 8));

	        sistema.registrarPedido(pedido2);

	        // =====================================================
	        // PEDIDO 3
	        // =====================================================

	        Pedido pedido3 =
	                new Pedido(
	                        LocalDate.of(2026, 1, 12),
	                        festivalVerano,
	                        puesto);

	        pedido3.agregarItem(
	                new ItemPedido(ravioles, 6));

	        pedido3.agregarItem(
	                new ItemPedido(sorrentinos, 4));

	        sistema.registrarPedido(pedido3);

	        // =====================================================
	        // CU2 BUSQUEDA DNI
	        // =====================================================

	        System.out.println("==== BUSQUEDA DNI ====");

	        System.out.println(
	                sistema.buscarPersonalPorDni(
	                        11111111));

	        // =====================================================
	        // CU2 BUSQUEDA CODIGO
	        // =====================================================

	        System.out.println("\n==== BUSQUEDA CODIGO ====");

	        System.out.println(
	                sistema.buscarUnidadPorCodigo(
	                        "FT12345678"));

	        // =====================================================
	        // CU3 CANON
	        // =====================================================

	        System.out.println("\n==== CANON ====");

	        System.out.println(
	                foodTruck.calcularCanon(cfg));

	        System.out.println(
	                puesto.calcularCanon(cfg));

	        // =====================================================
	        // CU4 SUELDOS
	        // =====================================================

	        System.out.println("\n==== SUELDOS ====");

	        System.out.println(
	                coc1.calcularSueldo(cfg));

	        System.out.println(
	                caj1.calcularSueldo(cfg));

	        // =====================================================
	        // CU6 REPORTE RECAUDACION
	        // =====================================================

	        System.out.println("\n==== RECAUDACION ====");

	        ArrayList<ReporteVenta> ventas =
	                sistema.reporteRecaudacion(
	                        festivalVerano);

	        for (ReporteVenta rv : ventas) {
	            System.out.println(rv);
	        }

	        // =====================================================
	        // CU7 FILTRO PERSONAL
	        // =====================================================

	        System.out.println("\n==== FILTRO FECHAS ====");

	        ArrayList<Personal> filtrados =
	                sistema.filtrarPersonalPorEdad(
	                        LocalDate.of(1985, 1, 1),
	                        LocalDate.of(1993, 12, 31));

	        for (Personal p : filtrados) {
	            System.out.println(p);
	        }

	        // =====================================================
	        // CU8 RENTABILIDAD
	        // =====================================================

	        System.out.println("\n==== RENTABILIDAD ====");

	        System.out.println(foodTruck.calcularRentabilidadNeta(cfg));

	        // =====================================================
	        // CU9 RENTABILIDAD ENTRE FECHAS
	        // =====================================================

	        System.out.println(
	                foodTruck.calcularRentabilidadNetaEntreFechas(
	                        LocalDate.of(2026, 1, 10),
	                        LocalDate.of(2026, 1, 12),
	                        cfg));

	        // =====================================================
	        // CU10 RANKING
	        // =====================================================

	        System.out.println("\n==== RANKING ====");

	        for (ReporteVenta r :
	                sistema.rankingUnidades()) {

	            System.out.println(r);
	        }

	        // =====================================================
	        // CU11 PLATO ESTRELLA
	        // =====================================================

	        System.out.println("\n==== PLATO ESTRELLA ====");

	        System.out.println(
	                sistema.platoEstrella(
	                        foodTruck,
	                        festivalVerano));

	        // =====================================================
	        // CU12 AUDITORIA
	        // =====================================================

	        System.out.println("\n==== AUDITORIA ====");

	        for (Personal p :
	                sistema.auditoriaPersonal(
	                        festivalVerano)) {

	            System.out.println(p);
	        }

	        // =====================================================
	        // CU13 MAYOR CANON
	        // =====================================================

	        System.out.println("\n==== TOP CANON ====");

	        ArrayList<ReporteMayoresCanon> topCanon =
	                sistema.calcularUnidadesMayorCanon(
	                        festivalVerano);

	        for (ReporteMayoresCanon r : topCanon) {
	            System.out.println(r);
	        }
	}

}

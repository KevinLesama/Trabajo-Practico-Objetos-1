package modelo;

import java.time.LocalDate;

public class Festival {

    private static int contador = 1;

    private int idFestival;
    private String nombre;
    private String temporada;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private ConfiguracionCostos configuracion;

    public Festival(String nombre, String temporada,
            LocalDate fechaInicio, LocalDate fechaFin,
            ConfiguracionCostos configuracion) {

        this.idFestival = contador++;

        this.nombre = nombre;
        this.temporada = temporada;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.configuracion = configuracion;
    }

    public int getIdFestival() {
        return idFestival;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTemporada() {
        return temporada;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public ConfiguracionCostos getConfiguracion() {
        return configuracion;
    }

    @Override
    public String toString() {
        return "Festival [idFestival=" + idFestival +
                ", nombre=" + nombre +
                ", temporada=" + temporada + "]";
    }
}
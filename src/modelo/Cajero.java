package modelo;

import java.time.LocalDate;

public class Cajero extends Personal {

    private Turno turno;

    public Cajero(String nombre,
            String apellido,
            long dni,
            LocalDate fechaNacimiento,
            LocalDate fechaIngreso,
            Turno turno) {

        super(nombre, apellido, dni, fechaNacimiento, fechaIngreso);

        this.turno = turno;
    }

    @Override
    public double calcularSueldo(ConfiguracionCostos cfg) {

        return cfg.getSueldoBase()
                + (calcularAntiguedad() * 5000);
    }

    public Turno getTurno() {
        return turno;
    }

    @Override
    public String toString() {
        return "Cajero: "
                + getNombre()
                + " "
                + getApellido()
                + " - "
                + turno;
    }
}
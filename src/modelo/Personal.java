package modelo;

import java.time.LocalDate;
import java.time.Period;

public abstract class Personal {

    private String nombre;
    private String apellido;
    private long dni;
    private LocalDate fechaNacimiento;
    private LocalDate fechaIngreso;

    public Personal(String nombre, String apellido, long dni,
            LocalDate fechaNacimiento, LocalDate fechaIngreso) {

        if (Period.between(fechaNacimiento, LocalDate.now()).getYears() < 18) {
            throw new IllegalArgumentException("El personal debe ser mayor de edad");
        }

        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
    }

    public int calcularAntiguedad() {
        return Period.between(fechaIngreso, LocalDate.now()).getYears();
    }

    public abstract double calcularSueldo(ConfiguracionCostos cfg);

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public long getDni() {
        return dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido +
                " - DNI: " + dni;
    }
}
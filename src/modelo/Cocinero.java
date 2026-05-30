package modelo;

import java.time.LocalDate;

public class Cocinero extends Personal {

    private String especialidad;
    private double plusCategoria;

    public Cocinero(String nombre,
            String apellido,
            long dni,
            LocalDate fechaNacimiento,
            LocalDate fechaIngreso,
            String especialidad,
            double plusCategoria) {

        super(nombre, apellido, dni, fechaNacimiento, fechaIngreso);

        this.especialidad = especialidad;
        this.plusCategoria = plusCategoria;
    }

    @Override
    public double calcularSueldo(ConfiguracionCostos cfg) {

        return cfg.getSueldoBase() + plusCategoria;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public double getPlusCategoria() {
        return plusCategoria;
    }

    @Override
    public String toString() {
        return "Cocinero: " +
                getNombre() + " " +
                getApellido() +
                " - Especialidad: " +
                especialidad;
    }
}
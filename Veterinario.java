package clinicaveterinaria.model;

import java.time.LocalDate;
import java.util.Objects;

public class Veterinario {
    private int id;
    private String nombre;
    private String especialidad;
    private boolean disponible;

    public Veterinario(int id, String nombre, String especialidad, boolean disponible) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.disponible = disponible;
    }

    public Cita reservarCita(int citaId, Mascota mascota, LocalDate fecha) {
        disponible = false;
        return new Cita(citaId, mascota, this, fecha, "Pendiente", EstadoCita.PROGRAMADA);
    }

    public void diagnosticar(Cita cita, String diagnostico) {
        cita.setDiagnostico(diagnostico);
        cita.setEstado(EstadoCita.ATENDIDA);
    }

    public Factura generarFactura(int facturaId, Cita cita, double monto, LocalDate fecha) {
        return new Factura(facturaId, cita, monto, fecha, false);
    }

    public String crearReporte(Cita cita) {
        return "Reporte: " + nombre + " atendio a " +
                cita.getMascota().getNombre() + " con diagnostico " + cita.getDiagnostico();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Veterinario)) {
            return false;
        }
        Veterinario that = (Veterinario) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Veterinario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", disponible=" + disponible +
                '}';
    }
}

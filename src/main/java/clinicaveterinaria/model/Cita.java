package clinicaveterinaria.model;

import java.time.LocalDate;
import java.util.Objects;

public class Cita {
    private int id;
    private Mascota mascota;
    private Veterinario veterinario;
    private LocalDate fecha;
    private String diagnostico;
    private EstadoCita estado;

    public Cita(int id, Mascota mascota, Veterinario veterinario, LocalDate fecha, String diagnostico, EstadoCita estado) {
        this.id = id;
        this.mascota = mascota;
        this.veterinario = veterinario;
        this.fecha = fecha;
        this.diagnostico = diagnostico;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public EstadoCita getEstado() {
        return estado;
    }

    public void setEstado(EstadoCita estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cita)) {
            return false;
        }
        Cita cita = (Cita) o;
        return id == cita.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Cita{" +
                "id=" + id +
                ", mascota=" + mascota.getNombre() +
                ", veterinario=" + veterinario.getNombre() +
                ", fecha=" + fecha +
                ", diagnostico='" + diagnostico + '\'' +
                ", estado=" + estado +
                '}';
    }
}

package clinicaveterinaria.service;

import clinicaveterinaria.interfaces.IVeterinarioService;
import clinicaveterinaria.model.Cita;
import clinicaveterinaria.model.EstadoCita;
import clinicaveterinaria.model.Mascota;
import clinicaveterinaria.model.Veterinario;

import java.time.LocalDate;


public class DirectoVeterinario implements IVeterinarioService {
    @Override
    public Cita reservarCita(Mascota mascota, Veterinario veterinario, LocalDate fecha) {
        veterinario.setDisponible(false);
        return new Cita(999, mascota, veterinario, fecha, "Pendiente", EstadoCita.PROGRAMADA);
    }

    @Override
    public void diagnosticar(Cita cita, String diagnostico) {
        cita.setDiagnostico(diagnostico);
        cita.setEstado(EstadoCita.ATENDIDA);
    }
}

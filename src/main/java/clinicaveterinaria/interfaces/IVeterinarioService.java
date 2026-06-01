package clinicaveterinaria.interfaces;

import clinicaveterinaria.model.Cita;
import clinicaveterinaria.model.Mascota;
import clinicaveterinaria.model.Veterinario;

import java.time.LocalDate;

public interface IVeterinarioService {
    Cita reservarCita(Mascota mascota, Veterinario veterinario, LocalDate fecha);

    void diagnosticar(Cita cita, String diagnostico);
}

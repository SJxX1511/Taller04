package clinicaveterinaria.service;

import clinicaveterinaria.model.Cita;
import clinicaveterinaria.model.Mascota;
import clinicaveterinaria.model.Veterinario;
import clinicaveterinaria.repository.DirectoBaseDatos;

import java.time.LocalDate;


public class Clinica {
    private final DirectoVeterinario veterinarioService;
    private final DirectoBaseDatos baseDatos;

    public Clinica() {
        this.veterinarioService = new DirectoVeterinario();
        this.baseDatos = new DirectoBaseDatos();
    }

    public Cita agendarConsultaRapida(Mascota mascota, Veterinario veterinario) {
        baseDatos.conectar();
        Cita cita = veterinarioService.reservarCita(mascota, veterinario, LocalDate.now());
        baseDatos.getCitas().add(cita);
        return cita;
    }
}

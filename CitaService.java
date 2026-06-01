package clinicaveterinaria.service;

import clinicaveterinaria.model.Cita;
import clinicaveterinaria.repository.BaseDatos;

import java.util.List;

public class CitaService {
    private final BaseDatos baseDatos;

    public CitaService(BaseDatos baseDatos) {
        this.baseDatos = baseDatos;
    }

    public void crearCita(Cita cita) {
        baseDatos.getCitas().add(cita);
        baseDatos.registrarOperacion("crearCita");
    }

    public Cita obtenerCita(int id) {
        for (Cita cita : baseDatos.getCitas()) {
            if (cita.getId() == id) {
                return cita;
            }
        }
        return null;
    }

    public void actualizarCita(Cita cita) {
        eliminarCita(cita.getId());
        crearCita(cita);
    }

    public void eliminarCita(int id) {
        baseDatos.getCitas().removeIf(cita -> cita.getId() == id);
        baseDatos.registrarOperacion("eliminarCita");
    }

    public List<Cita> listarCitas() {
        return baseDatos.getCitas();
    }
}

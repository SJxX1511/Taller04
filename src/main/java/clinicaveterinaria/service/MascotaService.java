package clinicaveterinaria.service;

import clinicaveterinaria.model.Mascota;
import clinicaveterinaria.repository.BaseDatos;

import java.util.List;

public class MascotaService {
    private final BaseDatos baseDatos;

    public MascotaService(BaseDatos baseDatos) {
        this.baseDatos = baseDatos;
    }

    public void crearMascota(Mascota mascota) {
        baseDatos.getMascotas().add(mascota);
        baseDatos.registrarOperacion("crearMascota");
    }

    public Mascota obtenerMascota(int id) {
        for (Mascota mascota : baseDatos.getMascotas()) {
            if (mascota.getId() == id) {
                return mascota;
            }
        }
        return null;
    }

    public void actualizarMascota(Mascota mascota) {
        eliminarMascota(mascota.getId());
        crearMascota(mascota);
    }

    public void eliminarMascota(int id) {
        baseDatos.getMascotas().removeIf(mascota -> mascota.getId() == id);
        baseDatos.registrarOperacion("eliminarMascota");
    }

    public List<Mascota> listarMascotas() {
        return baseDatos.getMascotas();
    }
}

package clinicaveterinaria.interfaces;

import clinicaveterinaria.model.Mascota;
import java.util.Optional;

public interface IMascotaService {
void crearMascota(Mascota mascota);

    Mascota obtenerMascota(int id);

    void actualizarMascota(Mascota mascota);

    void eliminarMascota(int id);
}

package clinicaveterinaria.service;

import clinicaveterinaria.model.TipoTratamiento;
import clinicaveterinaria.model.ITratamiento;
import clinicaveterinaria.repository.BaseDatos;

import java.util.List;


public class TratamientoService {
    private final BaseDatos baseDatos;

    public TratamientoService(BaseDatos baseDatos) {
        this.baseDatos = baseDatos;
    }

    public void crearTratamiento(ITratamiento tratamiento) {
        baseDatos.getTratamientos().add(tratamiento);
        baseDatos.registrarOperacion("crearTratamiento");
    }

    public ITratamiento obtenerTratamiento(int id) {
        for (ITratamiento tratamiento : baseDatos.getTratamientos()) {
            if (tratamiento.getId() == id) {
                return tratamiento;
            }
        }
        return null;
    }

    public void actualizarTratamiento(ITratamiento tratamiento) {
        eliminarTratamiento(tratamiento.getId());
        crearTratamiento(tratamiento);
    }

    public void eliminarTratamiento(int id) {
        baseDatos.getTratamientos().removeIf(tratamiento -> tratamiento.getId() == id);
        baseDatos.registrarOperacion("eliminarTratamiento");
    }

    public String prepararSala(ITratamientos tratamiento) {
        return tratamientos.prepararSala();
    }

    public List<ITratamiento> listarTratamientos() {
        return baseDatos.getTratamientos();
    }
}

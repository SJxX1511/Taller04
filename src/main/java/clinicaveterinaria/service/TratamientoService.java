package clinicaveterinaria.service;

import clinicaveterinaria.model.TipoTratamiento;
import clinicaveterinaria.model.Tratamiento;
import clinicaveterinaria.repository.BaseDatos;

import java.util.List;


public class TratamientoService {
    private final BaseDatos baseDatos;

    public TratamientoService(BaseDatos baseDatos) {
        this.baseDatos = baseDatos;
    }

    public void crearTratamiento(Tratamiento tratamiento) {
        baseDatos.getTratamientos().add(tratamiento);
        baseDatos.registrarOperacion("crearTratamiento");
    }

    public Tratamiento obtenerTratamiento(int id) {
        for (Tratamiento tratamiento : baseDatos.getTratamientos()) {
            if (tratamiento.getId() == id) {
                return tratamiento;
            }
        }
        return null;
    }

    public void actualizarTratamiento(Tratamiento tratamiento) {
        eliminarTratamiento(tratamiento.getId());
        crearTratamiento(tratamiento);
    }

    public void eliminarTratamiento(int id) {
        baseDatos.getTratamientos().removeIf(tratamiento -> tratamiento.getId() == id);
        baseDatos.registrarOperacion("eliminarTratamiento");
    }

    public String prepararSala(Tratamiento tratamiento) {
        if (tratamiento.getTipo() == TipoTratamiento.VACUNA) {
            return "Preparar refrigeracion y jeringas.";
        } else if (tratamiento.getTipo() == TipoTratamiento.CIRUGIA) {
            return "Preparar quirofano y anestesia.";
        } else if (tratamiento.getTipo() == TipoTratamiento.MEDICAMENTO) {
            return "Preparar receta y dosis.";
        } else if (tratamiento.getTipo() == TipoTratamiento.FISIOTERAPIA) {
            return "Preparar camilla y bandas elasticas.";
        }
        return "Sin preparacion.";
    }

    public List<Tratamiento> listarTratamientos() {
        return baseDatos.getTratamientos();
    }
}

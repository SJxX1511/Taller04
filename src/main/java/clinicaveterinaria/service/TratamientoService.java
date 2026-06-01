package clinicaveterinaria.service;

import java.util.List;

import clinicaveterinaria.model.Tratamiento;
import clinicaveterinaria.repository.BaseDatos;


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

    public String prepararSala(Tratamiento tratamiento) {
        switch (tratamiento.getTipo()) {
            case VACUNA:
                return "Preparar refrigeracion y jeringas.";
            case CIRUGIA:
                return "Preparar quirofano y anestesia.";
            case MEDICAMENTO:
                return "Preparar receta y dosis.";
            case FISIOTERAPIA:
                return "Preparar camilla y bandas elasticas.";
            default:
                return "Sin preparacion.";
        }
    }

    public List<ITratamiento> listarTratamientos() {
        return baseDatos.getTratamientos();
    }
}

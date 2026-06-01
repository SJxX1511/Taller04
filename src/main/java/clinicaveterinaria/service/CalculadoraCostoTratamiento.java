package clinicaveterinaria.service;

import clinicaveterinaria.model.TipoTratamiento;
import clinicaveterinaria.model.Tratamiento;


public class CalculadoraCostoTratamiento {
    public double calcularConImpuestos(Tratamiento tratamiento) {
        if (tratamiento.getTipo() == TipoTratamiento.VACUNA) {
            return tratamiento.getCosto() * 1.12;
        } else if (tratamiento.getTipo() == TipoTratamiento.CIRUGIA) {
            return tratamiento.getCosto() * 1.35;
        } else if (tratamiento.getTipo() == TipoTratamiento.MEDICAMENTO) {
            return tratamiento.getCosto() * 1.08;
        } else if (tratamiento.getTipo() == TipoTratamiento.FISIOTERAPIA) {
            return tratamiento.getCosto() * 1.05;
        }
        return tratamiento.getCosto();
    }
}

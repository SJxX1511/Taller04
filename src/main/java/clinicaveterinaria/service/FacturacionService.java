package clinicaveterinaria.service;

import clinicaveterinaria.model.Cita;
import clinicaveterinaria.model.Factura;
import clinicaveterinaria.repository.BaseDatos;

import java.time.LocalDate;

public class FacturacionService {
    private final BaseDatos baseDatos;

    public FacturacionService(BaseDatos baseDatos) {
        this.baseDatos = baseDatos;
    }

    public Factura generarFactura(int id, Cita cita, double monto) {
        Factura factura = new Factura(id, cita, monto, LocalDate.now(), false);
        baseDatos.getFacturas().add(factura);
        return factura;
    }
}

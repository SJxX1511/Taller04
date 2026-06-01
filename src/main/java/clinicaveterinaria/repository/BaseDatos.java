package clinicaveterinaria.repository;

import clinicaveterinaria.interfaces.IBaseDatos;
import clinicaveterinaria.model.Cita;
import clinicaveterinaria.model.Factura;
import clinicaveterinaria.model.Mascota;
import clinicaveterinaria.model.Tratamiento;
import clinicaveterinaria.model.Veterinario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BaseDatos implements IBaseDatos {
    private final List<Mascota> mascotas = new ArrayList<>();
    private final List<Veterinario> veterinarios = new ArrayList<>();
    private final List<Cita> citas = new ArrayList<>();
    private final List<Tratamiento> tratamientos = new ArrayList<>();
    private final List<Factura> facturas = new ArrayList<>();
    private final Map<String, Integer> auditoria = new HashMap<>();

    @Override
    public List<Mascota> getMascotas() {
        return mascotas;
    }

    @Override
    public List<Veterinario> getVeterinarios() {
        return veterinarios;
    }

    @Override
    public List<Cita> getCitas() {
        return citas;
    }

    @Override
    public List<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    @Override
    public List<Factura> getFacturas() {
        return facturas;
    }

    public void registrarOperacion(String nombre) {
        auditoria.put(nombre, auditoria.getOrDefault(nombre, 0) + 1);
    }

    public Map<String, Integer> getAuditoria() {
        return auditoria;
    }

    public double calcularIngresosMensual() {
        double total = 0;
        int mesActual = LocalDate.now().getMonthValue();
        int anioActual = LocalDate.now().getYear();
        for (Factura factura : facturas) {
            if (factura.isPagada()
                    && factura.getFecha().getMonthValue() == mesActual
                    && factura.getFecha().getYear() == anioActual) {
                total += factura.getMonto();
            }
        }
        return total;
    }
}

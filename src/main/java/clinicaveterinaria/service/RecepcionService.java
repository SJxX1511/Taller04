package clinicaveterinaria.service;

import clinicaveterinaria.interfaces.IServicioClinica;
import clinicaveterinaria.model.Cita;
import clinicaveterinaria.model.Factura;
import clinicaveterinaria.model.Mascota;
import clinicaveterinaria.model.Tratamiento;
import clinicaveterinaria.model.Veterinario;

import java.util.List;


public class RecepcionService implements IServicioClinica {
    private final ServicioClinicaCompleto servicioCompleto;

    public RecepcionService(ServicioClinicaCompleto servicioCompleto) {
        this.servicioCompleto = servicioCompleto;
    }

    @Override
    public void crearMascota(Mascota mascota) {
        servicioCompleto.crearMascota(mascota);
    }

    @Override
    public Mascota obtenerMascota(int id) {
        return servicioCompleto.obtenerMascota(id);
    }

    @Override
    public void actualizarMascota(Mascota mascota) {
        servicioCompleto.actualizarMascota(mascota);
    }

    @Override
    public void eliminarMascota(int id) {
        servicioCompleto.eliminarMascota(id);
    }

    @Override
    public void crearVeterinario(Veterinario veterinario) {
        servicioCompleto.crearVeterinario(veterinario);
    }

    @Override
    public Veterinario obtenerVeterinario(int id) {
        return servicioCompleto.obtenerVeterinario(id);
    }

    @Override
    public void actualizarVeterinario(Veterinario veterinario) {
        throw new UnsupportedOperationException("Recepcion no actualiza veterinarios.");
    }

    @Override
    public void eliminarVeterinario(int id) {
        throw new UnsupportedOperationException("Recepcion no elimina veterinarios.");
    }

    @Override
    public void crearCita(Cita cita) {
        servicioCompleto.crearCita(cita);
    }

    @Override
    public Cita obtenerCita(int id) {
        return servicioCompleto.obtenerCita(id);
    }

    @Override
    public void cancelarCita(int id) {
        servicioCompleto.cancelarCita(id);
    }

    @Override
    public void crearTratamiento(Tratamiento tratamiento) {
        throw new UnsupportedOperationException("Recepcion no crea tratamientos.");
    }

    @Override
    public double calcularTratamiento(Tratamiento tratamiento) {
        throw new UnsupportedOperationException("Recepcion no calcula tratamientos.");
    }

    @Override
    public void crearFactura(Factura factura) {
        throw new UnsupportedOperationException("Recepcion no crea facturas.");
    }

    @Override
    public void pagarFactura(int id) {
        throw new UnsupportedOperationException("Recepcion no cobra facturas.");
    }

    @Override
    public List<Cita> generarReporteCitasPorVeterinario(int veterinarioId) {
        throw new UnsupportedOperationException("Recepcion no genera reportes.");
    }

    @Override
    public List<Mascota> generarReporteMascotasPorDueno(String duenoNombre) {
        throw new UnsupportedOperationException("Recepcion no genera reportes.");
    }

    @Override
    public double calcularIngresosMensual() {
        throw new UnsupportedOperationException("Recepcion no calcula ingresos.");
    }
}

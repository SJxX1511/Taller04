package clinicaveterinaria.interfaces;

import clinicaveterinaria.model.Cita;
import clinicaveterinaria.model.Factura;
import clinicaveterinaria.model.Mascota;
import clinicaveterinaria.model.Tratamiento;
import clinicaveterinaria.model.Veterinario;

import java.util.List;


public interface IServicioClinica {
    void crearMascota(Mascota mascota);

    Mascota obtenerMascota(int id);

    void actualizarMascota(Mascota mascota);

    void eliminarMascota(int id);

    void crearVeterinario(Veterinario veterinario);

    Veterinario obtenerVeterinario(int id);

    void actualizarVeterinario(Veterinario veterinario);

    void eliminarVeterinario(int id);

    void crearCita(Cita cita);

    Cita obtenerCita(int id);

    void cancelarCita(int id);

    void crearTratamiento(Tratamiento tratamiento);

    double calcularTratamiento(Tratamiento tratamiento);

    void crearFactura(Factura factura);

    void pagarFactura(int id);

    List<Cita> generarReporteCitasPorVeterinario(int veterinarioId);

    List<Mascota> generarReporteMascotasPorDueno(String duenoNombre);

    double calcularIngresosMensual();
}

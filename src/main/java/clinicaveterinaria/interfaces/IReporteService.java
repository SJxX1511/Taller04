package clinicaveterinaria.interfaces;

import java.util.List;

import clinicaveterinaria.model.Cita;
import clinicaveterinaria.model.Mascota;
public interface IReporteService {
    List<Cita> generarReporteCitasPorVeterinario(int veterinarioId);

    List<Mascota> generarReporteMascotasPorDueno(String duenoNombre);

    double calcularIngresosMensual();
}
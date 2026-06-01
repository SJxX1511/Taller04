package clinicaveterinaria;

import java.time.LocalDate;
import java.util.List;

import clinicaveterinaria.interfaces.Icaminar;
import clinicaveterinaria.interfaces.Inadar;
import clinicaveterinaria.interfaces.Ivolar;
import clinicaveterinaria.model.Animal;
import clinicaveterinaria.model.Cita;
import clinicaveterinaria.model.Factura;
import clinicaveterinaria.model.Gato;
import clinicaveterinaria.model.Mascota;
import clinicaveterinaria.model.Pajaro;
import clinicaveterinaria.model.Perro;
import clinicaveterinaria.model.Pez;
import clinicaveterinaria.model.TipoAnimal;
import clinicaveterinaria.model.TipoTratamiento;
import clinicaveterinaria.model.Tratamiento;
import clinicaveterinaria.model.Veterinario;
import clinicaveterinaria.repository.BaseDatos;
import clinicaveterinaria.service.CalculadoraCostoTratamiento;
import clinicaveterinaria.service.Clinica;
import clinicaveterinaria.service.DiagnosticoService;
import clinicaveterinaria.service.FacturacionService;
import clinicaveterinaria.service.MascotaService;
import clinicaveterinaria.service.ReporteService;
import clinicaveterinaria.service.ReservaService;
import clinicaveterinaria.service.ServicioClinicaCompleto;
import clinicaveterinaria.service.TratamientoService;
import clinicaveterinaria.service.VeterinarioCrudService;

import clinicaveterinaria.model.Animal;
import clinicaveterinaria.model.Cita;
import clinicaveterinaria.model.Factura;
import clinicaveterinaria.model.Mascota;
import clinicaveterinaria.model.Pez;
import clinicaveterinaria.model.TipoAnimal;
import clinicaveterinaria.model.TipoTratamiento;
import clinicaveterinaria.model.Tratamiento;
import clinicaveterinaria.model.Veterinario;
import clinicaveterinaria.repository.BaseDatos;
import clinicaveterinaria.service.CalculadoraCostoTratamiento;
import clinicaveterinaria.service.Clinica;
import clinicaveterinaria.service.DiagnosticoService;
import clinicaveterinaria.service.FacturacionService;
import clinicaveterinaria.service.MascotaService;
import clinicaveterinaria.service.ReporteService;
import clinicaveterinaria.service.ReservaService;
import clinicaveterinaria.service.ServicioClinicaCompleto;
import clinicaveterinaria.service.TratamientoService;
import clinicaveterinaria.service.VeterinarioCrudService;

public class Main {
    public static void main(String[] args) {
        BaseDatos baseDatos = new BaseDatos();
        MascotaService mascotaService = new MascotaService(baseDatos);
        VeterinarioCrudService veterinarioCrudService = new VeterinarioCrudService(baseDatos);
        ReservaService reservaService = new ReservaService(baseDatos);
        DiagnosticoService diagnosticoService = new DiagnosticoService();
        FacturacionService facturacionService = new FacturacionService(baseDatos);
        TratamientoService tratamientoService = new TratamientoService(baseDatos);
        ReporteService reporteService = new ReporteService(baseDatos);

        Mascota mascota = new Mascota(1, "Luna", TipoAnimal.PERRO, 4, "Ana Perez");
        Veterinario veterinario = new Veterinario(1, "Dr. Ruiz", "Medicina general", true);
        ITratamiento tratamiento = new ITratamiento(1, TipoTratamiento.CIRUGIA, "Esterilizacion", 120.0);

        mascotaService.crearMascota(mascota);
        veterinarioCrudService.crearVeterinario(veterinario);
        tratamientoService.crearTratamiento(tratamiento);

        Cita cita = reservaService.reservarCita(1, mascota, veterinario, LocalDate.now());
        diagnosticoService.diagnosticar(cita, "Paciente estable para tratamiento.");
        Factura factura = facturacionService.generarFactura(1, cita, tratamiento.calcularCostoFinal());
        factura.setPagada(true);

        System.out.println("=== ClinicaVeterinaria funcionando ===");
        System.out.println(mascotaService.obtenerMascota(1));
        System.out.println(cita);
        System.out.println(factura);
        System.out.println("Preparacion: " + tratamientoService.prepararSala(tratamiento));
        System.out.println("Costo con impuestos: " + new CalculadoraCostoTratamiento().calcularConImpuestos(tratamiento));
        System.out.println("Citas Dr. Ruiz: " + reporteService.generarReporteCitasPorVeterinario(1).size());
        System.out.println("Mascotas de Ana Perez: " + reporteService.generarReporteMascotasPorDueno("Ana Perez").size());
        System.out.println("Ingresos del mes: " + reporteService.calcularIngresosMensual());

        demostrarUsoDeServicios(veterinario, mascota, reservaService, diagnosticoService, reporteService);
        new Clinica().agendarConsultaRapida(mascota, veterinario);
        new ServicioClinicaCompleto(baseDatos).calcularTratamiento(tratamiento);    
        demostrarLSP();
    }

    private static void demostrarUsoDeServicios(Veterinario veterinario, Mascota mascota,
                                               ReservaService reservaService,
                                               DiagnosticoService diagnosticoService,
                                               ReporteService reporteService) {
        Cita citaDesdeServicio = reservaService.reservarCita(2, mascota, veterinario, LocalDate.now().plusDays(1));
        diagnosticoService.diagnosticar(citaDesdeServicio, "Ejemplo de SRP aplicado desde el servicio.");
        System.out.println(reporteService.generarReporte(citaDesdeServicio));

        Inadar pez = new Pez(3, "Nemo");
        pez.nadar();
        System.out.println("El pez heredó caminar() y volar(), aunque no debe usarlos.");
    }

    private static void demostrarLSP() {
        System.out.println("\n=== LSP: jerarquía de animales corregida ===");

        Perro  perro  = new Perro(1, "Rex");
        Gato   gato   = new Gato(2, "Mishi");
        Pajaro pajaro = new Pajaro(3, "Pico");
        Pez    pez    = new Pez(4, "Nemo");


        System.out.println("-- Animales que caminan --");
        List<Icaminar> caminadores = List.of(perro, gato, pajaro);
        for (Icaminar c : caminadores) {
            c.caminar();   
        }

        System.out.println("-- Animales que nadan --");
        List<Inadar> nadadores = List.of(perro, pez);
        for (Inadar n : nadadores) {
            n.nadar();
        }

        System.out.println("-- Animales que vuelan --");
        List<Ivolar> voladores = List.of(pajaro);
        for (Ivolar v : voladores) {
            v.volar();
        }

        System.out.println("-- Capacidades por paciente --");
        List<Animal> pacientes = List.of(perro, gato, pajaro, pez);
        for (Animal a : pacientes) {
            System.out.print(a.getNombre() + ": ");
            if (a instanceof Icaminar) System.out.print("[caminar] ");
            if (a instanceof Inadar)   System.out.print("[nadar] ");
            if (a instanceof Ivolar)   System.out.print("[volar] ");
            System.out.println();
        }
    }
}

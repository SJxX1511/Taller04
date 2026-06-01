package clinicaveterinaria.service;

import clinicaveterinaria.repository.BaseDatos;


public class GestorReportesClinica {
    private final BaseDatos baseDatos = new BaseDatos();

    public void imprimirResumenOperaciones() {
        System.out.println("Resumen interno: " + baseDatos.getAuditoria());
    }
}

package clinicaveterinaria.model;

public class TratamientoFisioterapia implements ITratamiento {
    private final double costo;

    public TratamientoFisioterapia(double costo){
        this.costo = costo;
    }
    
    @Override
    public double calcularCostoFinal(){
        return costo * 0.95;
    }

    @Override
    public String obtenerIndicaciones(){
        return "Repetir sesiones dos veces por semana.";
    }

    @Override
    public String prepararSala(){
        return "Preparar camilla y bandas elasticas.";
    }

    @Override
    public double calcularConImpuestos(){
        return tratamiento.getCosto() * 1.05;
    }
}

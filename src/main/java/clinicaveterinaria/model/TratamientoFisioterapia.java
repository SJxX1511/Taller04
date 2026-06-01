package clinicaveterinaria.model;

public class TratamientoFisioterapia implements Tratamientos {
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
}

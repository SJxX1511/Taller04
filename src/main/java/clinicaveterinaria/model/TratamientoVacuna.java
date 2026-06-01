package clinicaveterinaria.model;

public class TratamientoVacuna implements Tratamientos {
    private final double costo;

    public TratamientoVacuna(double costo){
        this.costo = costo;
    }

    @Override
    public double double calcularCostoFinal() {
        return costo + 5.0;
    }

    @Override
    public String obtenerIndicaciones(){
        return "Observar fiebre durante 24 horas.";
    }
}

package clinicaveterinaria.model;

public class TratamientoVacuna implements ITratamiento {
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

    @Override
    public String prepararSala(){
        return "Preparar refrigeracion y jeringas.";
    }

    @Override
    public double calcularConImpuestos(){
        return tratamiento.getCosto() * 1.12;
    }

}

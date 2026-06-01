package clinicaveterinaria.model;

public class TratamientoMedicamento implements Tratamientos{
    private final double costo;

    public TratamientoMedicamento(double costo){
        this.costo = costo;
    }

    @Override
    public double calcularCostoFinal(){
        return costo * 1.10;
    }

    @Override
    public String obtenerIndicaciones() {
        return "Administrar segun receta.";
    }
}
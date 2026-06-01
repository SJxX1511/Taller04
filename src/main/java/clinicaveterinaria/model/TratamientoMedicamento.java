package clinicaveterinaria.model;

public class TratamientoMedicamento implements ITratamiento{
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

    @Override
    public String prepararSala(){
        return "Preparar receta y dosis.";
    }

    @Override
    public double calcularConImpuestos(){
        return tratamiento.getCosto() * 1.08;
    }
}
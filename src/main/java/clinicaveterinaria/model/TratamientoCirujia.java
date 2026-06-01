package clinicaveterinaria.model;

public class TratamientoCirujia implements ITratamiento{
    private final double costo;

    public TratamientoCirujia(double costo){
        this.costo = costo;
    }

    @Override
    public double calcularCostoFinal(){
        return costo * 1.25 + 80.0;
    }

    @Override
    public String obtenerIndicaciones(){
        return "Ayuno previo y control postoperatorio.";
    }

    @Override
    public String prepararSala(){
        return "Preparar quirofano y anestesia.";
    }

    @Override
    public double calcularConImpuestos(){
        return tratamiento.getCosto() * 1.35;
    }
}

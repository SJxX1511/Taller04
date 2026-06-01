package clinicaveterinaria.model;

public class TratamientoCirujia implements Tratamientos{
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
}

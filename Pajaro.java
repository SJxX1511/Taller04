package clinicaveterinaria.model;


public class Pajaro extends Animal {
    public Pajaro(int id, String nombre) {
        super(id, nombre, TipoAnimal.PAJARO);
    }

    @Override
    public void nadar() {
        throw new UnsupportedOperationException("Un pajaro de consulta general no nada.");
    }
}

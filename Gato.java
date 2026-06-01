package clinicaveterinaria.model;


public class Gato extends Animal {
    public Gato(int id, String nombre) {
        super(id, nombre, TipoAnimal.GATO);
    }

    @Override
    public void nadar() {
        throw new UnsupportedOperationException("Este gato no nada.");
    }
}

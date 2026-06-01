package clinicaveterinaria.model;


public class Perro extends Animal {
    public Perro(int id, String nombre) {
        super(id, nombre, TipoAnimal.PERRO);
    }

    @Override
    public void volar() {
        throw new UnsupportedOperationException("Un perro no puede volar.");
    }
}

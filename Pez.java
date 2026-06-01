package clinicaveterinaria.model;


public class Pez extends Animal {
    public Pez(int id, String nombre) {
        super(id, nombre, TipoAnimal.PEZ);
    }

    @Override
    public void caminar() {
        throw new UnsupportedOperationException("Un pez no puede caminar.");
    }

    @Override
    public void volar() {
        throw new UnsupportedOperationException("Un pez no puede volar.");
    }
}

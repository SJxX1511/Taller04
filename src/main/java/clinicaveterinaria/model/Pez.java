package clinicaveterinaria.model;

import clinicaveterinaria.interfaces.Inadar;

public class Pez extends Animal implements Inadar {

    public Pez(int id, String nombre) {
        super(id, nombre, TipoAnimal.PEZ);
    }

    @Override
    public void nadar() {
        System.out.println(getNombre() + " está nadando.");
    }
}

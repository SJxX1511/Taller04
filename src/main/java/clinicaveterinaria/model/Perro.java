package clinicaveterinaria.model;

import clinicaveterinaria.interfaces.Icaminar;
import clinicaveterinaria.interfaces.Inadar;

public class Perro extends Animal implements Icaminar, Inadar {

    public Perro(int id, String nombre) {
        super(id, nombre, TipoAnimal.PERRO);
    }

    @Override
    public void caminar() {
        System.out.println(getNombre() + " está caminando.");
    }

    @Override
    public void nadar() {
        System.out.println(getNombre() + " está nadando.");
    }
}

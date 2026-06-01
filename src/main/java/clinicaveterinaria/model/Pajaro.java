package clinicaveterinaria.model;

import clinicaveterinaria.interfaces.Icaminar;
import clinicaveterinaria.interfaces.Ivolar;

public class Pajaro extends Animal implements Icaminar, Ivolar {

    public Pajaro(int id, String nombre) {
        super(id, nombre, TipoAnimal.PAJARO);
    }

    @Override
    public void volar() {
        System.out.println(getNombre() + " está volando.");
    }

    @Override
    public void caminar() {
        System.out.println(getNombre() + " está caminando.");
    }
}

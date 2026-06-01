package clinicaveterinaria.model;


import clinicaveterinaria.interfaces.Icaminar;

public class Gato extends Animal implements Icaminar {

    public Gato(int id, String nombre) {
        super(id, nombre, TipoAnimal.GATO);
    }

    @Override
    public void caminar() {
        System.out.println(getNombre() + " está caminando.");
    }
}

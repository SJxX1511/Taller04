package clinicaveterinaria.model;

import clinicaveterinaria.interfaces.IAnimal;

import java.util.Objects;


public class Animal implements IAnimal {
    private int id;
    private String nombre;
    private TipoAnimal tipo;

    public Animal(int id, String nombre, TipoAnimal tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    @Override
    public void volar() {
        System.out.println(nombre + " esta volando.");
    }

    @Override
    public void nadar() {
        System.out.println(nombre + " esta nadando.");
    }

    @Override
    public void caminar() {
        System.out.println(nombre + " esta caminando.");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoAnimal getTipo() {
        return tipo;
    }

    public void setTipo(TipoAnimal tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Animal)) {
            return false;
        }
        Animal animal = (Animal) o;
        return id == animal.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}

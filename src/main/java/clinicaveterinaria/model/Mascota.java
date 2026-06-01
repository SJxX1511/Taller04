package clinicaveterinaria.model;

import java.util.Objects;

public class Mascota {
    private int id;
    private String nombre;
    private TipoAnimal tipo;
    private int edad;
    private String dueno;

    public Mascota(int id, String nombre, TipoAnimal tipo, int edad, String dueno) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.edad = edad;
        this.dueno = dueno;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDueno() {
        return dueno;
    }

    public void setDueno(String dueno) {
        this.dueno = dueno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Mascota)) {
            return false;
        }
        Mascota mascota = (Mascota) o;
        return id == mascota.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo=" + tipo +
                ", edad=" + edad +
                ", dueno='" + dueno + '\'' +
                '}';
    }
}

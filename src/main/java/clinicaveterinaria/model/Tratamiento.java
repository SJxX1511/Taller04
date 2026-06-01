package clinicaveterinaria.model;

import java.util.Objects;


public class Tratamiento {
    private int id;
    private TipoTratamiento tipo;
    private String descripcion;
    private double costo;

    public Tratamiento(int id, TipoTratamiento tipo, String descripcion, double costo) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public double calcularCostoFinal() {
        if (tipo == TipoTratamiento.VACUNA) {
            return costo + 5.0;
        } else if (tipo == TipoTratamiento.CIRUGIA) {
            return costo * 1.25 + 80.0;
        } else if (tipo == TipoTratamiento.MEDICAMENTO) {
            return costo * 1.10;
        } else if (tipo == TipoTratamiento.FISIOTERAPIA) {
            return costo * 0.95;
        }
        return costo;
    }

    public String obtenerIndicaciones() {
        if (tipo == TipoTratamiento.VACUNA) {
            return "Observar fiebre durante 24 horas.";
        } else if (tipo == TipoTratamiento.CIRUGIA) {
            return "Ayuno previo y control postoperatorio.";
        } else if (tipo == TipoTratamiento.MEDICAMENTO) {
            return "Administrar segun receta.";
        } else if (tipo == TipoTratamiento.FISIOTERAPIA) {
            return "Repetir sesiones dos veces por semana.";
        }
        return "Sin indicaciones.";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoTratamiento getTipo() {
        return tipo;
    }

    public void setTipo(TipoTratamiento tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Tratamiento)) {
            return false;
        }
        Tratamiento that = (Tratamiento) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Tratamiento{" +
                "id=" + id +
                ", tipo=" + tipo +
                ", descripcion='" + descripcion + '\'' +
                ", costo=" + costo +
                '}';
    }
}

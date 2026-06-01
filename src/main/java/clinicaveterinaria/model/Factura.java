package clinicaveterinaria.model;

import java.time.LocalDate;
import java.util.Objects;

public class Factura {
    private int id;
    private Cita cita;
    private double monto;
    private LocalDate fecha;
    private boolean pagada;

    public Factura(int id, Cita cita, double monto, LocalDate fecha, boolean pagada) {
        this.id = id;
        this.cita = cita;
        this.monto = monto;
        this.fecha = fecha;
        this.pagada = pagada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public boolean isPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Factura)) {
            return false;
        }
        Factura factura = (Factura) o;
        return id == factura.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", cita=" + cita.getId() +
                ", monto=" + monto +
                ", fecha=" + fecha +
                ", pagada=" + pagada +
                '}';
    }
}

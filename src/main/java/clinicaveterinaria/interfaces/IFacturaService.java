package clinicaveterinaria.interfaces;
import clinicaveterinaria.model.Factura;
public interface IFacturaService {
 void crearFactura(Factura factura);

    void pagarFactura(int id);
}
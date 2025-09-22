package gimnasio.model;

import java.util.Date;

public class Pago {
    private Socio socio;
    private double monto;
    private String metodo;
    private Date fecha;

    public Pago(Socio socio, double monto, String metodo) {
        this.socio = socio;
        this.monto = monto;
        this.metodo = metodo;
        this.fecha = new Date();
    }

    @Override
    public String toString() {
        return "Pago de $" + monto + " por " + socio.getNombre() + " el " + fecha;
    }
}

package gimnasio.model;

import java.util.ArrayList;

public class Socio extends Persona {
    private Plan plan;
    private ArrayList<Pago> pagos;

    public Socio(String nombre, String dni, String telefono, Plan plan) {
        super(nombre, dni, telefono);
        this.plan = plan;
        this.pagos = new ArrayList<>();
    }

    public Plan getPlan() { return plan; }

    public void pagarCuota(double monto) {
        pagos.add(new Pago(this, monto, "Efectivo"));
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Socio: " + getNombre() + " - Plan: " + plan);
    }
}

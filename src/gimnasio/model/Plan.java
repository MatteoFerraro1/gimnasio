package gimnasio.model;

public class Plan {
    private String nombre;
    private double precio;

    public Plan(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }

    public double calcularCostoAnual() {
        return precio * 12;
    }

    @Override
    public String toString() {
        return nombre + " ($" + precio + ")";
    }
}

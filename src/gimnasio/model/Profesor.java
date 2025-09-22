package gimnasio.model;

public class Profesor extends Persona {
    private String especialidad;

    public Profesor(String nombre, String dni, String telefono, String especialidad) {
        super(nombre, dni, telefono);
        this.especialidad = especialidad;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Profesor: " + getNombre() + " - Especialidad: " + especialidad);
    }
}

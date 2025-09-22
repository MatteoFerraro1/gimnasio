package gimnasio.model;

import java.util.ArrayList;

public class Clase {
    private String nombre;
    private Profesor profesor;
    private int cupoMaximo;
    private ArrayList<Socio> inscriptos;

    public Clase(String nombre, Profesor profesor, int cupoMaximo) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.cupoMaximo = cupoMaximo;
        this.inscriptos = new ArrayList<>();
    }

    public void inscribirSocio(Socio socio) {
        if (inscriptos.size() < cupoMaximo) {
            inscriptos.add(socio);
            System.out.println("Socio inscripto en " + nombre);
        } else {
            System.out.println("No hay cupo disponible en " + nombre);
        }
    }

    public void mostrarInscriptos() {
        System.out.println("Clase: " + nombre + " - Profesor: " + profesor.getNombre());
        for (Socio s : inscriptos) {
            System.out.println("  - " + s.getNombre());
        }
    }

    @Override
    public String toString() {
        return nombre + " (Prof: " + profesor.getNombre() + ")";
    }
}

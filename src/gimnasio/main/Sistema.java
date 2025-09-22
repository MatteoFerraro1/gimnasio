package gimnasio.main;

import gimnasio.model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

    private static ArrayList<Socio> socios = new ArrayList<>();
    private static ArrayList<Profesor> profesores = new ArrayList<>();
    private static ArrayList<Clase> clases = new ArrayList<>();
    private static ArrayList<Plan> planes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Planes
        planes.add(new Plan("Básico", 5000));
        planes.add(new Plan("Premium", 8000));

        int opcion;
        do {
            System.out.println("\n=== MENÚ GIMNASIO ===");
            System.out.println("1. Registrar Socio");
            System.out.println("2. Registrar Profesor");
            System.out.println("3. Crear Clase");
            System.out.println("4. Inscribir Socio en Clase");
            System.out.println("5. Mostrar Clases");
            System.out.println("6. Listar Socios");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> registrarSocio(sc);
                case 2 -> registrarProfesor(sc);
                case 3 -> crearClase(sc);
                case 4 -> inscribirSocioClase(sc);
                case 5 -> mostrarClases();
                case 6 -> listarSocios();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }

    private static void registrarSocio(Scanner sc) {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("DNI: ");
        String dni = sc.nextLine();
        System.out.print("Teléfono: ");
        String tel = sc.nextLine();

        System.out.println("Planes disponibles:");
        for (int i = 0; i < planes.size(); i++) {
            System.out.println(i + ". " + planes.get(i));
        }
        System.out.print("Seleccione plan: ");
        int planIndex = sc.nextInt();
        sc.nextLine();

        Socio socio = new Socio(nombre, dni, tel, planes.get(planIndex));
        socios.add(socio);
        System.out.println("Socio registrado.");
    }

    private static void registrarProfesor(Scanner sc) {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("DNI: ");
        String dni = sc.nextLine();
        System.out.print("Teléfono: ");
        String tel = sc.nextLine();
        System.out.print("Especialidad: ");
        String esp = sc.nextLine();

        Profesor prof = new Profesor(nombre, dni, tel, esp);
        profesores.add(prof);
        System.out.println("Profesor registrado.");
    }

    private static void crearClase(Scanner sc) {
        if (profesores.isEmpty()) {
            System.out.println("No hay profesores registrados.");
            return;
        }

        System.out.print("Nombre de la clase: ");
        String nombre = sc.nextLine();

        System.out.println("Profesores disponibles:");
        for (int i = 0; i < profesores.size(); i++) {
            System.out.println(i + ". " + profesores.get(i).getNombre());
        }
        System.out.print("Seleccione profesor: ");
        int profIndex = sc.nextInt();
        sc.nextLine();

        System.out.print("Cupo máximo: ");
        int cupo = sc.nextInt();
        sc.nextLine();

        Clase clase = new Clase(nombre, profesores.get(profIndex), cupo);
        clases.add(clase);
        System.out.println("Clase creada.");
    }

    private static void inscribirSocioClase(Scanner sc) {
        if (socios.isEmpty() || clases.isEmpty()) {
            System.out.println("Debe haber socios y clases cargadas.");
            return;
        }

        System.out.println("Socios:");
        for (int i = 0; i < socios.size(); i++) {
            System.out.println(i + ". " + socios.get(i).getNombre());
        }
        System.out.print("Seleccione socio: ");
        int socioIndex = sc.nextInt();
        sc.nextLine();

        System.out.println("Clases:");
        for (int i = 0; i < clases.size(); i++) {
            System.out.println(i + ". " + clases.get(i));
        }
        System.out.print("Seleccione clase: ");
        int claseIndex = sc.nextInt();
        sc.nextLine();

        clases.get(claseIndex).inscribirSocio(socios.get(socioIndex));
    }

    private static void mostrarClases() {
        if (clases.isEmpty()) {
            System.out.println("No hay clases creadas.");
            return;
        }
        for (Clase c : clases) {
            c.mostrarInscriptos();
        }
    }

    private static void listarSocios() {
        if (socios.isEmpty()) {
            System.out.println("No hay socios registrados.");
            return;
        }
        for (Socio s : socios) {
            s.mostrarDatos();
        }
    }
}

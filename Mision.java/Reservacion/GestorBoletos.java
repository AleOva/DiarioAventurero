import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Clase que representa una reservación
class Reservacion {
    String nombre; // Nombre del cliente
    int asiento;   // Número de asiento reservado
    String funcion; // Función a la que se registra

    public Reservacion(String nombre, int asiento, String funcion) {
        this.nombre = nombre; // Inicializa el nombre
        this.asiento = asiento; // Inicializa el asiento
        this.funcion = funcion; // Inicializa la función
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre + ", Asiento: " + asiento + ", Funcion: " + funcion; // Representación de la reservación
    }
}

// Clase que gestiona las reservaciones de boletos
public class GestorBoletos {
    private Queue<Reservacion> reservaciones; // Cola para gestionar las reservaciones
    private boolean[] asientos; // Array para verificar la ocupación de asientos
    private String[] funciones = {"Star Wars", "Jurassic World", "Black Phone"};

    public GestorBoletos(int totalAsientos) {
        this.reservaciones = new LinkedList<>(); // Inicializa la cola de reservaciones
        this.asientos = new boolean[totalAsientos]; // Inicializa todos los asientos como desocupados
    }

    // Método para registrar una nueva reservación
    public String registrarReservacion(String nombre, int asiento, String funcion) {
        if (asiento < 0 || asiento >= asientos.length) {
            return "Asiento no valido.";
        }
        if (asientos[asiento]) {
            return "El asiento " + asiento + " ya esta ocupado.";
        }
        Reservacion nuevaReservacion = new Reservacion(nombre, asiento, funcion);
        reservaciones.add(nuevaReservacion); // Agrega la reservación a la cola
        asientos[asiento] = true; // Marca el asiento como ocupado
        return "Reservacion exitosa para " + nombre + " en el asiento " + asiento + " para la funcion " + funcion + ".";
    }

    // Método para eliminar una reservación
    public String eliminarReservacion(String nombre) {
        for (Reservacion reservacion : reservaciones) {
            if (reservacion.nombre.equals(nombre)) {
                reservaciones.remove(reservacion); // Elimina la reservación de la cola
                asientos[reservacion.asiento] = false; // Marca el asiento como desocupado
                return "Reservacion de " + nombre + " cancelada.";
            }
        }
        return "No se encontró la reservacion para " + nombre + ".";
    }

    // Método para verificar si un asiento está ocupado
    public boolean verificarOcupacion(int asiento) {
        return asiento >= 0 && asiento < asientos.length && asientos[asiento];
    }

    // Método para mostrar todas las reservaciones
    public void mostrarReservaciones() {
        System.out.println("Reservaciones en orden de llegada:");
        for (Reservacion reservacion : reservaciones) {
            System.out.println(reservacion); // Muestra cada reservación
        }
    }

    // Método para asignar automáticamente el mejor asiento disponible
    public String asignarMejorAsiento(String nombre, String funcion) {
        for (int i = 0; i < asientos.length; i++) {
            if (!asientos[i]) {
                return registrarReservacion(nombre, i, funcion); // Asigna el primer asiento disponible
            }
        }
        return "No hay asientos disponibles.";
    }

    // Clase principal para probar el sistema
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su nombre para reservar: ");
        String nombre = scanner.nextLine();

        GestorBoletos gestor = new GestorBoletos(10); // Crea el gestor con 10 asientos

        while (true) {
            System.out.println("\nSeleccione una funcion:");
            System.out.println("1. Star Wars");
            System.out.println("2. Jurassic World");
            System.out.println("3. Black Phone");
            System.out.println("4. Salir");
            System.out.print("Opcion: ");
            int opcionFuncion = scanner.nextInt();

            if (opcionFuncion == 4) {
                System.out.println("Saliendo del sistema. ¡Gracias!");
                break;
            }

            String funcionSeleccionada = "";
            if (opcionFuncion == 1) {
                funcionSeleccionada = gestor.funciones[0];
            } else if (opcionFuncion == 2) {
                funcionSeleccionada = gestor.funciones[1];
            } else if (opcionFuncion == 3) {
                funcionSeleccionada = gestor.funciones[2];
            } else {
                System.out.println("Opcion no valida. Por favor, intente de nuevo.");
                continue;
            }

            while (true) {
                System.out.println("\nSeleccione una opcion:");
                System.out.println("1. Registrar Reservacion");
                System.out.println("2. Cancelar Reservacion");
                System.out.println("3. Verificar Ocupacion de Asiento");
                System.out.println("4. Mostrar Reservaciones");
                System.out.println("5. Volver a seleccionar funcion");
                System.out.print("Opcion: ");
                int opcion = scanner.nextInt();

                if (opcion == 5) {
                    break; // Sale del bucle interno para seleccionar una función
                }

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el numero de asiento a reservar: ");
                        int asiento = scanner.nextInt();
                        System.out.println(gestor.registrarReservacion(nombre, asiento, funcionSeleccionada));
                        break;
                    case 2:
                        System.out.println(gestor.eliminarReservacion(nombre));
                        break;
                    case 3:
                        System.out.print("Ingrese el numero de asiento a verificar: ");
                        int asientoVerificar = scanner.nextInt();
                        boolean ocupado = gestor.verificarOcupacion(asientoVerificar);
                        System.out.println("El asiento " + asientoVerificar + (ocupado ? " esta ocupado." : " esta disponible."));
                        break;
                    case 4:
                        gestor.mostrarReservaciones();
                        break;
                    default:
                        System.out.println("Opcion no valida. Intente de nuevo.");
                }
            }
        }
        scanner.close();
    }
}


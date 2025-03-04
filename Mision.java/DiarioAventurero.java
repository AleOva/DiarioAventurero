import java.util.LinkedList;
import java.util.Scanner;

// Clase principal que implementa el TDA DiarioAventurero
public class DiarioAventurero {
    // Clase que representa una misión
    static class Mision {
        String nombre; // Nombre de la misión
        boolean exitosa; // Estado de la misión (exitosa o fallida)

        // Constructor de la misión
        public Mision(String nombre, boolean exitosa) {
            this.nombre = nombre;
            this.exitosa = exitosa;
        }

        // Método para representar la misión como un String
        @Override
        public String toString() {
            return "Mision: " + nombre + ", Exitosa: " + (exitosa ? "Si" : "No");
        }
    }

    // Lista enlazada para almacenar las misiones
    private LinkedList<Mision> misiones;

    // Constructor del DiarioAventurero
    public DiarioAventurero() {
        misiones = new LinkedList<>();
    }

    // Método para registrar una nueva misión
    public void registrarMision(String nombre, boolean exitosa) {
        misiones.add(new Mision(nombre, exitosa));
    }

    // Método para eliminar una misión específica
    public void eliminarMision(int index) {
        if (index >= 0 && index < misiones.size()) {
            misiones.remove(index);
            System.out.println("Mision eliminada.");
        } else {
            System.out.println("Indice fuera de rango.");
        }
    }

    // Método para mostrar todas las misiones
    public void mostrarMisiones() {
        for (Mision mision : misiones) {
            System.out.println(mision);
        }
    }

    // Método para buscar si una misión específica fue completada
    public boolean buscarMision(String nombre) {
        for (Mision mision : misiones) {
            if (mision.nombre.equals(nombre)) {
                return true; // Misión encontrada
            }
        }
        return false; // Misión no encontrada
    }

    // Método para editar una misión existente
    public void editarMision(int index, String nuevoNombre, boolean nuevaExitosa) {
        if (index >= 0 && index < misiones.size()) {
            misiones.set(index, new Mision(nuevoNombre, nuevaExitosa));
            System.out.println("Mision editada.");
        } else {
            System.out.println("Indice fuera de rango.");
        }
    }

    // Método principal para probar el TDA
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar el nombre del aventurero
        System.out.print("Introduce el nombre del aventurero: ");
        String nombreAventurero = scanner.nextLine(); // Lee el nombre del aventurero
        System.out.println("Bienvenido, " + nombreAventurero + "!");

        // Solicitar nivel de dificultad
        System.out.println("Elige el nivel de dificultad:");
        System.out.println("1. Fácil");
        System.out.println("2. Medio");
        System.out.println("3. Difícil");
        System.out.print("Elige una opción (1-3): ");
        int nivelDificultad = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        String dificultad; // Variable para almacenar el nivel de dificultad
        if (nivelDificultad == 1) {
            dificultad = "Fácil";
        } else if (nivelDificultad == 2) {
            dificultad = "Medio";
        } else if (nivelDificultad == 3) {
            dificultad = "Difícil";
        } else {
            dificultad = "Desconocido"; // Valor predeterminado si la opción no es válida
        }
        System.out.println("Has seleccionado el nivel de dificultad: " + dificultad);

        DiarioAventurero diario = new DiarioAventurero(); // Crea una nueva instancia de DiarioAventurero
        int opcion;

        // Misiones predefinidas
        String[] misionesDisponibles = {
            "Explorar la Cueva del Eco",
            "Recoger Hierbas Medicinales",
            "Salvar al Pueblo de la Amenaza",
            "Encontrar el Tesoro Perdido",
            "Domar a una Bestia Salvaje",
            "Investigar Ruinas Antiguas",
            "Proteger la Aldea de Bandidos",
            "Navegar por el Rio Peligroso",
            "Desarrollar un Mapa de la Region"
        };

        do {
            // Menú de opciones con las misiones disponibles
            System.out.println("\n--- Menu Principal ---");
            System.out.println("Misiones disponibles:");
            for (int i = 0; i < misionesDisponibles.length; i++) {
                System.out.println((i + 1) + ". " + misionesDisponibles[i]);
            }
            System.out.println("10. Salir");
            System.out.print("Elige el numero de la mision para registrar como hecha o una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            if (opcion >= 1 && opcion <= 9) {
                System.out.print("¿La mision fue exitosa? (true/false): ");
                boolean exitosa = scanner.nextBoolean();
                diario.registrarMision(misionesDisponibles[opcion - 1], exitosa);
                System.out.println("Mision registrada: " + misionesDisponibles[opcion - 1]);
            } else if (opcion == 10) {
                System.out.println("Saliendo...");
            } else {
                System.out.println("Opcion no valida. Intenta de nuevo.");
                continue;
            }

            // Menú adicional para acciones
            System.out.println("\n--- Acciones ---");
            System.out.println("1. Editar mision");
            System.out.println("2. Eliminar mision");
            System.out.println("3. Mostrar todas las misiones");
            System.out.println("4. Buscar mision");
            System.out.print("Elige una opcion: ");
            int accion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (accion) {
                case 1:
                    System.out.println("Misiones registradas:");
                    diario.mostrarMisiones();
                    System.out.print("Indice de la mision a editar (0 para la primera mision): ");
                    int index = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Nuevo nombre de la mision: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("¿La mision es exitosa? (true/false): ");
                    boolean nuevaExitosa = scanner.nextBoolean();
                    diario.editarMision(index, nuevoNombre, nuevaExitosa);
                    break;
                case 2:
                    System.out.println("Misiones registradas:");
                    diario.mostrarMisiones();
                    System.out.print("Indice de la mision a eliminar (0 para la primera mision): ");
                    int eliminarIndex = scanner.nextInt();
                    diario.eliminarMision(eliminarIndex);
                    break;
                case 3:
                    System.out.println("Misiones registradas:");
                    diario.mostrarMisiones();
                    break;
                case 4:
                    System.out.print("Nombre de la mision a buscar: ");
                    String misionBuscada = scanner.nextLine();
                    System.out.println("¿La mision '" + misionBuscada + "' fue completada? " + diario.buscarMision(misionBuscada));
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 10);

        scanner.close(); // Cierra el scanner
    }
}










import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// Clase que representa una canción
class Cancion {
    String titulo; // Titulo de la canción
    String artista; // Artista de la canción
    String genero; // Genero de la canción
    String album; // Album de la canción
    int anio; // Ano de lanzamiento
    int duracion; // Duracion de la canción en segundos

    // Constructor de la canción
    public Cancion(String titulo, String artista, String genero, String album, int anio, int duracion) {
        this.titulo = titulo; // Inicializa el título
        this.artista = artista; // Inicializa el artista
        this.genero = genero; // Inicializa el género
        this.album = album; // Inicializa el álbum
        this.anio = anio; // Inicializa el año
        this.duracion = duracion; // Inicializa la duración
    }

    // Método para mostrar información de la canción
    @Override
    public String toString() {
        return "Cancion: " + titulo + ", Artista: " + artista + ", Genero: " + genero +
               ", Album: " + album + ", Ano: " + anio + ", Duracion: " + duracion + " segundos";
    }
}

// Clase que representa la lista de reproducción
public class Playlist {
    private String nombre; // Nombre de la playlist
    private List<Cancion> canciones; // Lista para almacenar las canciones

    // Constructor de la lista de reproducción
    public Playlist(String nombre) {
        this.nombre = nombre; // Inicializa el nombre de la playlist
        canciones = new ArrayList<>();
    }

    // Método para agregar una nueva canción
    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
        System.out.println("Cancion agregada: " + cancion.titulo);
    }

    // Método para eliminar una canción específica
    public void eliminarCancion(String titulo) {
        canciones.removeIf(cancion -> cancion.titulo.equals(titulo));
        System.out.println("Cancion eliminada: " + titulo);
    }

    // Método para reproducir la siguiente canción en la lista
    public void reproducirSiguiente() {
        if (!canciones.isEmpty()) {
            Cancion siguiente = canciones.remove(0); // Toma la primera canción
            System.out.println("Reproduciendo: " + siguiente);
        } else {
            System.out.println("No hay canciones en la lista.");
        }
    }

    // Método para reproducir canciones en orden aleatorio
    public void reproducirAleatorio() {
        if (!canciones.isEmpty()) {
            Collections.shuffle(canciones); // Mezcla la lista de canciones
            for (Cancion cancion : canciones) {
                System.out.println("Reproduciendo: " + cancion);
            }
            canciones.clear(); // Limpia la lista después de reproducir
        } else {
            System.out.println("No hay canciones en la lista.");
        }
    }

    // Método para ordenar las canciones por duración
    public void ordenarPorDuracion() {
        canciones.sort(Comparator.comparingInt(cancion -> cancion.duracion));
        System.out.println("Canciones ordenadas por duracion.");
    }

    // Método para ordenar las canciones por artista
    public void ordenarPorArtista() {
        canciones.sort(Comparator.comparing(cancion -> cancion.artista));
        System.out.println("Canciones ordenadas por artista.");
    }

    // Método para mostrar todas las canciones en la lista
    public void mostrarCanciones() {
        System.out.println("\nLista de Canciones en " + nombre + ":");
        for (Cancion cancion : canciones) {
            System.out.println(cancion);
        }
    }

    // Método para mostrar la lista de canciones disponibles
    public void mostrarCancionesDisponibles() {
        System.out.println("\nCanciones disponibles para agregar:");
        System.out.println("1. Tu con el - Rauw Alejandro");
        System.out.println("2. Rommies - Reik");
        System.out.println("3. Expresso - Sabrina Carpenter");
        System.out.println("4. Please, please, please - Sabrina Carpenter");
        System.out.println("5. Se fue - Rauw Alejandro");
        System.out.println("6. Compartir - Carla Morrison");
        System.out.println("7. Cielo - Federico Vega");
        System.out.println("8. The adults are talking - The Strokes");
    }

    // Método para iniciar la gestión de playlists
    public static void gestionarPlaylists() {
        Scanner scanner = new Scanner(System.in);
        List<Playlist> playlists = new ArrayList<>();
        
        // Paso 1: Pedir el nombre del usuario
        System.out.print("Introduce tu nombre: ");
        String nombreUsuario = scanner.nextLine();
        System.out.println("Bienvenido, " + nombreUsuario + "!");

        // Paso 2: Nombrar la primera playlist
        System.out.print("Nombra tu primera playlist: ");
        String nombrePlaylist = scanner.nextLine();
        Playlist playlistActual = new Playlist(nombrePlaylist);
        playlists.add(playlistActual);

        int opcion;
        do {
            System.out.println("\n--- Menu de Playlist ---");
            System.out.println("1. Agregar Cancion");
            System.out.println("2. Eliminar Cancion");
            System.out.println("3. Reproducir Siguiente Cancion");
            System.out.println("4. Reproducir en Orden Aleatorio");
            System.out.println("5. Ordenar Canciones por Duracion");
            System.out.println("6. Ordenar Canciones por Artista");
            System.out.println("7. Mostrar Canciones");
            System.out.println("8. Crear Nueva Playlist");
            System.out.println("9. Seleccionar Playlist");
            System.out.println("10. Salir");
            System.out.print("Elige una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    playlistActual.mostrarCancionesDisponibles();
                    System.out.print("Selecciona el numero de la cancion que deseas agregar: ");
                    int seleccion = scanner.nextInt();
                    switch (seleccion) {
                        case 1:
                            playlistActual.agregarCancion(new Cancion("Tú con él", "Rauw Alejandro", "Urbano", "N/A", 2021, 200));
                            break;
                        case 2:
                            playlistActual.agregarCancion(new Cancion("Rommies", "Reik", "Pop", "N/A", 2021, 180));
                            break;
                        case 3:
                            playlistActual.agregarCancion(new Cancion("Expresso", "Sabrina Carpenter", "Pop", "N/A", 2022, 210));
                            break;
                        case 4:
                            playlistActual.agregarCancion(new Cancion("Please, please, please", "Sabrina Carpenter", "Pop", "N/A", 2022, 240));
                            break;
                        case 5:
                            playlistActual.agregarCancion(new Cancion("Se fue", "Rauw Alejandro", "Urbano", "N/A", 2020, 220));
                            break;
                        case 6:
                            playlistActual.agregarCancion(new Cancion("Compartir", "Carla Morrison", "Indie", "N/A", 2020, 200));
                            break;
                        case 7:
                            playlistActual.agregarCancion(new Cancion("Cielo", "Federico Vega", "Pop", "N/A", 2021, 210));
                            break;
                        case 8:
                            playlistActual.agregarCancion(new Cancion("The adults are talking", "The Strokes", "Rock", "N/A", 2020, 240));
                            break;
                        default:
                            System.out.println("Seleccion no valida.");
                    }
                    break;
                case 2:
                    System.out.print("Titulo de la cancion a eliminar: ");
                    String tituloEliminar = scanner.nextLine();
                    playlistActual.eliminarCancion(tituloEliminar);
                    break;
                case 3:
                    playlistActual.reproducirSiguiente();
                    break;
                case 4:
                    playlistActual.reproducirAleatorio();
                    break;
                case 5:
                    playlistActual.ordenarPorDuracion();
                    break;
                case 6:
                    playlistActual.ordenarPorArtista();
                    break;
                case 7:
                    playlistActual.mostrarCanciones();
                    break;
                case 8:
                    System.out.print("Nombra tu nueva playlist: ");
                    String nuevoNombrePlaylist = scanner.nextLine();
                    Playlist nuevaPlaylist = new Playlist(nuevoNombrePlaylist);
                    playlists.add(nuevaPlaylist);
                    playlistActual = nuevaPlaylist; // Cambia a la nueva playlist
                    break;
                case 9:
                    System.out.print("Indice de la playlist a seleccionar (0 - " + (playlists.size() - 1) + "): ");
                    int indice = scanner.nextInt();
                    if (indice >= 0 && indice < playlists.size()) {
                        playlistActual = playlists.get(indice);
                    } else {
                        System.out.println("Indice no valido.");
                    }
                    break;
                case 10:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida. Intenta de nuevo.");
            }
        } while (opcion != 10); // Continúa hasta que el usuario elija salir

        scanner.close(); // Cierra el scanner
    }

    // Método principal para iniciar el programa
    public static void main(String[] args) {
        gestionarPlaylists(); // Inicia la gestión de playlists
    }
}

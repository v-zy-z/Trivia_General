package model;

/**
 *
 * @author leo23
 */
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GestorJugadores {
    private static final String CARPETA_DATOS = "datos_juego";
    private static final String ARCHIVO_JUGADORES = "jugadores.dat";
    private static final String RUTA_COMPLETA = CARPETA_DATOS + File.separator + ARCHIVO_JUGADORES;
    
    public GestorJugadores() {
        crearCarpetaSiNoExiste();
    }
    
    private void crearCarpetaSiNoExiste() {
        try {
            Files.createDirectories(Paths.get(CARPETA_DATOS));
        } catch (IOException e) {
            System.err.println("Error al crear la carpeta de datos: " + e.getMessage());
        }
    }
    
    // Cargar jugadores desde el archivo
    public List<Jugador> cargarJugadores() {
        List<Jugador> jugadores = new ArrayList<>();
        File archivo = new File(RUTA_COMPLETA);
        
        if (!archivo.exists()) {
            return jugadores; // Devolver lista vacía si no existe el archivo
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            jugadores = (List<Jugador>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar jugadores: " + e.getMessage());
        }
        
        return jugadores;
    }
    
    // Guardar jugadores en el archivo
    public boolean guardarJugadores(List<Jugador> jugadores) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA_COMPLETA))) {
            oos.writeObject(jugadores);
            return true;
        } catch (IOException e) {
            System.err.println("Error al guardar jugadores: " + e.getMessage());
            return false;
        }
    }
    
    // Buscar jugador por nombre
    public Jugador buscarJugador(String nombre) {
        List<Jugador> jugadores = cargarJugadores();
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equalsIgnoreCase(nombre)) {
                return jugador;
            }
        }
        return null;
    }
    
    // Agregar o actualizar jugador
    public boolean guardarJugador(Jugador jugador) {
        List<Jugador> jugadores = cargarJugadores();
        
        // Buscar si el jugador ya existe
        boolean encontrado = false;
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getNombre().equalsIgnoreCase(jugador.getNombre())) {
                jugadores.set(i, jugador); // Actualizar jugador existente
                encontrado = true;
                break;
            }
        }
        
        // Si no existe, agregarlo
        if (!encontrado) {
            jugadores.add(jugador);
        }
        
        return guardarJugadores(jugadores);
    }
    
    // Obtener el top de jugadores por nivel
    public List<Jugador> getTopJugadores(String nivel, int limite) {
        List<Jugador> jugadores = cargarJugadores();
        
        // Ordenar por record del nivel específico (descendente)
        jugadores.sort((j1, j2) -> {
            int record1 = j1.getRecordPorNivel(nivel);
            int record2 = j2.getRecordPorNivel(nivel);
            return Integer.compare(record2, record1); // Orden descendente
        });
        
        // Limitar la cantidad de resultados
        if (jugadores.size() > limite) {
            jugadores = jugadores.subList(0, limite);
        }
        
        return jugadores;
    }
    
    // Eliminar archivo de datos (para pruebas)
    public boolean eliminarDatos() {
        File archivo = new File(RUTA_COMPLETA);
        if (archivo.exists()) {
            return archivo.delete();
        }
        return false;
    }
    
    // Verificar si existe la carpeta de datos
    public boolean existeCarpetaDatos() {
        return Files.exists(Paths.get(CARPETA_DATOS));
    }
}
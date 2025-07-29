package controller;

import model.*;
import view.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer; 

public class ControladorJuego {
    
    // Modelos
    private BancoPreguntas bancoPreguntas;
    private GestorJugadores gestorJugadores;
    private Jugador jugadorActual;
    
    // Vistas
    private MenuPrincipal menuPrincipal;
    private JuegoTrivia juegoTrivia;
    private ResultadosJuego resultadosJuego;
    
    // Estado del juego
    private List<Pregunta> preguntasActuales;
    private int indicePreguntaActual;
    private String nivelActual;
    private boolean juegoEnCurso;
    
    public ControladorJuego() {
        inicializarModelos();
        juegoEnCurso = false;
    }
    
    private void inicializarModelos() {
        bancoPreguntas = new BancoPreguntas();
        gestorJugadores = new GestorJugadores();
    }
    
    // Método para iniciar un nuevo juego
    public void iniciarJuego(String nivel, String nombreJugador) {
        try {
            // Configurar el jugador
            configurarJugador(nombreJugador);
            
            // Configurar el nivel y preguntas
            this.nivelActual = nivel;
            this.preguntasActuales = bancoPreguntas.obtenerPreguntasPorNivel(nivel);
            this.indicePreguntaActual = 0;
            this.juegoEnCurso = true;
            
            // Reiniciar puntaje del jugador
            jugadorActual.reiniciarPuntajeActual();
            
            // Crear y mostrar la vista del juego
            juegoTrivia = new JuegoTrivia();
            juegoTrivia.configurarJuego(this, nivel, nombreJugador);
            juegoTrivia.setVisible(true);
            
            // REMOVER ESTA LÍNEA - ya se llama en configurarJuego()
            // cargarSiguientePregunta();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                "Error al iniciar el juego: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void configurarJugador(String nombreJugador) {
        // Buscar jugador existente o crear uno nuevo
        jugadorActual = gestorJugadores.buscarJugador(nombreJugador);
        
        if (jugadorActual == null) {
            jugadorActual = new Jugador(nombreJugador);
            System.out.println("Nuevo jugador creado: " + nombreJugador);
        } else {
            System.out.println("Jugador existente encontrado: " + nombreJugador);
        }
    }
    
    // Método para cargar la siguiente pregunta
    public void cargarSiguientePregunta() {
        if (!juegoEnCurso) return;
        
        if (indicePreguntaActual < preguntasActuales.size()) {
            Pregunta pregunta = preguntasActuales.get(indicePreguntaActual);
            juegoTrivia.cargarPregunta(pregunta);
        } else {
            // El juego ha terminado
            terminarJuego(jugadorActual.getPuntajeActual());
        }
    }
    
    // Método para procesar la respuesta del jugador - CORREGIDO
    public void procesarRespuesta(int respuestaSeleccionada) {
        if (!juegoEnCurso || indicePreguntaActual >= preguntasActuales.size()) {
            return;
        }
        
        Pregunta preguntaActual = preguntasActuales.get(indicePreguntaActual);
        
        // Verificar si la respuesta es correcta
        if (preguntaActual.esRespuestaCorrecta(respuestaSeleccionada)) {
            jugadorActual.incrementarPuntaje();
            mostrarFeedback("¡Correcto! 🎉", true);
        } else {
            String respuestaCorrecta = preguntaActual.getOpciones()[preguntaActual.getRespuestaCorrecta()];
            mostrarFeedback("Incorrecto ❌\nRespuesta correcta: " + respuestaCorrecta, false);
        }
        
        // Actualizar la vista con el nuevo puntaje
        juegoTrivia.actualizarPuntaje(jugadorActual.getPuntajeActual());
        
        // Avanzar a la siguiente pregunta
        indicePreguntaActual++;
        juegoTrivia.avanzarPregunta();
        
        // USAR TIMER EN LUGAR DE Thread.sleep()
        Timer timer = new Timer(500, e -> {
            cargarSiguientePregunta();
        });
        timer.setRepeats(false); // Solo ejecutar una vez
        timer.start();
    }
    
    private void mostrarFeedback(String mensaje, boolean esCorrecto) {
        // Mostrar feedback temporal
        JOptionPane.showMessageDialog(
            juegoTrivia, 
            mensaje, 
            esCorrecto ? "¡Correcto!" : "Incorrecto", 
            esCorrecto ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.WARNING_MESSAGE
        );
    }
    
    // Método para terminar el juego
    public void terminarJuego(int puntajeFinal) {
        juegoEnCurso = false;
        
        // Obtener el record anterior
        int recordAnterior = jugadorActual.getRecordPorNivel(nivelActual);
        
        // Actualizar record si es necesario
        jugadorActual.actualizarRecord(nivelActual, puntajeFinal);
        
        // Guardar el jugador actualizado
        boolean guardadoExitoso = gestorJugadores.guardarJugador(jugadorActual);
        
        if (!guardadoExitoso) {
            JOptionPane.showMessageDialog(null, 
                "No se pudo guardar el puntaje", 
                "Error de guardado", 
                JOptionPane.WARNING_MESSAGE);
        }
        
        // Determinar si es un nuevo record
        boolean esNuevoRecord = puntajeFinal > recordAnterior;
        
        // CERRAR LA VENTANA DEL JUEGO ANTES DE MOSTRAR RESULTADOS
        if (juegoTrivia != null) {
            juegoTrivia.dispose();
        }
        
        // Mostrar pantalla de resultados
        mostrarResultados(puntajeFinal, recordAnterior, esNuevoRecord);
    }
    
    private void mostrarResultados(int puntajeFinal, int recordAnterior, boolean esNuevoRecord) {
        SwingUtilities.invokeLater(() -> {
            resultadosJuego = new ResultadosJuego();
            resultadosJuego.configurarResultados(
                this, 
                jugadorActual.getNombre(), 
                nivelActual, 
                puntajeFinal, 
                recordAnterior, 
                esNuevoRecord
            );
            resultadosJuego.setVisible(true);
        });
    }
    
    // Método para volver al menú principal
    public void volverAlMenu() {
        SwingUtilities.invokeLater(() -> {
            menuPrincipal = new MenuPrincipal();
            menuPrincipal.setVisible(true);
        });
    }
    
    // Método para manejar la salida del juego a medias
    public void abandonarJuego() {
        int respuesta = JOptionPane.showConfirmDialog(
            juegoTrivia,
            "¿Estás seguro de que quieres abandonar el juego?\nSe perderá tu progreso actual.",
            "Confirmar abandono",
            JOptionPane.YES_NO_OPTION
        );
        
        if (respuesta == JOptionPane.YES_OPTION) {
            juegoEnCurso = false;
            volverAlMenu();
        }
    }
    
    // Métodos de utilidad para obtener estadísticas
    public String obtenerEstadisticasJugador(String nombreJugador) {
        Jugador jugador = gestorJugadores.buscarJugador(nombreJugador);
        
        if (jugador == null) {
            return "Jugador no encontrado";
        }
        
        StringBuilder stats = new StringBuilder();
        stats.append("Estadísticas de ").append(jugador.getNombre()).append(":\n");
        stats.append("Récord Fácil: ").append(jugador.getRecordFacil()).append("/60\n");
        stats.append("Récord Intermedio: ").append(jugador.getRecordIntermedio()).append("/60\n");
        stats.append("Récord Difícil: ").append(jugador.getRecordDificil()).append("/60\n");
        
        return stats.toString();
    }
    
    public List<Jugador> obtenerTopJugadores(String nivel) {
        return gestorJugadores.getTopJugadores(nivel, 10);
    }
    
    // Getters para acceso a los modelos (si es necesario)
    public Jugador getJugadorActual() {
        return jugadorActual;
    }
    
    public boolean isJuegoEnCurso() {
        return juegoEnCurso;
    }
    
    public String getNivelActual() {
        return nivelActual;
    }
    
    public int getPreguntaActual() {
        return indicePreguntaActual + 1; // +1 porque el índice empieza en 0
    }
    
    public int getTotalPreguntas() {
        return preguntasActuales != null ? preguntasActuales.size() : 0;
    }
}
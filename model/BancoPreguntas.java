package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BancoPreguntas {
    private List<Pregunta> preguntasFaciles;
    private List<Pregunta> preguntasIntermedias;
    private List<Pregunta> preguntasDificiles;

    public BancoPreguntas() {
        preguntasFaciles = new ArrayList<>();
        preguntasIntermedias = new ArrayList<>();
        preguntasDificiles = new ArrayList<>();
        cargarPreguntasDesdeCSV("datos_juego/preguntas_completo.csv");
    }

    private void cargarPreguntasDesdeCSV(String rutaCSV) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaCSV))) {
            String linea = br.readLine(); // Saltar encabezado
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1); // Divide evitando comas entre comillas
                if (partes.length < 6) continue;

                String nivel = partes[0].trim();
                String preguntaTexto = partes[1].replace("'", "").trim();
                String[] opciones = {partes[2].trim(), partes[3].trim(), partes[4].trim()};
                String respuestaCorrecta = partes[5].trim();

                // Buscar el índice de la respuesta correcta
                int indiceCorrecto = -1;
                for (int i = 0; i < opciones.length; i++) {
                    if (opciones[i].equalsIgnoreCase(respuestaCorrecta)) {
                        indiceCorrecto = i;
                        break;
                    }
                }

                // Validar que haya encontrado el índice
                if (indiceCorrecto == -1) continue;

                Pregunta pregunta = new Pregunta(preguntaTexto, opciones, indiceCorrecto, nivel);
                switch (nivel.toUpperCase()) {
                    case "FACIL":
                        preguntasFaciles.add(pregunta);
                        break;
                    case "INTERMEDIO":
                        preguntasIntermedias.add(pregunta);
                        break;
                    case "DIFICIL":
                        preguntasDificiles.add(pregunta);
                        break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error leyendo CSV: " + e.getMessage());
        }
    }

    public List<Pregunta> obtenerPreguntasPorNivel(String nivel) {
        List<Pregunta> base;
        switch (nivel.toUpperCase()) {
            case "FACIL":
                base = preguntasFaciles;
                break;
            case "INTERMEDIO":
                base = preguntasIntermedias;
                break;
            case "DIFICIL":
                base = preguntasDificiles;
                break;
            default:
                return new ArrayList<>();
        }

        List<Pregunta> seleccionadas = new ArrayList<>();
        while (seleccionadas.size() < 100) {
            seleccionadas.addAll(base);
        }
//        Collections.shuffle(seleccionadas);
        return seleccionadas.subList(0, 100);
    }

    public List<Pregunta> getPreguntasFaciles() {
        return preguntasFaciles;
    }

    public List<Pregunta> getPreguntasIntermedias() {
        return preguntasIntermedias;
    }

    public List<Pregunta> getPreguntasDificiles() {
        return preguntasDificiles;
    }
}

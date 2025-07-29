package model;

/**
 *
 * @author
 */
public class Pregunta {
    private String textoPregunta;
    private String[] opciones;
    private int respuestaCorrecta; // índice de la respuesta correcta (0-3)
    private String nivelDificultad;
    
    public Pregunta(String textoPregunta, String[] opciones, int respuestaCorrecta, String nivelDificultad) {
        this.textoPregunta = textoPregunta;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
        this.nivelDificultad = nivelDificultad;
    }
    
    // Getters y Setters
    public String getTextoPregunta() {
        return textoPregunta;
    }
    
    public void setTextoPregunta(String textoPregunta) {
        this.textoPregunta = textoPregunta;
    }
    
    public String[] getOpciones() {
        return opciones;
    }
    
    public void setOpciones(String[] opciones) {
        this.opciones = opciones;
    }
    
    public int getRespuestaCorrecta() {
        return respuestaCorrecta;
    }
    
    public void setRespuestaCorrecta(int respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }
    
    public String getNivelDificultad() {
        return nivelDificultad;
    }
    
    public void setNivelDificultad(String nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
    }
    
    // Método para verificar si una respuesta es correcta
    public boolean esRespuestaCorrecta(int indiceRespuesta) {
        return indiceRespuesta == respuestaCorrecta;
    }
}
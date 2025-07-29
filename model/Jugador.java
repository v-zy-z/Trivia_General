/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author leo23
 */
import java.io.Serializable;

public class Jugador implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String nombre;
    private int puntajeActual;
    private int recordFacil;
    private int recordIntermedio;
    private int recordDificil;
    
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntajeActual = 0;
        this.recordFacil = 0;
        this.recordIntermedio = 0;
        this.recordDificil = 0;
    }
    
    // Constructor completo
    public Jugador(String nombre, int puntajeActual, int recordFacil, 
                   int recordIntermedio, int recordDificil) {
        this.nombre = nombre;
        this.puntajeActual = puntajeActual;
        this.recordFacil = recordFacil;
        this.recordIntermedio = recordIntermedio;
        this.recordDificil = recordDificil;
    }
    
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getPuntajeActual() {
        return puntajeActual;
    }
    
    public void setPuntajeActual(int puntajeActual) {
        this.puntajeActual = puntajeActual;
    }
    
    public int getRecordFacil() {
        return recordFacil;
    }
    
    public void setRecordFacil(int recordFacil) {
        this.recordFacil = recordFacil;
    }
    
    public int getRecordIntermedio() {
        return recordIntermedio;
    }
    
    public void setRecordIntermedio(int recordIntermedio) {
        this.recordIntermedio = recordIntermedio;
    }
    
    public int getRecordDificil() {
        return recordDificil;
    }
    
    public void setRecordDificil(int recordDificil) {
        this.recordDificil = recordDificil;
    }
    
    // Métodos utilitarios
    public void incrementarPuntaje() {
        this.puntajeActual++;
    }
    
    public void reiniciarPuntajeActual() {
        this.puntajeActual = 0;
    }
    
    public void actualizarRecord(String nivel, int nuevoPuntaje) {
        switch (nivel.toUpperCase()) {
            case "FACIL":
                if (nuevoPuntaje > recordFacil) {
                    recordFacil = nuevoPuntaje;
                }
                break;
            case "INTERMEDIO":
                if (nuevoPuntaje > recordIntermedio) {
                    recordIntermedio = nuevoPuntaje;
                }
                break;
            case "DIFICIL":
                if (nuevoPuntaje > recordDificil) {
                    recordDificil = nuevoPuntaje;
                }
                break;
        }
    }
    
    public int getRecordPorNivel(String nivel) {
        switch (nivel.toUpperCase()) {
            case "FACIL":
                return recordFacil;
            case "INTERMEDIO":
                return recordIntermedio;
            case "DIFICIL":
                return recordDificil;
            default:
                return 0;
        }
    }
    
    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", puntajeActual=" + puntajeActual +
                ", recordFacil=" + recordFacil +
                ", recordIntermedio=" + recordIntermedio +
                ", recordDificil=" + recordDificil +
                '}';
    }
}
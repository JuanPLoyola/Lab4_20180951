package com.example.lab4;

public class Posicion {
    private String nombreEquipo;
    private int posicion;
    private int puntos;

    public Posicion(String nombreEquipo, int posicion, int puntos) {
        this.nombreEquipo = nombreEquipo;
        this.posicion = posicion;
        this.puntos = puntos;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}


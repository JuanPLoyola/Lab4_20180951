package com.example.lab4;

import com.google.gson.annotations.SerializedName;

import java.util.List;

// Clase para representar cada encuentro
public class Encuentro {
    @SerializedName("strEvent")
    private String nombreEvento;
    @SerializedName("strLeague")
    private String nombreLiga;
    @SerializedName("strHomeTeam")
    private String equipoLocal;
    @SerializedName("strAwayTeam")
    private String equipoVisitante;
    @SerializedName("intHomeScore")
    private String marcadorLocal;
    @SerializedName("intAwayScore")
    private String marcadorVisitante;
    @SerializedName("dateEvent")
    private String fechaEvento;
    @SerializedName("intSpectators")
    private String espectadores;
    @SerializedName("strThumb")
    private String logoLiga;

    // Getters y Setters
    public String getNombreEvento() { return nombreEvento; }
    public void setNombreEvento(String nombreEvento) { this.nombreEvento = nombreEvento; }

    public String getNombreLiga() { return nombreLiga; }
    public void setNombreLiga(String nombreLiga) { this.nombreLiga = nombreLiga; }

    public String getEquipoLocal() { return equipoLocal; }
    public void setEquipoLocal(String equipoLocal) { this.equipoLocal = equipoLocal; }

    public String getEquipoVisitante() { return equipoVisitante; }
    public void setEquipoVisitante(String equipoVisitante) { this.equipoVisitante = equipoVisitante; }

    public String getMarcadorLocal() { return marcadorLocal; }
    public void setMarcadorLocal(String marcadorLocal) { this.marcadorLocal = marcadorLocal; }

    public String getMarcadorVisitante() { return marcadorVisitante; }
    public void setMarcadorVisitante(String marcadorVisitante) { this.marcadorVisitante = marcadorVisitante; }

    public String getFechaEvento() { return fechaEvento; }
    public void setFechaEvento(String fechaEvento) { this.fechaEvento = fechaEvento; }

    public String getEspectadores() { return espectadores; }
    public void setEspectadores(String espectadores) { this.espectadores = espectadores; }

    public String getLogoLiga() { return logoLiga; }
    public void setLogoLiga(String logoLiga) { this.logoLiga = logoLiga; }
}


package com.example.lab4;

import com.google.gson.annotations.SerializedName;

import java.util.List;

// Clase para representar cada equipo en la tabla de posiciones
public class EquipoPosicion {
    @SerializedName("idTeam")
    private String idTeam;
    @SerializedName("strTeam")
    private String nombreEquipo;
    @SerializedName("intRank")
    private int ranking;
    @SerializedName("strTeamBadge")
    private String badgeUrl;  // URL del badge (logo del equipo)
    @SerializedName("intWin")
    private int victorias;
    @SerializedName("intDraw")
    private int empates;
    @SerializedName("intLoss")
    private int derrotas;
    @SerializedName("intGoalsFor")
    private int golesAnotados;
    @SerializedName("intGoalsAgainst")
    private int golesConcedidos;

    // Getters y Setters
    public String getIdTeam() { return idTeam; }
    public void setIdTeam(String idTeam) { this.idTeam = idTeam; }

    public String getNombreEquipo() { return nombreEquipo; }
    public void setNombreEquipo(String nombreEquipo) { this.nombreEquipo = nombreEquipo; }

    public int getRanking() { return ranking; }
    public void setRanking(int ranking) { this.ranking = ranking; }

    public String getBadgeUrl() { return badgeUrl; }
    public void setBadgeUrl(String badgeUrl) { this.badgeUrl = badgeUrl; }

    public int getVictorias() { return victorias; }
    public void setVictorias(int victorias) { this.victorias = victorias; }

    public int getEmpates() { return empates; }
    public void setEmpates(int empates) { this.empates = empates; }

    public int getDerrotas() { return derrotas; }
    public void setDerrotas(int derrotas) { this.derrotas = derrotas; }

    public int getGolesAnotados() { return golesAnotados; }
    public void setGolesAnotados(int golesAnotados) { this.golesAnotados = golesAnotados; }

    public int getGolesConcedidos() { return golesConcedidos; }
    public void setGolesConcedidos(int golesConcedidos) { this.golesConcedidos = golesConcedidos; }
}



package com.example.lab4;

import com.google.gson.annotations.SerializedName;

public class Liga {
    @SerializedName("idLeague")
    private String idLeague;
    @SerializedName("strLeague")
    private String nombre;
    @SerializedName("strSport")
    private String deporte;
    @SerializedName("strLeagueAlternate")
    private String nombreAlternativo;

    // Getters y Setters
    public String getIdLeague() { return idLeague; }
    public void setIdLeague(String idLeague) { this.idLeague = idLeague; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDeporte() { return deporte; }
    public void setDeporte(String deporte) { this.deporte = deporte; }

    public String getNombreAlternativo() { return nombreAlternativo; }
    public void setNombreAlternativo(String nombreAlternativo) { this.nombreAlternativo = nombreAlternativo; }
}

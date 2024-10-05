package com.example.lab4;

import com.google.gson.annotations.SerializedName;

import java.util.List;

// Clase para mapear la respuesta que contiene la lista de equipos en la tabla de posiciones
public class PosicionesResponse {
    @SerializedName("table")
    private List<EquipoPosicion> posiciones;

    public List<EquipoPosicion> getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(List<EquipoPosicion> posiciones) {
        this.posiciones = posiciones;
    }
}

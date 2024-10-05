package com.example.lab4;

import com.google.gson.annotations.SerializedName;

import java.util.List;

// Clase para mapear la respuesta que contiene la lista de encuentros
public class ResultadosResponse {
    @SerializedName("events")
    private List<Encuentro> encuentros;

    public List<Encuentro> getEncuentros() {
        return encuentros;
    }

    public void setEncuentros(List<Encuentro> encuentros) {
        this.encuentros = encuentros;
    }
}

package com.example.lab4;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LeaguesResponse {
    @SerializedName("leagues")
    private List<Liga> ligas;

    public List<Liga> getLigas() {
        return ligas;
    }
    public void setLigas(List<Liga> ligas) {
        this.ligas = ligas;
    }
}

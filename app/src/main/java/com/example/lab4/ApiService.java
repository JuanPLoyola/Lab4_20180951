package com.example.lab4;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("all_leagues.php")
    Call<LeaguesResponse> getAllLeagues();

    @GET("search_all_leagues.php")
    Call<LeaguesResponse> getLeaguesByCountry(@Query("c") String leagues);


    // Método GET para obtener posiciones de la liga según la temporada
    @GET("lookuptable.php")
    Call<PosicionesResponse> getLeagueTable(
            @Query("l") String idLiga,   // ID de la liga
            @Query("s") String season    // Temporada
    );
    @GET("eventsround.php")
    Call<ResultadosResponse> getResultados(
            @Query("id") String idLiga,   // ID de la liga
            @Query("r") String ronda,     // Número de la ronda
            @Query("s") String temporada  // Temporada
    );

}

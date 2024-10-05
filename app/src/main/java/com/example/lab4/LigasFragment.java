package com.example.lab4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LigasFragment extends Fragment {

    private RecyclerView recyclerView;
    private LigasAdapter ligasAdapter;
    private EditText etCountry;
    private Button btnBuscar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ligas, container, false);

        recyclerView = view.findViewById(R.id.rvLigas);
        etCountry = view.findViewById(R.id.etCountry);
        btnBuscar = view.findViewById(R.id.btnBuscar);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ligasAdapter = new LigasAdapter(new ArrayList<>());
        recyclerView.setAdapter(ligasAdapter);

        // Cargar ligas al inicio
        getAllLeagues();

        // Buscar ligas por país
        btnBuscar.setOnClickListener(v -> {
            String country = etCountry.getText().toString().trim();
            if (!country.isEmpty()) {
                getLeaguesByCountry(country);
            } else {
                Toast.makeText(getContext(), "Ingrese un país", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void getAllLeagues() {
        ApiService apiService = RetrofitClient.getApiService();
        apiService.getAllLeagues().enqueue(new Callback<LeaguesResponse>() {
            @Override
            public void onResponse(Call<LeaguesResponse> call, Response<LeaguesResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ligasAdapter.setLigas(response.body().getLigas());
                } else {
                    Toast.makeText(getContext(), "Error al cargar ligas", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LeaguesResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getLeaguesByCountry(String country) {
        ApiService apiService = RetrofitClient.getApiService();
        apiService.getLeaguesByCountry(country).enqueue(new Callback<LeaguesResponse>() {
            @Override
            public void onResponse(Call<LeaguesResponse> call, Response<LeaguesResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ligasAdapter.setLigas(response.body().getLigas());
                } else {
                    Toast.makeText(getContext(), "No se encontraron ligas para " + country, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LeaguesResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}


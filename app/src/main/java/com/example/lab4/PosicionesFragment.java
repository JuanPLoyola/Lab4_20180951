package com.example.lab4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PosicionesFragment extends Fragment {

    private RecyclerView recyclerView;
    private PosicionesAdapter posicionesAdapter;
    private EditText etIdLiga, etTemporada;
    private Button btnBuscarPosiciones;
    private ApiService apiService;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_posiciones, container, false);

        // Inicializar las vistas y el adaptador
        recyclerView = view.findViewById(R.id.rvPosiciones);
        etIdLiga = view.findViewById(R.id.etIdLiga);
        etTemporada = view.findViewById(R.id.etTemporada);
        btnBuscarPosiciones = view.findViewById(R.id.btnBuscarPosiciones);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        posicionesAdapter = new PosicionesAdapter(new ArrayList<>());
        recyclerView.setAdapter(posicionesAdapter);

        // Inicializar el servicio API con Retrofit
        apiService = RetrofitClient.getApiService();

        // Configurar búsqueda al hacer clic en el botón Buscar
        btnBuscarPosiciones.setOnClickListener(v -> {
            String idLiga = etIdLiga.getText().toString().trim();
            String temporada = etTemporada.getText().toString().trim();

            if (!idLiga.isEmpty() && !temporada.isEmpty()) {
                getLeagueTable(idLiga, temporada);
            } else {
                Toast.makeText(getContext(), "Por favor ingrese el ID de la liga y la temporada", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    // Método para obtener la tabla de posiciones de la liga según la temporada
    private void getLeagueTable(String idLiga, String temporada) {
        apiService.getLeagueTable(idLiga, temporada).enqueue(new Callback<PosicionesResponse>() {
            @Override
            public void onResponse(Call<PosicionesResponse> call, Response<PosicionesResponse> response) {
                if (response.isSuccessful() && response.body() != null && !response.body().getPosiciones().isEmpty()) {
                    posicionesAdapter.setPosiciones(response.body().getPosiciones());
                } else {
                    Toast.makeText(getContext(), "No se encontraron resultados para la liga o temporada especificada", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PosicionesResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}



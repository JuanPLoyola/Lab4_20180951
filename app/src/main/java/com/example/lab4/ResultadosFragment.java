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

public class ResultadosFragment extends Fragment {

    private RecyclerView recyclerView;
    private ResultadosAdapter resultadosAdapter;
    private EditText etIdLiga, etTemporada, etRonda;
    private Button btnBuscarResultados;
    private ApiService apiService;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resultados, container, false);

        // Inicializar las vistas y el adaptador
        recyclerView = view.findViewById(R.id.rvResultados);
        etIdLiga = view.findViewById(R.id.etIdLiga);
        etTemporada = view.findViewById(R.id.etTemporada);
        etRonda = view.findViewById(R.id.etRonda);
        btnBuscarResultados = view.findViewById(R.id.btnBuscarResultados);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        resultadosAdapter = new ResultadosAdapter(new ArrayList<>());
        recyclerView.setAdapter(resultadosAdapter);

        // Inicializar el servicio API con Retrofit
        apiService = RetrofitClient.getApiService();

        // Configurar búsqueda al hacer clic en el botón Buscar
        btnBuscarResultados.setOnClickListener(v -> {
            String idLiga = etIdLiga.getText().toString().trim();
            String temporada = etTemporada.getText().toString().trim();
            String ronda = etRonda.getText().toString().trim();

            if (!idLiga.isEmpty() && !temporada.isEmpty() && !ronda.isEmpty()) {
                getResultados(idLiga, temporada, ronda);
            } else {
                Toast.makeText(getContext(), "Por favor ingrese todos los campos", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    // Método para obtener los resultados de la liga según la temporada y ronda
    private void getResultados(String idLiga, String temporada, String ronda) {
        apiService.getResultados(idLiga, ronda, temporada).enqueue(new Callback<ResultadosResponse>() {
            @Override
            public void onResponse( Call<ResultadosResponse> call, Response<ResultadosResponse> response) {
                if (response.isSuccessful() && response.body() != null && !response.body().getEncuentros().isEmpty()) {
                    resultadosAdapter.agregarEncuentros(response.body().getEncuentros());
                } else {
                    Toast.makeText(getContext(), "No se encontraron resultados para la liga, temporada o ronda especificada", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResultadosResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}



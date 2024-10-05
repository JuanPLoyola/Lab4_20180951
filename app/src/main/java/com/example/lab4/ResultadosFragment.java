package com.example.lab4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ResultadosFragment extends Fragment {

    private RecyclerView recyclerView;
    private ResultadosAdapter resultadosAdapter;
    private TextView tvLigaSeleccionadaResultados;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resultados, container, false);

        recyclerView = view.findViewById(R.id.rvResultados);
        tvLigaSeleccionadaResultados = view.findViewById(R.id.tvLigaSeleccionadaResultados);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        resultadosAdapter = new ResultadosAdapter(new ArrayList<>());
        recyclerView.setAdapter(resultadosAdapter);

        // Cargar datos de resultados (simulación)
        loadResultadosData();

        return view;
    }

    private void loadResultadosData() {
        // Simulación de carga de datos
        List<Resultado> resultados = new ArrayList<>();
        resultados.add(new Resultado("Equipo A", "Equipo B", 2, 1));
        resultados.add(new Resultado("Equipo C", "Equipo D", 1, 1));
        resultadosAdapter.setResultados(resultados);
    }
}


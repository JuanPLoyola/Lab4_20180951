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

public class PosicionesFragment extends Fragment {

    private RecyclerView recyclerView;
    private PosicionesAdapter posicionesAdapter;
    private TextView tvLigaSeleccionada;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_posiciones, container, false);

        recyclerView = view.findViewById(R.id.rvPosiciones);
        tvLigaSeleccionada = view.findViewById(R.id.tvLigaSeleccionada);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        posicionesAdapter = new PosicionesAdapter(new ArrayList<>());
        recyclerView.setAdapter(posicionesAdapter);

        // Cargar datos de posiciones (simulación)
        loadPosicionesData();

        return view;
    }

    private void loadPosicionesData() {
        // Simulación de carga de datos
        List<Posicion> posiciones = new ArrayList<>();
        posiciones.add(new Posicion("Equipo 1", 1, 25));
        posiciones.add(new Posicion("Equipo 2", 2, 20));
        posiciones.add(new Posicion("Equipo 3", 3, 18));
        posicionesAdapter.setPosiciones(posiciones);
    }
}


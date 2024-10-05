package com.example.lab4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PosicionesAdapter extends RecyclerView.Adapter<PosicionesAdapter.PosicionViewHolder> {

    private List<Posicion> posiciones;

    public PosicionesAdapter(List<Posicion> posiciones) {
        this.posiciones = posiciones;
    }

    public void setPosiciones(List<Posicion> posiciones) {
        this.posiciones = posiciones;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PosicionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_posicion, parent, false);
        return new PosicionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PosicionViewHolder holder, int position) {
        Posicion posicionData = posiciones.get(position);
        holder.tvNombreEquipo.setText(posicionData.getNombreEquipo());
        holder.tvPosicion.setText(String.valueOf(posicionData.getPosicion()));
        holder.tvPuntos.setText(String.valueOf(posicionData.getPuntos()));
    }

    @Override
    public int getItemCount() {
        return posiciones.size();
    }

    static class PosicionViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombreEquipo, tvPosicion, tvPuntos;

        public PosicionViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombreEquipo = itemView.findViewById(R.id.tvNombreEquipo);
            tvPosicion = itemView.findViewById(R.id.tvPosicion);
            tvPuntos = itemView.findViewById(R.id.tvPuntos);
        }
    }
}


package com.example.lab4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LigasAdapter extends RecyclerView.Adapter<LigasAdapter.LigaViewHolder> {

    private List<Liga> ligas;

    public LigasAdapter(List<Liga> ligas) {
        this.ligas = ligas;
    }

    public void setLigas(List<Liga> ligas) {
        this.ligas = ligas;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LigaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_liga, parent, false);
        return new LigaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LigaViewHolder holder, int position) {
        Liga liga = ligas.get(position);
        holder.tvNombre.setText(liga.getNombre());
        holder.tvNombreAlternativo.setText(liga.getNombreAlternativo());
    }

    @Override
    public int getItemCount() {
        return ligas.size();
    }

    static class LigaViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvNombreAlternativo;

        public LigaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvNombreAlternativo = itemView.findViewById(R.id.tvNombreAlternativo);
        }
    }
}


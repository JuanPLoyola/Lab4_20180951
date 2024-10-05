package com.example.lab4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PosicionesAdapter extends RecyclerView.Adapter<PosicionesAdapter.PosicionViewHolder> {

    private List<EquipoPosicion> posiciones;

    public PosicionesAdapter(List<EquipoPosicion> posiciones) {
        this.posiciones = posiciones;
    }

    public void setPosiciones(List<EquipoPosicion> posiciones) {
        this.posiciones = posiciones;
        notifyDataSetChanged();  // Actualiza la lista de posiciones
    }

    @NonNull
    @Override
    public PosicionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_posicion, parent, false);
        return new PosicionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PosicionViewHolder holder, int position) {
        EquipoPosicion equipoPosicion = posiciones.get(position);
        holder.tvNombreEquipo.setText(equipoPosicion.getNombreEquipo());
        holder.tvRanking.setText(String.valueOf(equipoPosicion.getRanking()));
        holder.tvVictoriasEmpatesDerrotas.setText(
                String.format("V: %d | E: %d | D: %d", equipoPosicion.getVictorias(), equipoPosicion.getEmpates(), equipoPosicion.getDerrotas()));
        holder.tvGoles.setText(
                String.format("G: %d | GC: %d | Diff: %d",
                        equipoPosicion.getGolesAnotados(), equipoPosicion.getGolesConcedidos(),
                        equipoPosicion.getGolesAnotados() - equipoPosicion.getGolesConcedidos()));
    }

    @Override
    public int getItemCount() {
        return posiciones.size();
    }

    static class PosicionViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombreEquipo, tvRanking, tvVictoriasEmpatesDerrotas, tvGoles;

        public PosicionViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombreEquipo = itemView.findViewById(R.id.tvNombreEquipo);
            tvRanking = itemView.findViewById(R.id.tvRanking);
            tvVictoriasEmpatesDerrotas = itemView.findViewById(R.id.tvVictoriasEmpatesDerrotas);
            tvGoles = itemView.findViewById(R.id.tvGoles);
        }
    }
}



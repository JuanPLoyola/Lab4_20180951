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
        this.posiciones = posiciones;  // Actualiza la lista completa de posiciones
        notifyDataSetChanged();  // Notifica al adaptador que los datos han cambiado
    }

    @NonNull
    @Override
    public PosicionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_posicion, parent, false);
        return new PosicionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PosicionViewHolder holder, int position) {
        // Obtener el equipo en la posición actual
        EquipoPosicion equipoPosicion = posiciones.get(position);

        // Configurar los datos del equipo en las vistas del ViewHolder
        holder.tvRanking.setText(String.valueOf(equipoPosicion.getRanking()));
        holder.tvNombreEquipo.setText(equipoPosicion.getNombreEquipo());
        holder.tvVictoriasEmpatesDerrotas.setText(
                String.format("V: %d | E: %d | D: %d", equipoPosicion.getVictorias(), equipoPosicion.getEmpates(), equipoPosicion.getDerrotas()));
        holder.tvGoles.setText(
                String.format("G: %d | GC: %d | Diff: %d",
                        equipoPosicion.getGolesAnotados(), equipoPosicion.getGolesConcedidos(),
                        equipoPosicion.getGolesAnotados() - equipoPosicion.getGolesConcedidos()));
    }

    @Override
    public int getItemCount() {
        return posiciones.size();  // Devolver el tamaño de la lista completa
    }

    static class PosicionViewHolder extends RecyclerView.ViewHolder {
        TextView tvRanking, tvNombreEquipo, tvVictoriasEmpatesDerrotas, tvGoles;

        public PosicionViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRanking = itemView.findViewById(R.id.tvRanking);
            tvNombreEquipo = itemView.findViewById(R.id.tvNombreEquipo);
            tvVictoriasEmpatesDerrotas = itemView.findViewById(R.id.tvVictoriasEmpatesDerrotas);
            tvGoles = itemView.findViewById(R.id.tvGoles);
        }
    }
}




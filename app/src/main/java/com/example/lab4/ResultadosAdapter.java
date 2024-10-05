package com.example.lab4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ResultadosAdapter extends RecyclerView.Adapter<ResultadosAdapter.ResultadoViewHolder> {

    private List<Encuentro> encuentros;

    public ResultadosAdapter(List<Encuentro> encuentros) {
        this.encuentros = encuentros;
    }

    public void agregarEncuentros(List<Encuentro> nuevosEncuentros) {
        encuentros.addAll(nuevosEncuentros);  // Agrega nuevos elementos a la lista existente
        notifyDataSetChanged();  // Notifica al adaptador que se han agregado nuevos datos
    }

    @NonNull
    @Override
    public ResultadoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_resultado, parent, false);
        return new ResultadoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultadoViewHolder holder, int position) {
        Encuentro encuentro = encuentros.get(position);

        holder.tvNombreLiga.setText(encuentro.getNombreLiga());
        holder.tvRonda.setText(encuentro.getNombreEvento());
        holder.tvEquipoLocal.setText(encuentro.getEquipoLocal());
        holder.tvEquipoVisitante.setText(encuentro.getEquipoVisitante());
        holder.tvResultado.setText(encuentro.getMarcadorLocal() + " - " + encuentro.getMarcadorVisitante());
        holder.tvFechaEvento.setText(encuentro.getFechaEvento());
    }

    @Override
    public int getItemCount() {
        return encuentros.size();
    }

    static class ResultadoViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombreLiga, tvRonda, tvEquipoLocal, tvEquipoVisitante, tvResultado, tvFechaEvento, tvEspectadores;

        public ResultadoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombreLiga = itemView.findViewById(R.id.tvNombreLiga);
            tvRonda = itemView.findViewById(R.id.tvRonda);
            tvEquipoLocal = itemView.findViewById(R.id.tvEquipoLocal);
            tvEquipoVisitante = itemView.findViewById(R.id.tvEquipoVisitante);
            tvResultado = itemView.findViewById(R.id.tvResultado);
            tvFechaEvento = itemView.findViewById(R.id.tvFechaEvento);
        }
    }
}


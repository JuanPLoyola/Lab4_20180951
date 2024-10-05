package com.example.lab4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ResultadosAdapter extends RecyclerView.Adapter<ResultadosAdapter.ResultadoViewHolder> {

    private List<Resultado> resultados;

    public ResultadosAdapter(List<Resultado> resultados) {
        this.resultados = resultados;
    }

    public void setResultados(List<Resultado> resultados) {
        this.resultados = resultados;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ResultadoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_resultado, parent, false);
        return new ResultadoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultadoViewHolder holder, int position) {
        Resultado resultado = resultados.get(position);
        holder.tvEquipoLocal.setText(resultado.getEquipoLocal());
        holder.tvEquipoVisitante.setText(resultado.getEquipoVisitante());
        holder.tvResultado.setText(String.format("%d - %d", resultado.getGolesLocal(), resultado.getGolesVisitante()));
    }

    @Override
    public int getItemCount() {
        return resultados.size();
    }

    static class ResultadoViewHolder extends RecyclerView.ViewHolder {
        TextView tvEquipoLocal, tvEquipoVisitante, tvResultado;

        public ResultadoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvEquipoLocal = itemView.findViewById(R.id.tvEquipoLocal);
            tvEquipoVisitante = itemView.findViewById(R.id.tvEquipoVisitante);
            tvResultado = itemView.findViewById(R.id.tvResultado);
        }
    }
}


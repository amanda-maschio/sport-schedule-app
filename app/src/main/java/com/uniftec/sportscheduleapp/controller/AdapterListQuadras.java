package com.uniftec.sportscheduleapp.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uniftec.sportscheduleapp.R;
import com.uniftec.sportscheduleapp.entities.Quadra;

import java.util.List;

public class AdapterListQuadras extends RecyclerView.Adapter<AdapterListQuadras.bucketQuadra> {

    protected List<Quadra> quadras;

    public AdapterListQuadras(List<Quadra> quadras) {
        this.quadras = quadras;
    }

    @NonNull
    @Override
    public AdapterListQuadras.bucketQuadra onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_layout_lista_quadras, parent, false);
        return new AdapterListQuadras.bucketQuadra(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterListQuadras.bucketQuadra holder, int position) {
        holder.fill((Quadra) quadras.toArray()[position]);
    }

    @Override
    public int getItemCount() {
        return quadras.size();
    }

    public static class bucketQuadra extends RecyclerView.ViewHolder {

        private TextView nomeQuadra;
        private TextView localQuadra;

        public bucketQuadra(@NonNull View itemView) {
            super(itemView);
            nomeQuadra = itemView.findViewById(R.id.nomequadra);
            localQuadra = itemView.findViewById(R.id.endereco);
        }

        public void fill(Quadra data) {
            nomeQuadra.setText(data.getNome());
            localQuadra.setText(data.getEndereco().getLocalidade() + ", " + data.getEndereco().getBairro() + ", " + data.getEndereco().getCep());
        }

    }


}
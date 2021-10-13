package com.uniftec.sportscheduleapp.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uniftec.sportscheduleapp.R;
import com.uniftec.sportscheduleapp.entities.Item;

import java.util.List;

public class AdapterListQuadras extends RecyclerView.Adapter<AdapterListQuadras.bucketQuadra> {

    protected List<Item> items;

    public AdapterListQuadras(List<Item> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public AdapterListQuadras.bucketQuadra onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_layout_lista, parent, false);
        return new AdapterListQuadras.bucketQuadra(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterListQuadras.bucketQuadra holder, int position) {
        holder.fill((Item) items.toArray()[position]);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class bucketQuadra extends RecyclerView.ViewHolder {

        private TextView nomeQuadra;
        private TextView localQuadra;
        private ImageView imageQuadra;

        public bucketQuadra(@NonNull View itemView) {
            super(itemView);
            nomeQuadra = itemView.findViewById(R.id.txtNome);
            localQuadra = itemView.findViewById(R.id.txtValor);
        }

        public void fill(Item data) {
            nomeQuadra.setText(data.getNome());
            localQuadra.setText(data.getValor());
        }

    }


}
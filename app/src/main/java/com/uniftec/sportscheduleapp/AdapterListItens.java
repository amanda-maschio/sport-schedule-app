package com.uniftec.sportscheduleapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterListItens extends RecyclerView.Adapter<AdapterListItens.linhaItem> {

    protected List<Item> items;

    public AdapterListItens(List<Item> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public AdapterListItens.linhaItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_layout_lista, parent, false);
        return new AdapterListItens.linhaItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterListItens.linhaItem holder, int position) {
        holder.fill((Item) items.toArray()[position]);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class linhaItem extends RecyclerView.ViewHolder {

        private TextView nomeItem;
        private TextView valorItem;
        private TextView qtdItem;

        public linhaItem(@NonNull View itemView) {
            super(itemView);
            nomeItem = itemView.findViewById(R.id.escreveNome);
            valorItem = itemView.findViewById(R.id.escreveValor);
            qtdItem = itemView.findViewById(R.id.escreveQtd);
        }

        public void fill(Item data) {
            nomeItem.setText(data.getNome());
            valorItem.setText(data.getValor());
            qtdItem.setText(data.getQuantidade());
        }

    }


}
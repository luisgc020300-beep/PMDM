package com.example.listaluis;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorCoches
        extends RecyclerView.Adapter<AdaptadorCoches.ViewHolder> {

    private final ArrayList<Coche> coches;

    public AdaptadorCoches(ArrayList<Coche> coches) {
        this.coches = coches;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImagen;
        TextView tvTitulo;
        TextView tvSubtitulo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImagen = itemView.findViewById(R.id.ivImagen);
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            tvSubtitulo = itemView.findViewById(R.id.tvSubtitulo);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View fila = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fila_coche, parent, false);
        return new ViewHolder(fila);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Coche coche = coches.get(position);
        holder.tvTitulo.setText(coche.getModelo());
        holder.tvSubtitulo.setText(coche.getMarca());
        holder.ivImagen.setImageResource(coche.getImagen());


        holder.itemView.setOnClickListener(v ->
                Toast.makeText(v.getContext(),
                        coche.getModelo(),
                        Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return coches.size();
    }
}
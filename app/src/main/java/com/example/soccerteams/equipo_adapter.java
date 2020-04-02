package com.example.soccerteams;


import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class equipo_adapter extends RecyclerView.Adapter<equipo_adapter.ViewHolderEquipo> {
private ArrayList<EQUIPO> listaequipos;
    public equipo_adapter(ArrayList<EQUIPO> listaequipos){

        this.listaequipos = listaequipos;
    }

    @NonNull
    @Override
    public equipo_adapter.ViewHolderEquipo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.datos_equipo, null,false);
        return new ViewHolderEquipo(view);
    }

    @Override
    public void onBindViewHolder(@NonNull equipo_adapter.ViewHolderEquipo holder, int position) {
        holder.nombre.setText(listaequipos.get(position).getNombre());
        holder.director.setText(listaequipos.get(position).getDirector());
        holder.ciudades.setText(listaequipos.get(position).getCiudades());
        holder.partidos.setText(listaequipos.get(position).getPartidos_ganados());
    }

    @Override
    public int getItemCount() {
        return listaequipos.size();
    }

    public class ViewHolderEquipo extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

        TextView nombre, director, ciudades,partidos;

        public ViewHolderEquipo(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.txtnombre);
            director = itemView.findViewById(R.id.txtdirector);
            ciudades = itemView.findViewById(R.id.txtciudad);
            partidos = itemView.findViewById(R.id.txtpartidos);

            itemView.setOnCreateContextMenuListener(this);
        }
        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle("Editar equipos");
            menu.add(0, 1, Menu.NONE, "EDITAR");
            menu.add(0, 2, Menu.NONE, "ELIMINAR");



        }


    }
}


package com.example.soccerteams;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Listado_Equipo extends AppCompatActivity {

    ArrayList<EQUIPO> lista;
    RecyclerView rvequipo;
    ArrayAdapter<EQUIPO> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado);

        lista = new ArrayList<>();
        rvequipo = findViewById(R.id.lstEquipo);
        rvequipo.setLayoutManager(new LinearLayoutManager(this));
        Intent i = getIntent();
        lista = i.getParcelableArrayListExtra("equipos");

        equipo_adapter equipoAdapter = new equipo_adapter(lista);
        rvequipo.setAdapter(equipoAdapter);



    }



    public boolean onContextItemSelected(@NonNull MenuItem item) {
        TextView txtnombre;
        switch (item.getItemId()) {
            case 1:
                AlertDialog.Builder builder = new AlertDialog.Builder(Listado_Equipo.this);
                builder.setMessage("Desea EDITAR?")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                Intent i = new Intent(Listado_Equipo.this, editar.class);
                            startActivity(i);
               /* i.putParcelableArrayListExtra("equipos", lista);*/
                                Toast.makeText(getApplicationContext(), "CAMPO EDITAR", Toast.LENGTH_SHORT).show();
                        }
        })

                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                AlertDialog alerta1 = builder.create();
                alerta1.show();
                break;

            case 2:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(Listado_Equipo.this);
                builder2.setMessage("Desea eliminar?")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                lista.remove(0);
                                equipo_adapter equipoadapter = new equipo_adapter(lista);
                                rvequipo.setAdapter(equipoadapter);
                                Toast.makeText(getApplicationContext(), "Eliminado", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alerta = builder2.create();
                alerta.show();
        }




        return super.onContextItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent i = new Intent(this, MainActivity.class);
        i.putParcelableArrayListExtra("equipos", lista);
        setResult(Activity.RESULT_OK, i);
        finish();

        return true;
    }


}

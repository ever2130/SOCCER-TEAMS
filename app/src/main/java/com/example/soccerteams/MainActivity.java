package com.example.soccerteams;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
      EditText nombre,director;
      Spinner ciudad;
      NumberPicker partidos;
      Button guardar;
      ArrayList<EQUIPO> equipos = new ArrayList<>();

    String p="0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nombre = findViewById(R.id.edt_nombre);
        director = findViewById(R.id.edt_diector);
        ciudad = findViewById(R.id.spinner);
        partidos = findViewById(R.id.NPcampeonatos);
        guardar = findViewById(R.id.btagregar);
        String[] ciudades = { "Leticia ","Medellín","Arauca", "Barranquilla","Cartagena","Tunja","Manizales","Florencia","Yopal","Popayán","Valledupar","Quibdó","Montería","Bogotá","Puerto Inírida","San José del Guaviare","Neiva","Riohacha","Santa Marta","Villavicencio","Pasto","Cúcuta","Mocoa","Armenia","Pereira","San Andrés","Bucaramanga","Sincelejo", "Ibagué"
,"Cali", "Mitú","Puerto Carreño"};
        ArrayAdapter<String>arrayAdapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,ciudades);
        ciudad.setAdapter(arrayAdapter);
partidos.setMaxValue(100);
partidos.setMinValue(0);
partidos.setWrapSelectorWheel(true);
        guardar.setOnClickListener(this);

partidos.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        p= ""+  newVal;

    }

});


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        switch (id) {

            case R.id.listados:
                Intent i = new Intent(this, Listado_Equipo.class);
                i.putParcelableArrayListExtra("equipos", equipos);
                startActivityForResult(i, 5);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 5) {
            equipos = data.getParcelableArrayListExtra("equipos");

        }

    }
    @Override
    public void onClick(View v) {
        final String ci= ciudad.getSelectedItem().toString();
        switch (v.getId()) {

            case R.id.btagregar:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Desea agregar este equipo?").setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EQUIPO equipo = new EQUIPO(nombre.getText().toString(),director.getText().toString(),ci,p);
                    equipos.add(equipo);

                    nombre.setText("");
                    director.setText("");
                        Toast.makeText(getApplicationContext(), "Guardado", Toast.LENGTH_SHORT).show();

                    }
                }).setNegativeButton("NO",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

            }            }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

}

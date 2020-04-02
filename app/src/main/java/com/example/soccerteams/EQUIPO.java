package com.example.soccerteams;

import android.os.Parcel;
import android.os.Parcelable;

public class EQUIPO implements Parcelable {
    private String nombre;
    private String director;
    private String ciudades;
    private String partidos_ganados;

    public static final Creator<EQUIPO> CREATOR = new Creator<EQUIPO>() {
        @Override
        public EQUIPO createFromParcel(Parcel in) {
            return new EQUIPO(in);
        }

        @Override
        public EQUIPO[] newArray(int size) {
            return new EQUIPO[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCiudades() {
        return ciudades;
    }

    public void setCiudades(String ciudades) {
        this.ciudades = ciudades;
    }

    public String getPartidos_ganados() {
        return partidos_ganados;
    }

    public void setPartidos_ganados(String partidos_ganados) {
        this.partidos_ganados = partidos_ganados;
    }

    public EQUIPO(String nombre, String director, String ciudades, String partidos_ganados) {
        this.nombre = nombre;
        this.director = director;
        this.ciudades = ciudades;
        this.partidos_ganados = partidos_ganados;
    }
    public EQUIPO(Parcel in) {
        nombre = in.readString();
        director = in.readString();
        ciudades = in.readString();
        partidos_ganados = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(director);
        dest.writeString(ciudades);
        dest.writeString(partidos_ganados);
    }
}

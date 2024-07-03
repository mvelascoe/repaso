package com.java.ciudad.domain.model;

public class Ciudad {
    private int id_ciudad;
    private String nombre_cliudad;
    private int id_Pais;
    
    
    public Ciudad() {
    }


    public Ciudad(int id_ciudad, String nombre_cliudad, int id_Pais) {
        this.id_ciudad = id_ciudad;
        this.nombre_cliudad = nombre_cliudad;
        this.id_Pais = id_Pais;
    }


    public int getId_ciudad() {
        return id_ciudad;
    }


    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }


    public String getNombre_cliudad() {
        return nombre_cliudad;
    }


    public void setNombre_cliudad(String nombre_cliudad) {
        this.nombre_cliudad = nombre_cliudad;
    }


    public int getId_Pais() {
        return id_Pais;
    }


    public void setId_Pais(int id_Pais) {
        this.id_Pais = id_Pais;
    }

}

package com.java.pais.domain.model;

public class Pais {
    private int id_Pais;
    private String nombre;
    
    public Pais() {
    }

    public Pais(int id_Pais, String nombre) {
        this.id_Pais = id_Pais;
        this.nombre = nombre;
    }

    public int getId_Pais() {
        return id_Pais;
    }

    public void setId_Pais(int id_Pais) {
        this.id_Pais = id_Pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

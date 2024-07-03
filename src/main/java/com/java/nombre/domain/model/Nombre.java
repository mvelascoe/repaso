package com.java.nombre.domain.model;

public class Nombre {
    private int id_nombre;
    private String nombre;
    private int edad;
    private String direccion;
    private int id_ciudad;
    
    public Nombre() {
    }
    
    public Nombre(int id_nombre, String nombre, int edad, String direccion, int id_ciudad) {
        this.id_nombre = id_nombre;
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.id_ciudad = id_ciudad;
    }

    public int getId_nombre() {
        return id_nombre;
    }

    public void setId_nombre(int id_nombre) {
        this.id_nombre = id_nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

}

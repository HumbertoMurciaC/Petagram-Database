package com.example.humbertomariom.petagram.Pojo;

/**
 * Created by Humberto Mario M on 25/06/2016.
 */
public class Mascota {


    private int id;
    private String nombre;
    private int foto;
    private int raiting;

    public Mascota(String nombre, int foto, int raiting) {
        this.nombre = nombre;
        this.foto = foto;
        this.raiting = raiting;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }
}

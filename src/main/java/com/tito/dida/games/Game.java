package com.tito.dida.games;


public class Game {
    
    private int id;
    private String nombre;
    private String desarrollador;
    private String descripcion;
    private String valoracion;
    private String pegi;
    private String plataforma;

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

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    public String getPegi() {
        return pegi;
    }

    public void setPegi(String pegi) {
        this.pegi = pegi;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public Game(int id, String nombre, String desarrollador, String descripcion, String valoracion, String pegi, String plataforma) {
        this.id = id;
        this.nombre = nombre;
        this.desarrollador = desarrollador;
        this.descripcion = descripcion;
        this.valoracion = valoracion;
        this.pegi = pegi;
        this.plataforma = plataforma;
    }

    public Game() {
    }
    
    
}
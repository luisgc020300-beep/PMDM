package com.example.listaluis;
public class Coche {

    private String modelo;
    private String marca;
    private int imagen;   // el recurso de la imagen: R.drawable.algo

    public Coche(String modelo, String marca, int imagen) {
        this.modelo = modelo;
        this.marca = marca;
        this.imagen = imagen;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public int getImagen() {
        return imagen;
    }
}
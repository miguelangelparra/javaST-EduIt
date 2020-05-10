/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neurosoft.transporte;

/**
 *
 * @author m.parra.davila
 */
public class Auto extends Transporte {

    private String marca;
    private String modelo;
    private String anio;

    public Auto(String marca, String modelo, String anio, int pasajeros, float valor, float velMin, float velMax) {
        super(pasajeros, valor, velMin, velMax);
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    @Override
    public void acelerar() {
        System.out.println("Estoy acelerando como un auto");
        acelerar(10);

    }

    @Override
    public void acelerar(int cuanto) {
        System.out.print("Acelero en " + cuanto);
    }

    @Override
    public void frenar() {
        System.out.println("Frenando como un auto");
    }

}

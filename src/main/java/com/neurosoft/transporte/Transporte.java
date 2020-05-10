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
public abstract class Transporte {

    protected int pasajeros;
    protected float valor;
    protected float velMin;
    protected float velMax;

    public Transporte(int pasajeros, float valor, float velMin, float velMax) {
        this.pasajeros = pasajeros;
        this.valor = valor;
        this.velMin = velMin;
        this.velMax = velMax;
    }

    //COn un metodo abstracto la clase debe ser abstracta. El metodo debe ser definido en la clase que extiende de forma obligatoria
    public abstract void acelerar();
    
    public abstract void acelerar(int cuanto);

    public abstract void frenar();

    public void cargarPasajeros() {
        System.out.println("Cargando Pasajeros");
    }

}

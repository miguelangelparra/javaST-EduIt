/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neurosoft.naves;

/**
 *
 * @author m.parra.davila
 */
public class NavePasajeros extends Nave {
    
    private int cantPasajeros;
    private int cantComidas;
    private int cantBebidas;
    
    public NavePasajeros(int velocidad, int direccion, int combustible, int pasajeros, int comidas, int bebidas) {
        super(velocidad, direccion, combustible);
        this.cantPasajeros = pasajeros;
        this.cantComidas = comidas;
        this.cantBebidas = bebidas;
    }
    
    public int getCantPasajeros() {
        return cantPasajeros;
    }
    
    public int getCantComidas() {
        return cantComidas;
    }
    
    public int getCantBebidas() {
        return cantBebidas;
    }
    
    public void cargarComidas(int comidas) {
        this.cantComidas += comidas;
    }
    
    public void desCargarComidas(int comidas) {
        this.cantComidas -= comidas;
    }
    
    public void cargarBebidas(int bebidas) {
        this.cantBebidas += bebidas;
    }
    
    public void desCargarBebidass(int bebidas) {
        this.cantBebidas -= bebidas;
    }
    
    @Override
    public void pasosExtras() {
        // super.prepararViaje();
        this.cargarComidas(4 * this.cantPasajeros);
        this.cargarBebidas(6 * this.cantPasajeros);
        this.alejarPocoAlSol();
    }
    
    @Override
    protected void escapar() {
        this.acelerar(this.getVelocidad() * 2);
    }
    
    @Override
    protected void avisar() {
        this.desCargarComidas(this.cantPasajeros);
        this.desCargarBebidass(this.cantPasajeros * 2);
    }
    
}

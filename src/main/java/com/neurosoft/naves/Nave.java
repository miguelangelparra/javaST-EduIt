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
//Final lo haria ineredable, se corta la rama de herencia
public abstract class Nave {

    //Final los haria inmodificables
    private Integer velocidad;
    private Integer direccion;
    private Integer combustible;

    public Nave(int velocidad, int direccion, int combustible) {
        this.velocidad = velocidad;
        this.direccion = direccion;
        this.combustible = combustible;
    }

    protected Integer getVelocidad() {
        return velocidad;
    }

    protected void setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
    }

    protected Integer getDireccion() {
        return direccion;
    }

    protected void setDireccion(Integer direccion) {
        this.direccion = direccion;
    }

    protected void acelerar(Integer cuanto) {
        this.velocidad += cuanto;
        if (velocidad > 100000) {
            velocidad = 100000;
        }
    }

    protected void desacelerar(Integer cuanto) {
        this.velocidad -= cuanto;
        if (velocidad < 0) {
            velocidad = 0;
        }
    }

    protected void irAlSol() {
        direccion = 10;
    }

    public void alejarseDelSol() {
        direccion = -10;
    }

    public void paraleloAlSol() {
        direccion = 0;
    }

    public void acercarsePocoAlSol() {
        direccion += 1;
        if (direccion > 10) {
            direccion = 10;
        }
    }

    public void alejarPocoAlSol() {
        direccion -= 1;
        if (direccion < -10) {
            direccion = -10;
        }
    }

    public void cargarCombustible(int cant) {
        this.combustible += cant;
    }

    public void descargarCombustible(int cant) {
        this.combustible -= cant;
    }
//Template method 
    //Final lo hace inmodificable

    public final void prepararViaje() {
        this.cargarCombustible(5000);
        this.acelerar(5000);
        pasosExtras();
    }

    protected abstract void pasosExtras();

    public void recibirAmenaza() {
        escapar();
        avisar();
        pasoExtraAmenaza();
    }

    protected abstract void escapar();

    protected abstract void avisar();

    public void pasoExtraAmenaza() {
    }
}

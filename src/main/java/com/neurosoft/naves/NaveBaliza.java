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
public class NaveBaliza extends Nave {

    private String colorBaliza;

    public NaveBaliza(int velocidad, int direccion, int combustible, String color) {
        super(velocidad, direccion, combustible);
        this.colorBaliza = color;
    }

    public String colorBaliza() {
        return this.colorBaliza;
    }

    public void cambiarColor(String colorNuevo) {
        this.colorBaliza = colorNuevo;
    }

    @Override
    public void pasosExtras() {
        this.cambiarColor("verde");
        this.paraleloAlSol();
    }

    @Override
    protected void escapar() {
        this.irAlSol();
    }

    @Override
    protected void avisar() {
        this.cambiarColor("Rojo");
    }

}

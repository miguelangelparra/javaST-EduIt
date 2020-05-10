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
public class NaveHospital extends NavePasajeros {

    private boolean quirofanoPreparado;

    public NaveHospital(int velocidad, int direccion, int combustible, int pasajeros, int comidas, int bebidas, boolean quirofanoPreparado) {
        super(velocidad, direccion, combustible, pasajeros, comidas, bebidas);
        this.quirofanoPreparado = quirofanoPreparado;
    }

    public boolean isQuirofanoPreparado() {
        return quirofanoPreparado;
    }

    public void setQuirofanoPreparado(boolean quirofanoPreparado) {
        this.quirofanoPreparado = quirofanoPreparado;
    }

    @Override
    public void pasoExtraAmenaza() {
        this.setQuirofanoPreparado(true);
    }

}

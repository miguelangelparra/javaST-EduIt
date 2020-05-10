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
public class NaveClinica extends NaveHospital {
    
    public NaveClinica(int velocidad, int direccion, int combustible, int pasajeros, int comidas, int bebidas, boolean quirofanoPreparado) {
        super(velocidad, direccion, combustible, pasajeros, comidas, bebidas, quirofanoPreparado);
    }
    
    @Override
    public void pasoExtraAmenaza() {
        super.pasoExtraAmenaza();
        this.desacelerar(0);
    }
}

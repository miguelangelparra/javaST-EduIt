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
public class NaveFalopa extends Nave {

    public NaveFalopa(int velocidad, int direccion, int combustible) {
        super(velocidad, direccion, combustible);
    }

    @Override
    public void pasosExtras() {
    }

    @Override
    protected void escapar() {
    }

    @Override
    protected void avisar() {
    }

}

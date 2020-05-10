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
public class Moto extends Transporte {

    public Moto(int pasajeros, float valor, float velMin, float velMax) {
        super(pasajeros, valor, velMin, velMax);
    }

    @Override
    public void acelerar() {
        System.out.println("Acelerando como moto....ñaaaaa");
        acelerar(10);
    }

    @Override
    public void acelerar(int cuanto) {
        System.out.print("Acelero en " + cuanto + "Años luz!");
    }

    @Override
    public void frenar() {
        System.out.println("Freno como moto");
    }

}

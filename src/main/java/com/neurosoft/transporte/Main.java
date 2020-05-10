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
public class Main {

    public static void main(String[] args) {
        Auto auto1 = new Auto("Chevrolet", "Caprice", "1978", 6, 4234, 0, 140);

        Transporte transporte2 = new Moto(4, 5523, 44, 221);
        Transporte transporte1 = new Auto("Ford", "Camion", "2005", 4, 1234, 0, 160);
        //Parsea la clase 
        Auto auto2 = (Auto) transporte1;

        System.out.println(auto1.getMarca());
        System.out.println(auto2.getModelo());

        auto1.acelerar();
        transporte2.acelerar();

        Moto moto1 = new Moto(2, 200000, 0, 123);
        Embarcacion embarcacion1 = new Embarcacion(30, 2500000, 50, 120);

auto1.acelerar();
moto1.acelerar();
embarcacion1.acelerar();
embarcacion1.frenar();
    }
}

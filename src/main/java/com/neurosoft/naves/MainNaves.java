/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neurosoft.naves;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author m.parra.davila
 */
public class MainNaves {

    public static void main(String[] args) {
        NavePasajeros navePasajeros = new NavePasajeros(123, 12, 3, 22, 33, 222);
        Nave naveBaliza = new NaveBaliza(1222, 3333, 444, "verde");
        Nave naveCombate = new NaveCombate(234, 234, 123, true, true);
        Nave naveFalopa = new NaveFalopa(12, 12, 12);
        Nave naveHospital = new NaveHospital(10, 12, 21, 22, 33, 33, false);
        Nave naveClinica = new NaveClinica(10, 12, 21, 22, 33, 33, false);

        naveBaliza.prepararViaje();
        naveCombate.prepararViaje();
        naveFalopa.prepararViaje();

        //Crea una lista
        preparandoViaje(Arrays.asList(navePasajeros, naveBaliza, naveCombate, naveFalopa));

        naveBaliza.recibirAmenaza();
        naveCombate.recibirAmenaza();
        navePasajeros.recibirAmenaza();
        naveFalopa.recibirAmenaza();
        naveHospital.recibirAmenaza();
        naveClinica.recibirAmenaza();
    }
//Otra forma de foreach

    public static void preparandoViaje(List<Nave> naves) {
        for (Nave nave : naves) {
            nave.prepararViaje();
        }
    }
//Un forEach

    public static void amenaza(List<Nave> naves) {
        naves.forEach((nave) -> {
            nave.recibirAmenaza();
        });
    }
}

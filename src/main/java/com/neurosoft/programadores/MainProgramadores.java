/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neurosoft.programadores;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author m.parra.davila
 */
public class MainProgramadores {

    public static void main(String[] args) {
        ProgramadorJava java = new ProgramadorJava("Juan", "Senior");
        ProgramadorPython python = new ProgramadorPython("Pepe");

        Programador p1 = new ProgramadorJava("Pedro", "Junior");

        p1.debugear();

        Set<Programador> programadores = new HashSet<Programador>();
        programadores.add(new ProgramadorJava("Pepe", "Senior"));
        programadores.add(new ProgramadorJava("Pepe", "Senior"));
        programadores.add(new ProgramadorPython("pedro"));

        programadores.forEach(System.out::println);

        String s1 = new String("ola");
        String s2 = new String("ola");
        // Con == compara referencias 
        System.out.println("Son iguales con == " + (s1 == s2));
        //con equals compara objetos
        System.out.println("Son iguales con equals? " + s1.equals(s2));

        Programador java1 = new ProgramadorJava("Pedrito", "Jr");
        Programador java2 = new ProgramadorJava("Pedrito", "Jr");

        System.out.println("Son iguales con == " + (java1 == java2));
        System.out.println("Son iguales con equals? " + java1.equals(java2));

    }
} 

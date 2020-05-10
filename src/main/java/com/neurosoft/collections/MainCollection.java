/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neurosoft.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author m.parra.davila
 */
public class MainCollection {

    public static void main(String[] args) {

        //Forma vieja de declarar collections en donde no se indicaba el tipo de clase de sus elementos. 
        //esto traia el problema del casteo y error en tiempo de ejecucion. 
        Collection numerosviejos = new ArrayList();

        numerosviejos.add(12);
        numerosviejos.add(13);

        for (Object numero : numerosviejos) {
            System.out.println((Integer) numero + 3);
        }

        //Forma Nueva, se especifica el tipo de objeto que guardará la collection. 
        Collection<Integer> numeros = new ArrayList<Integer>();
        numeros.add(25);
        numeros.add(55);
        numeros.add(80);

        for (Integer numero : numeros) {
            System.out.println(numero);
        }

        numeros.remove(55);

        System.out.println("SegundaVuelta");
        for (Integer numero : numeros) {
            System.out.println(numero);
        }

        System.out.println("tamaño: " + numeros.size());

        List<Integer> lista = new ArrayList();
        lista.add(22);
        lista.add(55);
        lista.add(500);

        System.out.println("posicion 2: " + lista.get(2));

        //Usando forEach con lambdas
        lista.forEach(e -> System.out.println(e));

        //SEt
        Set<String> palabras = new HashSet<>();
        palabras.add("Tomate");
        palabras.add("Cafe");
        palabras.add("Azucar");
        palabras.add("Cebolla");

        //Simplificacion de un lambda cuando recibe un solo parametro en un solo metodo
        palabras.forEach(System.out::println);

        String s1 = "ola";
        String s2 = "ola";
        // Con == compara referencias 
        System.out.println("Son iguales con == " + (s1 == s2));
        //con equals compara objetos
        System.out.println("Son iguales con equals? " + s1.equals(s2));

        List<String> palabras2 = new ArrayList<>();
        palabras2.add("Perro");
        palabras2.add("Caiman");
        palabras2.add("Zariguella");
        palabras2.add("Gato");
        palabras2.add("Gavilan");
        palabras2.add("Guacamaya");

        //Ordena de forma  natural
        palabras2.sort(null);
        palabras2.forEach(System.out::println);

        //ordena de forma custom con una clase que implemente comparator
        palabras2.sort(new OrdenamientoDescendente());
        palabras2.forEach(System.out::println);

        //orden custom por tamaño
        palabras2.sort(new OrdenPorTamano());
        palabras2.forEach(System.out::println);

        //TreeSet siempre está ordenado
        Set<String> animales = new TreeSet<>();
        animales.add("Gaviota");
        animales.add("Araña");
        animales.add("Hipopotamo");
        animales.add("Ballena");
        animales.add("Morzita");

        animales.forEach(System.out::println);
//En la definicion de treeset se puede pasar el criterio de ordenameiento con un comparator
        System.out.println("Descendente");
        Set<String> animales2 = new TreeSet<>(new OrdenamientoDescendente());
        animales2.add("Gaviota");
        animales2.add("Araña");
        animales2.add("Hipopotamo");
        animales2.add("Ballena");
        animales2.add("Morzita");

        animales2.forEach(System.out::println);

        //Mochilas
        Set<Mochila> mochilas = new TreeSet<>();
        mochilas.add(new Mochila("verde", "23"));
        mochilas.add(new Mochila("verde", "23"));
        mochilas.add(new Mochila("azul", "34"));
        mochilas.add(new Mochila("azul", "35"));
        mochilas.add(new Mochila("rojo", "233"));
        mochilas.add(new Mochila("amarillo", "2223"));

        mochilas.forEach(System.out::println);

        Map<String, Integer> poblacion = new HashMap<>();
        poblacion.put("Argentina", 5000);
        poblacion.put("Brasil", 2000);
        poblacion.put("Venezuela", 10000);

        Integer pArgentina = poblacion.get("Argentina");
        System.out.println("Poblacion Argentina: " + pArgentina);

        Map<String, Poblacion> poblacion2 = new HashMap<>();
        poblacion2.put("Argentina", new Poblacion("Argentina", 20000L));
        poblacion2.put("Brasil", new Poblacion("Brasil", 22222L));
        poblacion2.put("Venezuela", new Poblacion("Venezuela", 123123123L));

        System.out.println(poblacion2);

        poblacion2.forEach((clave, valor) -> System.out.println("Clave:" + clave + "valor:" + valor));

        //Devuelve si lo encuentras o devuelve el default        Pero no agrega el default al map
        Poblacion def1 = poblacion2.getOrDefault("Peru", new Poblacion("Peru", 20000L));
        System.out.println(def1);
        poblacion2.forEach((clave, valor) -> System.out.println("Clave:" + clave + "valor:" + valor));

        System.out.println(poblacion2.containsKey("Argentina"));
        System.out.println(poblacion2.containsValue(2222L));
        System.out.println(poblacion2.containsValue(222222L)
        );
        //Tamaño del map
        System.out.println(poblacion2.size());

        //Set de las claves del map, son set porque las claves no se pueden repetir
        Set<String> claves = poblacion2.keySet();
        //Collecion de valores del map 
        Collection<Poblacion> valores = poblacion2.values();

        claves.forEach(System.out::println);
        valores.forEach(System.out::println);

        //remove(key) Borra de la collection , devuelve null si no existe el objeto con esa Key
        Poblacion borrado1 = poblacion2.remove("Chile");

        //remove tambien te devuelve el objeto borrado. 
        Poblacion borrado2 = poblacion2.remove("Brasil");

        System.out.println(borrado1);
        System.out.println(borrado2);

    }

}

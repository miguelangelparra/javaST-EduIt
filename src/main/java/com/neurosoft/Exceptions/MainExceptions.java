/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neurosoft.Exceptions;

import java.io.IOException;

/**
 *
 * @author m.parra.davila
 */
public class MainExceptions {

    public static void main(String[] args) throws Exception {

        try {
            String texto = "Esto es un texto que será guardado ";
            guardarTextoCheck(texto);
            System.out.println("Se guardó el texto! Yei!! ");
        } catch (IOException e) {
            System.out.println("Algo salio mal, el texto no se guardó");
            e.printStackTrace();
        }

        String texto2 = "Otro texto";
        //Si una exception se deja burbujear y no se atrapa sale por el main y revienta la Virtual Machine. 
        //Se pueden atrapar todas las excepciones en el catch colocando el generico "Exception"
        //Las Excepciones de RuntimeException no son chekeados, por lo que pueden burbujear sin ser limitantes.
        guardarTexto(texto2);
        
        buscarUsuario("Pepito");

        System.out.println("Fin del Programa");
    }

    static void guardarTextoCheck(String texto) throws IOException {
        //Arroja el error
        throw new IOException();
    }

    static void guardarTexto(String texto) throws RuntimeException {
        //Arroja el error
        throw new RuntimeException();
    }

    //Exception no chequeada custom
    public static void buscarUsuario(String id) {
        throw new UsuarioInexistente("usuario inexistente", null);
    }
    
    //Exception chequeada custom
    public static void errorEnElSistma() throws ErrorDelSistema{
        throw new ErrorDelSistema("Error en el sistema",null);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neurosoft.Exceptions;

/**
 *
 * @author m.parra.davila
 */
public class UsuarioInexistente extends RuntimeException{
    //Exception no chekeada custom
    public UsuarioInexistente(String mensaje, Throwable cause){
        super(mensaje,cause);
    }
    
}

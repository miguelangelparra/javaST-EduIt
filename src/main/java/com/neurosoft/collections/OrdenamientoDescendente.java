/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neurosoft.collections;

import java.util.Comparator;

/**
 *
 * @author m.parra.davila
 */
public class OrdenamientoDescendente implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2) * -1;
    }
}

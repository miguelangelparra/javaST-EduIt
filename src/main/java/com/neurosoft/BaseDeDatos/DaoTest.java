/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neurosoft.BaseDeDatos;

import java.sql.SQLException;

/**
 *
 * @author m.parra.davila
 */
public class DaoTest {

    public static void main(String[] args) {
        ConnectionManager connectionManager = new ConnectionManager();
        EstudianteDao dao = new EstudianteDao(connectionManager);

        //CREA ESTUDIANTE
         Estudiante e1 = new Estudiante();
        e1.setNombre("Carlos");
        e1.setApellido("Gaviota");
        e1.setPadron("2022");

        try {
            dao.grabar(e1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        //MODIFICA ESTUDIANTE
        /* Estudiante e1 = new Estudiante();
        e1.setId(1);
        e1.setNombre("Miguelangel De Jesus");
        e1.setApellido("Parra Davila");
        e1.setPadron("2020");
        try {
            dao.updateEstudiante(e1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
         */
    }
}

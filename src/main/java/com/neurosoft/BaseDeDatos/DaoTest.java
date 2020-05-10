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

    public static void main(String[] args) throws SQLException {
        ConnectionManager connectionManager = new ConnectionManager();
        EstudianteDao dao = new EstudianteDao(connectionManager);
        /*
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
         Estudiante e1 = new Estudiante();
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

 /*        
//Crea Carrera
        CarreraDao carreraDao = new CarreraDao(connectionManager);
        Carrera carrera1 = new Carrera();
        carrera1.setNombre("Ingenieria Psicologica");
        carreraDao.grabar(carrera1);
         */
//Crea materia
        MateriaDao materiaDao = new MateriaDao(connectionManager);
        /*     Materia materia1 = new Materia();
        materia1.setNombre("Analisis Matematico 1");
        materia1.setCargaHoraria(50);
        materiaDao.grabar(materia1);

        Materia materia2 = new Materia();
        materia2.setNombre("Analisis Matematico 4");
        materia2.setCargaHoraria(500);
        materiaDao.grabar(materia2);
         */
        System.out.println(materiaDao.obtenerUno(1));
        materiaDao.obtenerTodos().forEach(System.out::println);
    }
}

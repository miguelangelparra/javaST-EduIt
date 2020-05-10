/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neurosoft.BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author m.parra.davila
 */
public class ConnectionManager {
    
    private Connection connection = null;
    
    public Connection getConnection() throws SQLException {
        //Confirma que exista una conexion valida 
        if (connection == null || connection.isClosed() || connection.isValid(10000)) {
            //Establece una conexion a la base de datos 

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/universidad", "root", "admin");
        }
        return connection;
    }
;
}

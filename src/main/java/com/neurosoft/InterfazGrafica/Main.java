package com.neurosoft.InterfazGrafica;

import com.neurosoft.InterfazGrafica.negocio.MateriaBussines;
import com.neurosoft.InterfazGrafica.persistencia.ConnectionManager;
import com.neurosoft.InterfazGrafica.persistencia.MateriaDao;
import com.neurosoft.InterfazGrafica.presentacion.MateriaUIController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args)  {
//Metodo de la superclase Application que dispara el Fx
        launch(args);
    }

    //Metodo que inicializa la aplicacion
    @Override
    public void start(Stage primaryStage) throws IOException {
        //Carga el archivo de los resources
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfazGrafica/presentacion/MateriaUI.fxml"));
       //leer el archivo y crea los objetos necesarios para la pantalla
        Parent root = loader.load();
        //Obtiene el controller
        MateriaUIController controller =loader.getController();

        //Inyeccion de depencias, creacion y linkeo de los objetos que usa mi aplicacion, Conecta todas las capas
        ConnectionManager connectionManager=new ConnectionManager();
        MateriaDao materiaDao = new MateriaDao(connectionManager);
        MateriaBussines materiaBussines = new MateriaBussines(materiaDao);
        controller.setMateriaBussiness(materiaBussines);
        //

        //Crea un objeto escena y le setea los objetos creados en el loader
        Scene scene =new Scene(root);
        //Le setea la esena al stage que viene dado por el start
        primaryStage.setScene(scene);
        //Muestra la escena
        primaryStage.show();
       //El codigo anterior es repetitivo
        //El stage es como el escenario y scene es la escena

    }


}

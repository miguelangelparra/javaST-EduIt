package tests;

import com.neurosoft.InterfazGrafica.dominio.Materia;
import com.neurosoft.InterfazGrafica.persistencia.ConnectionManager;
import com.neurosoft.InterfazGrafica.persistencia.MateriaDao;
import org.mockito.Mock;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class MateriaDaoTest {

    //Una Forma de hacer un mock
    //@Mock
   // private ConnectionManager connectionManager;


    @Test(groups = {"pricnipal"})
    public void actualizarOk(){

        try {
            //Otra forma de hacer un mock
            ConnectionManager connectionManager = mock(ConnectionManager.class);
            Connection connection = mock(Connection.class);
            PreparedStatement preparedStatement = mock(PreparedStatement.class);

            when(connectionManager.getConnection()).thenReturn(connection);
            when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
            doNothing().when(preparedStatement).setObject(anyInt(),any());
            doNothing().when(preparedStatement).setInt(anyInt(),anyInt( ));
            when(preparedStatement.executeUpdate()).thenReturn(1);

            MateriaDao materiaDao = new MateriaDao(connectionManager);
            Materia materia = new Materia();
materia.setId(1);
materia.setNombre("Ingles 2");
materia.setCargaHoraria(20);
            materiaDao.actualizar(materia);

            Assert.assertTrue(true);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test(groups = {"pricnipal"})
    public void buscarId(){

        try {
            //Otra forma de hacer un mock
            //Simula el objeto connection manager
            ConnectionManager connectionManager = mock(ConnectionManager.class);
            //Simula el objeto connection
            Connection connection = mock(Connection.class);
            // Simula el ojbeto prepared Statement
            PreparedStatement preparedStatement = mock(PreparedStatement.class);
            //Simula el objeto REsultSet
            ResultSet resultSet = mock(ResultSet.class);
//Simula el retorno de connection
            when(connectionManager.getConnection()).thenReturn(connection);
            //Simula el prepareStatement
            when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
            //Simula el seteo del prepare Statement
            doNothing().when(preparedStatement).setInt(anyInt(),anyInt( ));
            //Simula la ejecucion del prepareStatement
            when(preparedStatement.executeQuery()).thenReturn(resultSet);
            //Simula el retorno del resultSet como verdadero
            when(resultSet.next()).thenReturn(true);
            //Simula la obtencion de datos del REsult Set
            when(resultSet.getInt("id")).thenReturn(2);
            when(resultSet.getString("nombre")).thenReturn("Ingles 4");
            when(resultSet.getInt("carga_horaria")).thenReturn(20);


            MateriaDao materiaDao = new MateriaDao(connectionManager);
            //Se crea un objeto materia para comparar
            Materia materiaEsperada = new Materia();
            materiaEsperada.setId(2);
            materiaEsperada.setNombre("Ingles 4");
            materiaEsperada.setCargaHoraria(20);

            Materia materia = materiaDao.obtenerUno(2);

            //Verifica que si los metodos de un objeto han sido ejecutados y con que valores
verify(preparedStatement).setInt(1,2);
//Compara lo obtenido contra lo esperado
            Assert.assertEquals(materia,materiaEsperada);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void aFastTest() {
        System.out.println("Fast Test");
    }
    }

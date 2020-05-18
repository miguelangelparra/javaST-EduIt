package com.neurosoft.InterfazGrafica.presentacion;


import com.neurosoft.InterfazGrafica.negocio.MateriaBussines;
import com.neurosoft.InterfazGrafica.util.MateriaDuplicadaException;
import com.neurosoft.InterfazGrafica.util.NegocioException;
import com.neurosoft.InterfazGrafica.util.NombreInvalidoException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MateriaUIController {

    private MateriaBussines materiaBussines;

    public void setMateriaBussiness(MateriaBussines materiaBussines) {
        this.materiaBussines = materiaBussines;
    }

    @FXML
    private TextField txtInpNombre;

    @FXML
    private TextField txtInpCargaHoraria;

    @FXML
    private Button btnGrabar;

    @FXML
    private Button btnCancelar;

    @FXML
    void grabarMateria(ActionEvent event) {
        //TODO Validaciones
        String nombre = txtInpNombre.getText();
        try {
            //Validacion nombre no nulo ni vacio
            if (nombre == null || nombre.trim().isEmpty()) {
                //Mostrar alerta
                throw new NombreInvalidoException("nombre no valido");
            }
            Integer cargaHoraria = null;
            cargaHoraria = Integer.valueOf(txtInpCargaHoraria.getText());
            materiaBussines.crearMateria(nombre, cargaHoraria);
            this.borrarCampos();
        } catch (NombreInvalidoException nie) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error");
            alert.setContentText("El nombre de la materia no debe ser nulo");
            alert.showAndWait();
        } catch (NumberFormatException nfe) {
            //Crea una alerta
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error");
            alert.setContentText("La carga horaria debe ser expresada como numero entero");
            alert.showAndWait();
        } catch (MateriaDuplicadaException mde) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error");
            alert.setContentText("Materia Duplicada");
            alert.showAndWait();
        } catch (NegocioException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error");
            alert.setContentText("No fue posible guardar la materia, intente de nuevo");
            alert.showAndWait();
            e.printStackTrace();
        }
    }

    private void borrarCampos() {
        txtInpNombre.setText("");
        txtInpCargaHoraria.setText("");
    }

    public void cancelar(ActionEvent actionEvent) {
        this.borrarCampos();
    }
}

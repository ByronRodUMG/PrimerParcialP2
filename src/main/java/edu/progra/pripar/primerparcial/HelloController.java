package edu.progra.pripar.primerparcial;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    // Botón Salir
    @FXML
    protected void onSalirClick() {
        System.exit(0);
    }

    // Botón Aumentar
    @FXML
    private ProgressBar progressBar;
    private final DoubleProperty progressValue = new SimpleDoubleProperty(0.0);
    @FXML
    protected void onAumentarClick() {
        progressValue.set(progressValue.get() + 0.2);

        if (progressValue.get() > 1.0) {
            progressValue.set(1.0);
        }

        progressBar.setProgress(progressValue.get());
    }

    // ChoiceBox y ComboBox
    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private ComboBox<String> comboBox;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().addAll("Azul", "Rojo", "Verde");
        choiceBox.setValue("Azul");
        comboBox.getItems().addAll("Amarillo", "Negro", "Morado");

        // Link the model class fields to the table columns
        apellidoColumn.setCellValueFactory(cellData -> cellData.getValue().apellidoProperty());
        nombreColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        // Set the data to the TableView
        tableView.setItems(data);
    }

    // Botón Aceptar
    @FXML
    private Circle circleL;
    @FXML
    private Circle circleR;
    @FXML
    protected void onAceptarClick() {
        String selectedColorL = choiceBox.getValue();

        switch (selectedColorL) {
            case "Azul" -> circleL.setFill(Color.BLUE);
            case "Rojo" -> circleL.setFill(Color.RED);
            case "Verde" -> circleL.setFill(Color.GREEN);
        }

        String selectedColorR = comboBox.getValue();

        if (selectedColorR != null) {
            switch (selectedColorR) {
                case "Amarillo" -> circleR.setFill(Color.YELLOW);
                case "Negro" -> circleR.setFill(Color.BLACK);
                case "Morado" -> circleR.setFill(Color.PURPLE);
                default -> circleR.setFill(Color.WHITE);
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alerta!");
            alert.setHeaderText(null);
            alert.setContentText("El valor seleccionado en el ComboBox es nulo, por favor selecciona un valor válido.");
            alert.showAndWait();
        }
    }

    // Tabla
    @FXML
    private TableView<Tabla> tableView;

    @FXML
    private TableColumn<Tabla, String> apellidoColumn;

    @FXML
    private TableColumn<Tabla, String> nombreColumn;

    private final ObservableList<Tabla> data = FXCollections.observableArrayList();

    // Method to add data to the TableView
    public void addData() {
        // Create a new Person object and add it to the data list
        Tabla person1 = new Tabla("Lopez", "Juan");
        Tabla person2 = new Tabla("Gomez", "Maria");
        data.addAll(person1, person2);
    }

    // Botón Añadir
    @FXML
    protected void onAddClick() {
        addData();
    }

    //@FXML
    //private TreeView<String> treeView;
}
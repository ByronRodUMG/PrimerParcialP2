package edu.progra.pripar.primerparcial;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Tabla {
    private final SimpleStringProperty apellido = new SimpleStringProperty("");
    private final SimpleStringProperty nombre = new SimpleStringProperty("");

    public Tabla(String apellido, String nombre) {
        this.apellido.set(apellido);
        this.nombre.set(nombre);
    }

    public StringProperty apellidoProperty() {
        return apellido;
    }

    public StringProperty nombreProperty() {
        return nombre;
    }
}

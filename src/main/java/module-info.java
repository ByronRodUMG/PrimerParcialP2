module edu.progra.pripar.primerparcial {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.progra.pripar.primerparcial to javafx.fxml;
    exports edu.progra.pripar.primerparcial;
}
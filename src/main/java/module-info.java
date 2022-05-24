module com.stapf.campominado {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.stapf.campominado to javafx.fxml;
    exports com.stapf.campominado;
    exports com.stapf.campominado.celula;
    opens com.stapf.campominado.celula to javafx.fxml;
}
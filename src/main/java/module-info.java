module com.example.practicahilosprioridad {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.practicahilosprioridad to javafx.fxml;
    exports com.example.practicahilosprioridad;
}
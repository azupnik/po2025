module org.example.cargui {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.cargui to javafx.fxml;
    exports org.example.cargui;
    exports org.example.model;
    opens org.example.model to javafx.fxml;
}
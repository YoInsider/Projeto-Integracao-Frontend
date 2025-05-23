module com.example.projetointegracaofrontend {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projetointegracaofrontend to javafx.fxml;
    exports com.example.projetointegracaofrontend;
}
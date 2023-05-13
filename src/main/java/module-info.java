module com.example.harrypotterathomeinterface {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens com.example.harrypotterathomeinterface to javafx.fxml;
    exports com.example.harrypotterathomeinterface;
}
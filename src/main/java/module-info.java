module com.example.javafx_y3lec3pr3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires javafx.base;

    opens com.example.javafx_y3lec3pr3 to javafx.fxml;
    exports com.example.javafx_y3lec3pr3;
}
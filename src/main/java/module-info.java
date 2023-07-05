module com.cda.intro2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.cda.intro2 to javafx.fxml;
    exports com.cda.intro2;
    exports com.cda.intro2.controllers;
    opens com.cda.intro2.controllers to javafx.fxml;
}
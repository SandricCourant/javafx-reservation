module com.cda.intro2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;


    opens com.cda.intro2 to javafx.fxml;
    exports com.cda.intro2;
    exports com.cda.intro2.controllers;
    opens com.cda.intro2.controllers to javafx.fxml;
    exports com.cda.intro2.helpers;
    opens com.cda.intro2.helpers to javafx.fxml;
    exports com.cda.intro2.client;
    opens com.cda.intro2.client to javafx.fxml;
}
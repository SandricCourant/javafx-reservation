package com.cda.intro2.controllers;

import com.cda.intro2.AirfrenseApplication;
import javafx.fxml.FXML;

public class MenuController {
    @FXML
    private void clickClose() {
        AirfrenseApplication.close();
    }
    @FXML
    private void clickDashboard() {
        AirfrenseApplication.navigateTo("dashboard");
    }
    @FXML
    public void clickLogin() {
        AirfrenseApplication.navigateTo("login");
    }
    @FXML
    public void clickGetReservations() {
        AirfrenseApplication.navigateTo("listBooking");
    }
    @FXML
    public void clickPostReservation() {
        AirfrenseApplication.navigateTo("createBooking");
    }
    @FXML
    public void clickPutReservation() {
        AirfrenseApplication.navigateTo("editBooking");
    }
    @FXML
    public void clickDeleteReservation() {
        AirfrenseApplication.navigateTo("deleteBooking");
    }
    @FXML
    public void clickGetCategories() {
        AirfrenseApplication.navigateTo("listVehicle");
    }
    @FXML
    public void clickPostCategorie() {
        AirfrenseApplication.navigateTo("createVehicle");
    }
    @FXML
    public void clickPutCategorie() {
        AirfrenseApplication.navigateTo("editVehicle");
    }
    @FXML
    public void clickDeleteCategorie() {
        AirfrenseApplication.navigateTo("deleteVehicle");
    }
    @FXML
    public void clickAbout() {
        AirfrenseApplication.navigateTo("about");
    }
}

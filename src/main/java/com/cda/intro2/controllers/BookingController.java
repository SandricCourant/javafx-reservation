package com.cda.intro2.controllers;

import com.cda.intro2.domain.Booking;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


import static com.cda.intro2.AirfrenseApplication.bookingService;
import static com.cda.intro2.AirfrenseApplication.vehicleService;

public class BookingController {
    @FXML
    private Label IDOutput;
    @FXML
    private TextField nameInput;
    @FXML
    private TextField firstnameInput;
    @FXML
    private TextField startInput;
    @FXML
    private TextField endInput;
    @FXML
    private TextField emailInput;
    @FXML
    private TextField phoneInput;
    @FXML
    private Label nameOutput;
    @FXML
    private Label firstnameOutput;
    @FXML
    private Label startOutput;
    @FXML
    private Label endOutput;
    @FXML
    private Label emailOutput;
    @FXML
    private Label phoneOutput;
    @FXML
    private ComboBox<String> vehicleComboBox;
    @FXML
    private ListView<String> listView;


    public void initialize() {

        //Set items de comboBox
        vehicleComboBox.setItems(vehicleService.getVehicles());

        //Set items de reservationList
        listView.setItems(bookingService.getBookings());
    }
    @FXML
    private void onClickButtonAdd() {
            //Créer un nouveau véhicule avec les inputs
            bookingService.addBooking(firstnameInput.getText(), nameInput.getText(), vehicleService.getVehicle(vehicleComboBox.getSelectionModel().getSelectedIndex()), startInput.getText(), endInput.getText(), emailInput.getText(), phoneInput.getText());

            //clear les inputs
            nameInput.clear();
            firstnameInput.clear();
            emailInput.clear();
            phoneInput.clear();
            startInput.clear();
            endInput.clear();
            vehicleComboBox.getSelectionModel().clearSelection();
    }
    @FXML
    private void onClickList() {
        //récuperer l'index de l'élement selectionné
        int index = listView.getSelectionModel().getSelectedIndex();
        //Récuperer la réservation
        Booking bookingSelected = bookingService.getBooking(index);
        //Set text des textfields
        IDOutput.setText(String.valueOf(index));
        nameInput.setText(bookingSelected.getLastname());
        firstnameInput.setText(bookingSelected.getFirstname());
        phoneInput.setText(bookingSelected.getPhone());
        emailInput.setText(bookingSelected.getEmail());
        startInput.setText(bookingSelected.getStartAt());
        endInput.setText(bookingSelected.getEndAt());
        //set combobox
        vehicleComboBox.getSelectionModel().select(vehicleService.getVehiculeIndex(bookingSelected.getVehicle()));
    }
    @FXML
    private void onClickListD() {
        if(listView.getItems().size() > 0) {
            //récuperer l'index de l'élement selectionné
            int index = listView.getSelectionModel().getSelectedIndex();
            //Récuperer la réservation
            Booking bookingSelected = bookingService.getBooking(index);
            //Set text des labels
            IDOutput.setText(String.valueOf(index));
            nameOutput.setText(bookingSelected.getLastname());
            firstnameOutput.setText(bookingSelected.getFirstname());
            phoneOutput.setText(bookingSelected.getPhone());
            emailOutput.setText(bookingSelected.getEmail());
            startOutput.setText(bookingSelected.getStartAt());
            endOutput.setText(bookingSelected.getEndAt());
            //set combobox
            vehicleComboBox.getSelectionModel().select(vehicleService.getVehiculeIndex(bookingSelected.getVehicle()));
        }
    }
    @FXML
    private void onClickButtonModify(){
        String indexStr = IDOutput.getText();
        //Si un élément de sélectionné, ID != ""
        if(!indexStr.equals("")){
            //Modifier dataList sur l'index avec un nouveau vehicule
            bookingService.setBooking(Integer.parseInt(indexStr), firstnameInput.getText(), nameInput.getText(), vehicleService.getVehicle(vehicleComboBox.getSelectionModel().getSelectedIndex()), startInput.getText(), endInput.getText(), emailInput.getText(), phoneInput.getText());

        }
    }
    @FXML
    private void onClickButtonDelete(){
        String indexStr = IDOutput.getText();
        //Si un élément de sélectionné, ID != ""
        if(!indexStr.equals("")){
            //Supprimer de dataList le vehicule sur l'index
            bookingService.removeBooking(Integer.parseInt(indexStr));
        }
        //clear les outputs
        IDOutput.setText("");
        nameOutput.setText("");
        firstnameOutput.setText("");
        emailOutput.setText("");
        phoneOutput.setText("");
        startOutput.setText("");
        endOutput.setText("");
        vehicleComboBox.getSelectionModel().clearSelection();
    }
    @FXML
    private void onClickSelectBox() {
        if(listView.getItems().size() > 0 && listView.getSelectionModel().getSelectedIndex() >= 0 && listView.getSelectionModel().getSelectedIndex() < listView.getItems().size()) vehicleComboBox.getSelectionModel().select(vehicleService.getVehiculeIndex(bookingService.getBooking(listView.getSelectionModel().getSelectedIndex()).getVehicle()));
    }

}

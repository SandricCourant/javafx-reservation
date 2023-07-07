package com.cda.intro2.controllers;

import com.cda.intro2.Container;
import com.cda.intro2.domain.Booking;
import com.cda.intro2.services.BookingService;
import com.cda.intro2.services.ObservableStorageService;
import com.cda.intro2.services.VehicleService;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import static com.cda.intro2.AirfrenseApplication.*;

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
    private BookingService bookingService;
    private ObservableStorageService observableStorageService;
    private VehicleService vehicleService;
    private final String BOOKING = "booking";


    public void initialize() {
        Container container = Container.getInstance();
        bookingService = container.get(BookingService.class);
        vehicleService = container.get(VehicleService.class);
        observableStorageService = container.get(ObservableStorageService.class);
        //Set items de comboBox
        vehicleComboBox.setItems(observableStorageService.getList("vehicle"));

        //Set items de reservationList
        listView.setItems(observableStorageService.getList(BOOKING));
    }
    @FXML
    private void onClickButtonAdd() {
            //Créer un nouveau véhicule avec les inputs
            Booking newBooking = bookingService.addBooking(firstnameInput.getText(), nameInput.getText(), vehicleService.getVehicle(vehicleComboBox.getSelectionModel().getSelectedIndex()), startInput.getText(), endInput.getText(), emailInput.getText(), phoneInput.getText());
            observableStorageService.add(BOOKING, newBooking.toString());
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
        vehicleComboBox.getSelectionModel().select(vehicleService.getVehicleIndex(bookingSelected.getVehicle()));
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
            vehicleComboBox.getSelectionModel().select(vehicleService.getVehicleIndex(bookingSelected.getVehicle()));
        }
    }
    @FXML
    private void onClickButtonModify(){
        String indexStr = IDOutput.getText();
        //Si un élément de sélectionné, ID != ""
        if(!indexStr.equals("")){
            int index = Integer.parseInt(indexStr);
            //Modifier dataList sur l'index avec un nouveau vehicule
            Booking booking = bookingService.setBooking(index, firstnameInput.getText(), nameInput.getText(), vehicleService.getVehicle(vehicleComboBox.getSelectionModel().getSelectedIndex()), startInput.getText(), endInput.getText(), emailInput.getText(), phoneInput.getText());
            observableStorageService.set(BOOKING, index, booking.toString());
        }
    }
    @FXML
    private void onClickButtonDelete(){
        String indexStr = IDOutput.getText();
        //Si un élément de sélectionné, ID != ""
        if(!indexStr.equals("")){
            int index = Integer.parseInt(indexStr);
            //Supprimer de dataList la reservation sur l'index
            bookingService.removeBooking(index);
            observableStorageService.remove(BOOKING, index);
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
        int sizeView = listView.getItems().size();
        int indexView = listView.getSelectionModel().getSelectedIndex();
        
        if(indexView >= 0 && indexView < sizeView) vehicleComboBox.getSelectionModel().select(vehicleService.getVehicleIndex(bookingService.getBooking(indexView).getVehicle()));
    }

}

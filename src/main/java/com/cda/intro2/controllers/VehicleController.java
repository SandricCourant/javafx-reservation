package com.cda.intro2.controllers;

import com.cda.intro2.Container;
import com.cda.intro2.domain.Vehicle;
import com.cda.intro2.services.ObservableStorageService;

import com.cda.intro2.services.VehicleService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class VehicleController {

    @FXML
    private ListView<String> listView;
    @FXML
    private TextField nameInput;
    @FXML
    private TextField licenseInput;
    @FXML
    private Label IDOutput;
    @FXML
    private Label nameOutput;
    @FXML
    private Label licenseOutput;
    private final String VEHICLE = "vehicle";
    private ObservableStorageService observableStorageService;
    private VehicleService vehicleService;

    public void initialize() {
        Container container = Container.getInstance();
        observableStorageService = container.get(ObservableStorageService.class);
        vehicleService = container.get(VehicleService.class);
        listView.setItems(observableStorageService.getList(VEHICLE));
    }
    @FXML
    private void clickButtonAdd() {
        //Créer un nouveau véhicule avec les inputs
        if(!nameInput.getText().equals("") && !licenseInput.getText().equals("")){
            Vehicle newVehicle = vehicleService.addVehicle(nameInput.getText(), licenseInput.getText());
            observableStorageService.add(VEHICLE, newVehicle.toString());
            //clear les inputs
            nameInput.clear();
            licenseInput.clear();
        }

    }
    @FXML
    private void clickButtonModify() {
        String indexStr = IDOutput.getText();
        //Si un élément de sélectionné, ID != ""
        if(!indexStr.equals("")){
            int index = Integer.parseInt(indexStr);
            Vehicle vehicle = vehicleService.modifyVehicle(index, nameInput.getText(), licenseInput.getText());
            observableStorageService.set(VEHICLE, index, vehicle.toString());
        }
    }
    @FXML
    private void clickList() {
        //récuperer l'index de l'élement selectionné
        int index = listView.getSelectionModel().getSelectedIndex();
        //Récuperer le véhicule
        Vehicle vehicleSelected = vehicleService.getVehicle(index);
        //Set text des textfields
        IDOutput.setText(String.valueOf(index));
        nameInput.setText(vehicleSelected.getName());
        licenseInput.setText(vehicleSelected.getLicense());
    }
    @FXML
    private void clickButtonDelete(){
        String indexStr = IDOutput.getText();
        //Si un élément de sélectionné, ID != ""
        if(!indexStr.equals("")){
            int index = Integer.parseInt(indexStr);
            //Supprimer de dataList le vehicule sur l'index
            vehicleService.removeVehicle(index);
            observableStorageService.remove(VEHICLE, index);
        }
        //clear les outputs
        IDOutput.setText("");
        nameOutput.setText("");
        licenseOutput.setText("");
    }

    @FXML
    private void clickListD() {
        //Si la liste n'est pas vide
        if(listView.getItems().size() > 0){
            //récuperer l'index de l'élement selectionné
            int index = listView.getSelectionModel().getSelectedIndex();
            //Récuperer le véhicule
            Vehicle vehicleSelected = vehicleService.getVehicle(index);
            //Set text des labels
            IDOutput.setText(String.valueOf(index));
            nameOutput.setText(vehicleSelected.getName());
            licenseOutput.setText(vehicleSelected.getLicense());
        }

    }

}

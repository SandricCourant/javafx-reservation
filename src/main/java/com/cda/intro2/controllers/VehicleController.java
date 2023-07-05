package com.cda.intro2.controllers;

import com.cda.intro2.domain.Vehicle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


import static com.cda.intro2.AirfrenseApplication.vehicleService;


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

    public void initialize() {
        listView.setItems(vehicleService.getVehicles());
    }
    @FXML
    private void clickButtonAdd() {
        //Créer un nouveau véhicule avec les inputs
        if(!nameInput.getText().equals("") && !licenseInput.getText().equals("")){
            vehicleService.addVehicle(nameInput.getText(), licenseInput.getText());
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
            vehicleService.modifyVehicle(Integer.parseInt(indexStr), nameInput.getText(), licenseInput.getText());
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
            //Supprimer de dataList le vehicule sur l'index
            vehicleService.removeVehicle(Integer.parseInt(indexStr));
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

package com.cda.intro2;

import com.cda.intro2.repositories.BookingRepository;
import com.cda.intro2.repositories.VehicleRepository;
import com.cda.intro2.repositories.impl.BookingRepositoryImpl;
import com.cda.intro2.repositories.impl.VehicleRepositoryImpl;
import com.cda.intro2.services.BookingService;
import com.cda.intro2.services.ObservableStorageService;
import com.cda.intro2.services.VehiculeService;
import com.cda.intro2.services.impl.BookingServiceImpl;
import com.cda.intro2.services.impl.ObservableStorageServiceImpl;
import com.cda.intro2.services.impl.VehicleServiceImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class AirfrenseApplication extends Application {

    private static final HashMap<String, Pane> screenByName = new HashMap<>();
    private static Stage stage;
    private static Scene scene;
    private static final String USER = "Sandric";
    public static void close() {
        stage.close();
    }
    public static void navigateTo(String name) {
        scene.setRoot(screenByName.get(name));
    }

    public static VehiculeService vehicleService;
    public static BookingService bookingService;
    public static ObservableStorageService observableStorageService;

    @Override
    public void start(Stage stage) throws IOException {
        //Init Providers
        VehicleRepository vehicleRepository = new VehicleRepositoryImpl();
        BookingRepository bookingRepository = new BookingRepositoryImpl();
        //Init Services
        vehicleService = new VehicleServiceImpl(vehicleRepository);
        bookingService = new BookingServiceImpl(bookingRepository, vehicleService.getVehicle(0), vehicleService.getVehicle(1));
        observableStorageService = new ObservableStorageServiceImpl();
        //Get Stage
        AirfrenseApplication.stage = stage;
        //Put commons
        screenByName.put("dashboard", FXMLLoader.load(getClass().getResource("dashboard.fxml")));
        screenByName.put("login", FXMLLoader.load(getClass().getResource("login.fxml")));
        screenByName.put("about", FXMLLoader.load(getClass().getResource("about.fxml")));
        //Put Bookings
        screenByName.put("createBooking", FXMLLoader.load(getClass().getResource("booking/create.fxml")));
        screenByName.put("deleteBooking", FXMLLoader.load(getClass().getResource("booking/delete.fxml")));
        screenByName.put("editBooking", FXMLLoader.load(getClass().getResource("booking/edit.fxml")));
        screenByName.put("listBooking", FXMLLoader.load(getClass().getResource("booking/list.fxml")));
        //Put Vehicles
        screenByName.put("createVehicle", FXMLLoader.load(getClass().getResource("vehicle/create.fxml")));
        screenByName.put("deleteVehicle", FXMLLoader.load(getClass().getResource("vehicle/delete.fxml")));
        screenByName.put("editVehicle", FXMLLoader.load(getClass().getResource("vehicle/edit.fxml")));
        screenByName.put("listVehicle", FXMLLoader.load(getClass().getResource("vehicle/list.fxml")));
        //Create scene
        scene = new Scene(screenByName.get("dashboard"), 720, 620);
        //Set stage with scene
        stage.setTitle("Airfrense de " + USER);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
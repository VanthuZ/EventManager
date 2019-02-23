package pl.home.EventManager.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.RequiredArgsConstructor;
import pl.home.EventManager.controller.EventManagerController;
import pl.home.EventManager.controller.VerticalBoxControler;

import java.io.IOException;

public class EventView {

    private Stage primaryStage;

    public EventView(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void loadView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/VerticalBox.fxml"));
        fxmlLoader.load();
        Parent root = fxmlLoader.getRoot();
        primaryStage.setTitle("Event Manager");
        primaryStage.setScene(new Scene(root));
        VerticalBoxControler verticalBoxControler = fxmlLoader.getController();
        verticalBoxControler.setEventView(this);
        primaryStage.show();
    }

    public void loadNewEventView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/EventManager.fxml"));
        fxmlLoader.load();
        Parent root = fxmlLoader.getRoot();
        Stage secondStage = new Stage();
        secondStage.setTitle("Zarządzanie wydarzeniem");
        secondStage.setScene(new Scene(root));
        EventManagerController eventManagerController = fxmlLoader.getController();
        eventManagerController.setEventView(this);
        secondStage.show();

    }


}

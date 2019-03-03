package pl.home.EventManager.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.home.EventManager.controller.EventManagerController;
import pl.home.EventManager.controller.VerticalBoxControler;
import pl.home.EventManager.model.Event;
import java.io.IOException;


public class EventView {

    private Stage primaryStage;
    private ObservableList<Event> eventObservableList = FXCollections.observableArrayList();

    public EventView(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public ObservableList<Event> getEventObservableList() {
        return eventObservableList;
    }

    public void setEventObservableList(ObservableList<Event> eventObservableList) {
        this.eventObservableList = eventObservableList;
    }

    public void loadView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/VerticalBox.fxml"));
        fxmlLoader.load();
        Parent root = fxmlLoader.getRoot();
        primaryStage.setTitle("Event Manager");
        primaryStage.setScene(new Scene(root));
        VerticalBoxControler verticalBoxControler = fxmlLoader.getController();
        primaryStage.setResizable(false);
        verticalBoxControler.setEventView(this);
        primaryStage.show();
    }

    public void loadNewEventView(Event selectedEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/EventManager.fxml"));
        fxmlLoader.load();
        Parent root = fxmlLoader.getRoot();
        Stage secondStage = new Stage();
        secondStage.initOwner(primaryStage);
        secondStage.setTitle("Event Manager");
        secondStage.setScene(new Scene(root));
        secondStage.setResizable(false);
        EventManagerController eventManagerController = fxmlLoader.getController();
        eventManagerController.setEventView(this, selectedEvent);
        secondStage.showAndWait();
    }
}

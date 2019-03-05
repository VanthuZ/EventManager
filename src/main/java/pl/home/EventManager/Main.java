package pl.home.EventManager;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.home.EventManager.controller.SaveAndReadData;
import pl.home.EventManager.view.EventView;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main extends Application {
    EventView eventView;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        eventView = new EventView(primaryStage);
        SaveAndReadData.loadData(eventView);
        eventView.loadView();
    }
    @Override
    public void stop() throws IOException {
        SaveAndReadData.saveData(eventView);
    }

}

package pl.home.EventManager;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.home.EventManager.view.EventView;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        EventView eventView = new EventView(primaryStage);
        eventView.loadView();


    }
}

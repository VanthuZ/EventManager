package pl.home.EventManager.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import pl.home.EventManager.model.Event;
import pl.home.EventManager.view.EventView;
import java.io.File;
import java.io.IOException;

public class SaveAndReadData {

    private static File file = new File("events.json");
    private static  ObjectMapper mapper = new ObjectMapper();

    public static void saveData(EventView eventView) throws IOException {
        mapper.writeValue(file, eventView.getEventObservableList());
    }

    public static void loadData(EventView eventView) throws IOException {
        eventView.setEventObservableList(FXCollections.observableArrayList(
                mapper.readValue(file, Event[].class)));
    }
}

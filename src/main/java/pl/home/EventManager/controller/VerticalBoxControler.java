package pl.home.EventManager.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import pl.home.EventManager.model.Event;
import pl.home.EventManager.view.EventView;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class VerticalBoxControler implements Initializable {

    @FXML
    private Button btAdd;
    @FXML
    private Button btEdit;
    @FXML
    private Button btDelete;
    @FXML
    private Label lbName;
    @FXML
    private Label lbDate;
    @FXML
    private Label lbCity;
    @FXML
    private Label lbTicketPrice;
    @FXML
    private CheckBox cbIsBoughtTicket;
    @FXML
    private TableView<Event> tvEvents;
    @FXML
    private TableColumn<Event, String> columnName;
    @FXML
    private TableColumn<Event, String> columnDate;

    private EventView eventView;

    public void setEventView(EventView eventView){
        this.eventView = eventView;
        tvEvents.setItems(eventView.getEventObservableList());

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
      columnName.setCellValueFactory(c ->  c.getValue().nameProperty());
      

    }



    public void newBTpress(ActionEvent actionEvent) throws IOException {
       eventView.loadNewEventView(null);
    }
}

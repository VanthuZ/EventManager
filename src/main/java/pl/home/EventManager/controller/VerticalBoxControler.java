package pl.home.EventManager.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import pl.home.EventManager.model.Event;
import pl.home.EventManager.view.EventView;

import java.io.IOException;
import java.net.URL;
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

    private EventView eventView;

    public void setEventView(EventView eventView){
        this.eventView = eventView;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }



    public void newBTpress(ActionEvent actionEvent) throws IOException {
        eventView.loadNewEventView();
    }
}

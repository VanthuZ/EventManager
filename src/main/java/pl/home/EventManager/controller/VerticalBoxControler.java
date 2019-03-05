package pl.home.EventManager.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import pl.home.EventManager.model.Event;
import pl.home.EventManager.view.EventView;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
    @FXML
    private Label daysToEvent;
    private EventView eventView;

    public void setEventView(EventView eventView){
        this.eventView = eventView;
        tvEvents.setItems(eventView.getEventObservableList());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      columnName.setCellValueFactory(c ->  c.getValue().nameProperty());
      columnDate.setCellValueFactory(c -> c.getValue().dataStringProperty());
    }

    public void viewEvent() {

        Event tmpEvent = tvEvents.getSelectionModel().getSelectedItem();
        if(tmpEvent != null){
            lbName.setText(tmpEvent.getName());
            lbDate.setText(tmpEvent.getDataString());
            lbCity.setText(tmpEvent.getCity());
            lbTicketPrice.setText(Integer.toString(tmpEvent.getTicketPrice()));
            cbIsBoughtTicket.setSelected(tmpEvent.isBoughtTicket());
            daysToEvent.setText(Long.toString(
                    ChronoUnit.DAYS.between(
                            LocalDate.now(), LocalDate.parse(tmpEvent.getDataString()))));
        }

    }

    public void newBTpress() throws IOException {
        eventView.loadNewEventView(null);
    }

    public void BTeditpress() throws IOException {

        eventView.loadNewEventView(tvEvents.getSelectionModel().getSelectedItem());
    }

    public void BTdelpress() {
        eventView.getEventObservableList().remove(tvEvents.getSelectionModel().getSelectedItem());
        clearView();
    }

    private void  clearView(){
        lbName.setText("");
        lbDate.setText("");
        lbTicketPrice.setText("");
        lbCity.setText("");
        cbIsBoughtTicket.setSelected(false);
    }
}
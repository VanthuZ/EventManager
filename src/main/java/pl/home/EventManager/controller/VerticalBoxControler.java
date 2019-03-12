package pl.home.EventManager.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
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

        Event currentEvent = tvEvents.getSelectionModel().getSelectedItem();
        if(currentEvent != null){
            lbName.setText(currentEvent.getName());
            lbDate.setText(currentEvent.getDataString());
            lbCity.setText(currentEvent.getCity());
            lbTicketPrice.setText(Integer.toString(currentEvent.getTicketPrice()));
            cbIsBoughtTicket.setSelected(currentEvent.isBoughtTicket());
            daysToEvent.setText(Long.toString(calculateDaysToEvent(currentEvent)));
            colorNumberOfDaysToEvent(currentEvent);
        }

    }

    private long calculateDaysToEvent(Event currentEvent){
        return  ChronoUnit.DAYS.between(
                LocalDate.now(), LocalDate.parse(currentEvent.getDataString()));
    }

    private void colorNumberOfDaysToEvent(Event curentEvent){
        if (calculateDaysToEvent(curentEvent) <= 3){
            daysToEvent.setTextFill(Color.RED);
        }else{
           daysToEvent.setTextFill(Color.BLACK);
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
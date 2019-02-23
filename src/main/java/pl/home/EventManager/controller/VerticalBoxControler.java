package pl.home.EventManager.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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
    private TableColumn<Event, LocalDate> columnDate;

    private EventView eventView;

    public void setEventView(EventView eventView){
        this.eventView = eventView;
        tvEvents.setItems(eventView.getEventObservableList());

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
      columnName.setCellValueFactory(c ->  c.getValue().nameProperty());
      columnDate.setCellValueFactory(c -> c.getValue().getDate());

    }



    public void newBTpress(ActionEvent actionEvent) throws IOException {
       eventView.loadNewEventView(null);
    }

    public void viewEvent() {

        Event tmpEvent = tvEvents.getSelectionModel().getSelectedItem();
        if(tmpEvent != null){
            lbName.setText(tmpEvent.getName());
            lbDate.setText(tmpEvent.getDate().getValue().toString());
            lbCity.setText(tmpEvent.getCity());
            lbTicketPrice.setText(Integer.toString(tmpEvent.getTicketPrice()));
            cbIsBoughtTicket.setSelected(tmpEvent.isBoughtTicket());
        }

    }
}

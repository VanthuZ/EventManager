package pl.home.EventManager.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.home.EventManager.model.Event;
import pl.home.EventManager.view.EventView;

import java.time.LocalDate;


public class EventManagerController {

    @FXML
    private Button btSave;
    @FXML
    private Button btCancel;
    @FXML
    private TextField tfName;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField tfCity;
    @FXML
    private TextField tfTicketPrice;
    @FXML
    private CheckBox cbIsBoughtTicket;

    private EventView eventView;
    private Event currentEvent;

    public void setEventView(EventView eventView, Event currentEvent){
        this.eventView = eventView;
        this.currentEvent = new Event("", LocalDate.parse("2000-01-01"),10, false);


    }



    public void btCancelPress() {
        Stage currentStage = (Stage)btCancel.getScene().getWindow();
        currentStage.close();
    }

    public void btSavePress() {


       currentEvent.setName(tfName.getText());
       currentEvent.setDate(datePicker.getValue());
       currentEvent.setCity(tfCity.getText());
       currentEvent.setTicketPrice(Integer.parseInt(tfTicketPrice.getText()));
       currentEvent.setBoughtTicket(cbIsBoughtTicket.isSelected());

       eventView.getEventObservableList().add(currentEvent);

       btCancelPress();

    }
}

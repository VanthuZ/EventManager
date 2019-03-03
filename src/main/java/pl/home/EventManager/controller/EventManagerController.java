package pl.home.EventManager.controller;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pl.home.EventManager.model.Event;
import pl.home.EventManager.view.EventView;
import java.time.LocalDate;

public class EventManagerController {

    @FXML
    private Label lbTitle;
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
    private boolean editMode;
    private EventView eventView;
    private Event currentEvent;

    public void setEventView(EventView eventView, Event currentEvent){

        this.eventView = eventView;
        if(currentEvent == null) {
            editMode = false;
            this.currentEvent = new Event("", 10, false, "");
        }else{
            editMode = true;
            setCurrentEvent(currentEvent);
            this.currentEvent = currentEvent;
        }
    }

    private void setCurrentEvent(Event currentEvent){
        lbTitle.setText("Edycja wydarzenia");
        tfName.setText(currentEvent.getName());
        tfCity.setText(currentEvent.getCity());
        tfTicketPrice.setText(Integer.toString(currentEvent.getTicketPrice()));
        datePicker.setValue(LocalDate.parse(currentEvent.getDataString()));
        cbIsBoughtTicket.setSelected(currentEvent.isBoughtTicket());
    }

    public void btCancelPress() {
        Stage currentStage = (Stage)btCancel.getScene().getWindow();
        currentStage.close();
    }

    public void btSavePress() {

        currentEvent.setName(tfName.getText());
        currentEvent.setCity(tfCity.getText());
        currentEvent.setTicketPrice(Integer.parseInt(tfTicketPrice.getText()));
        currentEvent.setBoughtTicket(cbIsBoughtTicket.isSelected());
        currentEvent.setDataString(datePicker.getValue().toString());

        if(!editMode) eventView.getEventObservableList().add(currentEvent);

        btCancelPress();
    }
}

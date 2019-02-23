package pl.home.EventManager.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.home.EventManager.view.EventView;


public class EventManagerController {

    @FXML
    private Button btSave;
    @FXML
    private Button btCancel;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfDate;
    @FXML
    private TextField tfCity;
    @FXML
    private TextField tfTicketPrice;
    @FXML
    private CheckBox cbIsBoughtTicket;

    private EventView eventView;

    public void setEventView(EventView eventView){
        this.eventView = eventView;
    }


    public void btCancelPress(ActionEvent actionEvent) {
        Stage currentStage = (Stage)btCancel.getScene().getWindow();
        currentStage.close();
    }

    public void btSavePress(ActionEvent actionEvent) {

    }
}

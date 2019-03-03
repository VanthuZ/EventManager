package pl.home.EventManager.model;



import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.DatePicker;
import lombok.*;

import java.time.LocalDate;

@Data
@ToString
@EqualsAndHashCode

public class Event {

    private StringProperty name;
    private String city;
    private int ticketPrice;
    private boolean isBoughtTicket;
   // private ObjectProperty<LocalDate> date = new SimpleObjectProperty<>();
    private StringProperty dataString;

    public Event(String name, int ticketPrice, boolean  isBoughtTicket, String dataString){
        this.name = new SimpleStringProperty(name);
        //this.date = new SimpleObjectProperty<>();
        this.ticketPrice = ticketPrice;
        this.isBoughtTicket = isBoughtTicket;
        this.dataString = new SimpleStringProperty(dataString);
    }

    public Event(){
        this.name = new SimpleStringProperty();
        this.city = "";
        this.ticketPrice = 0;
        this.isBoughtTicket = false;
        this.dataString = new SimpleStringProperty();

    }

    public String getName(){
       return name.get();
    }

    public StringProperty nameProperty(){
        return name;
    }


    public void setName(String name){
        this.name.set(name);
    }


    public String getDataString(){
        return dataString.get();
    }

    public StringProperty dataStringProperty(){
        return dataString;
    }


    public void setDataString(String dataString){
        this.dataString.set(dataString);
    }



   /* public ObjectProperty<LocalDate> dateProperty() {
        return date ;
    }*/


   /* public void setDate(LocalDate date) {
        dateProperty().set(date);
    }*/


}

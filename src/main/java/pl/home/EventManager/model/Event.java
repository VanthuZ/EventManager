package pl.home.EventManager.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.*;

@Data
@ToString
@EqualsAndHashCode
public class Event {

    private StringProperty name;
    private String city;
    private int ticketPrice;
    private boolean isBoughtTicket;
    private StringProperty dataString;

    public Event(String name, int ticketPrice, boolean  isBoughtTicket, String dataString){
        this.name = new SimpleStringProperty(name);
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
}

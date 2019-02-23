package pl.home.EventManager.model;



import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.DatePicker;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Event {

    private StringProperty name;
    private LocalDate date;
    private String city;
    private int ticketPrice;
    private boolean isBoughtTicket;

    public Event(String name, LocalDate date, int ticketPrice, boolean  isBoughtTicket){
        this.name = new SimpleStringProperty(name);
        this.date = date;
        this.ticketPrice = ticketPrice;
        this.isBoughtTicket = isBoughtTicket;

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




}

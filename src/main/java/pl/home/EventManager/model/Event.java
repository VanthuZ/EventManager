package pl.home.EventManager.model;



import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
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
    private String city;
    private int ticketPrice;
    private boolean isBoughtTicket;
    private ObjectProperty<LocalDate> date = new SimpleObjectProperty<>();

    public Event(String name, LocalDate date, int ticketPrice, boolean  isBoughtTicket){
        this.name = new SimpleStringProperty(name);
        this.date = new SimpleObjectProperty<>();
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


    public ObjectProperty<LocalDate> dateProperty() {
        return date ;
    }


    public final void setDate(LocalDate date) {
        dateProperty().set(date);
    }




}

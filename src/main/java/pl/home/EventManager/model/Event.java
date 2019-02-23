package pl.home.EventManager.model;



import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Event {

    private String name;
    private LocalDate date;
    private String city;
    private int ticketPrice;
    private boolean isBoughtTicket;



}

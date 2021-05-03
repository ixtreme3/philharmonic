package com.bd.philharmonic.Backend.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "contest")
public class Contest extends Event{

    private int number_of_participants;

    public Contest(String name, int visit_price, LocalDate start_date, LocalDate end_date, int number_of_participants) {
        super(name, visit_price, start_date, end_date);
        this.number_of_participants = number_of_participants;
    }

    public Contest() {

    }

    public int getNumber_of_participants() {
        return number_of_participants;
    }

    public void setNumber_of_participants(int number_of_participants) {
        this.number_of_participants = number_of_participants;
    }

    @Override
    public String toString() {
        return "Contest{" +
                "number_of_participants=" + number_of_participants +
                '}';
    }
}

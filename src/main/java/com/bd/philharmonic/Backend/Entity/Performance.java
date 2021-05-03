package com.bd.philharmonic.Backend.Entity;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "performance")
public class Performance extends Event {

    private int intermission_length;

    public Performance(String name, int visit_price, LocalDate start_date, LocalDate end_date, int intermission_length) {
        super(name, visit_price, start_date, end_date);
        this.intermission_length = intermission_length;
    }

    public Performance() {

    }

    public int getIntermission_length() {
        return intermission_length;
    }

    public void setIntermission_length(int intermission_length) {
        this.intermission_length = intermission_length;
    }

    @Override
    public String toString() {
        return "Performance{" +
                "intermission_length=" + intermission_length +
                '}';
    }

}

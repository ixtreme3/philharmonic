package com.bd.philharmonic.Backend.Entity;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "performance")
public class Performance extends Event {

    private String performance_theme;

    public Performance(String name, int visit_price, LocalDate start_date, LocalDate end_date, String performance_theme) {
        super(name, visit_price, start_date, end_date);
        this.performance_theme = performance_theme;
    }

    public Performance() {

    }

    public String getPerformance_theme() {
        return performance_theme;
    }

    public void setPerformance_theme(String performance_theme) {
        this.performance_theme = performance_theme;
    }

    @Override
    public String toString() {
        return "Performance{" +
                "performance_theme='" + performance_theme + '\'' +
                '}';
    }

}

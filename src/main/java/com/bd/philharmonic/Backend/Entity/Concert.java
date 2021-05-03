package com.bd.philharmonic.Backend.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "concert")
public class Concert extends Event {

    private boolean live_music;

    public Concert(String name, int visit_price, LocalDate start_date, LocalDate end_date, boolean live_music) {
        super(name, visit_price, start_date, end_date);
        this.live_music = live_music;
    }

    public Concert() {

    }

    public boolean isLive_music() {
        return live_music;
    }

    public void setLive_music(boolean live_music) {
        this.live_music = live_music;
    }

    public String get_LiveMusic_String(){
        if (isLive_music()) {
            return "✓";
        } else return "✗";
    }

    @Override
    public String toString() {
        return "Concert{" +
                "live_music=" + live_music +
                '}';
    }

}

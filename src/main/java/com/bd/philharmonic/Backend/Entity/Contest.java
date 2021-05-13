package com.bd.philharmonic.Backend.Entity;

import com.bd.philharmonic.Backend.Service.ContestService;
import com.bd.philharmonic.Backend.Service.PrizewinnerService;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "contest")
public class Contest extends Event {

    private int number_of_participants;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "contest")
    @NotFound(action = NotFoundAction.IGNORE)
    private Set<Prizewinner> prizewinners = new HashSet<>();

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

    public Set<Prizewinner> getPrizewinners() {
        return prizewinners;
    }

    public void setPrizewinners(Set<Prizewinner> prizewinners) {
        this.prizewinners = prizewinners;
    }

    public String getWinnerNameByPlace(ContestService contestService, Integer place) {
        List<String> contestPrizewinners = contestService.getContestPrizewinners_String(this.getName());
        for (String next : contestPrizewinners) {
            if (next.contains(place.toString())){
                return next.split(",")[0];
            }
        }
        return "";
    }

    public void setWinnerByPlace(PrizewinnerService prizewinnerService, String name, Integer place) {
        if (name.isEmpty()) {
            return;
        }

        Artist artistToInsert = null;
        for (Artist artist : artists) {
            if (artist.getFull_name().equals(name)) {
                artistToInsert = artist;
                break;
            }
        }
        if (artistToInsert == null) {
            return;
        }

        if (prizewinners.size() == 0) {
            addPrizewinner(prizewinnerService, place, this, artistToInsert);
        }

        if (prizewinners.size() > 0) {
            for (Prizewinner prizewinner : prizewinners) {
                if (prizewinner.getArtist().getFull_name().equals(name)) {
                    return;
                }
            }
            for (Prizewinner prizewinner : prizewinners) {
                if (prizewinner.getPlace() == place) {
                    addPrizewinner(prizewinnerService, place, this, artistToInsert);
                    prizewinnerService.delete(prizewinner);
                    break;
                }
            }
        }
    }

    private void addPrizewinner(PrizewinnerService prizewinnerService, Integer place, Contest contest, Artist artist) {
        Prizewinner prizewinner = new Prizewinner();
        prizewinner.setPlace(place);
        prizewinner.setContest(contest);
        prizewinner.setArtist(artist);
        prizewinnerService.save(prizewinner);
    }

    @Override
    public String toString() {
        return "Contest{" +
                "number_of_participants=" + number_of_participants +
                '}';
    }

}

package com.bd.philharmonic.Backend.Entity;

import com.bd.philharmonic.Backend.Service.ContestService;
import com.bd.philharmonic.Backend.Service.PrizewinnerService;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "contest")
public class Contest extends Event {

    private int number_of_participants;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "contest")
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
        List<String> contestPrizewinners = contestService.getContestPrizewinners(this.getName());
        for (String next : contestPrizewinners) {
            if (next.contains(place.toString())){
                return next.split(",")[0];
            }
        }
        return "";
    }

    public void setWinnerByPlace(PrizewinnerService prizewinnerService, String name, Integer place) {
        for (Prizewinner next : prizewinners) {
            if (next.getPlace() == place && !next.getArtist().getFull_name().isEmpty()) { // указанное место уже занято другим человеком
                prizewinnerService.delete(next);
                for (Artist artist : artists) {
                    if (artist.getFull_name().equals(name)) {
                        Prizewinner prizewinner = new Prizewinner();
                        prizewinner.setPlace(place);
                        prizewinner.setContest(this);
                        prizewinner.setArtist(artist);
                        prizewinnerService.save(prizewinner);
                    }
                }
                return; // данного артиста нет в нашей базе
            } else  { // место пусто, просто добавляем нового
                for (Artist artist : artists) {
                    if (artist.getFull_name().equals(name)) {
                        Prizewinner prizewinner = new Prizewinner();
                        prizewinner.setPlace(place);
                        prizewinner.setContest(this);
                        prizewinner.setArtist(artist);
                        prizewinnerService.save(prizewinner);
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Contest{" +
                "number_of_participants=" + number_of_participants +
                '}';
    }

}

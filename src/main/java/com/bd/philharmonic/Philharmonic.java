package com.bd.philharmonic;

import com.bd.philharmonic.Backend.Entity.Event;
import com.bd.philharmonic.Backend.Repository.EventRepository;
import com.bd.philharmonic.Backend.Repository.HouseOfCultureRepository;
import com.bd.philharmonic.Backend.Repository.TheaterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class Philharmonic {
    public static void main(String[] args) {
        SpringApplication.run(Philharmonic.class, args);
    }

    @Bean
    public CommandLineRunner loadData(EventRepository eventRepository, TheaterRepository theaterRepository, HouseOfCultureRepository houseOfCultureRepository) {
        return (args) -> {
            Event event = new Event();
            event.setId_event(4L);
            event.setEvent_type("Выступление");
            event.setName("Вечерний live");
            event.setStart_date(LocalDate.now());
            event.setEnd_date(LocalDate.parse("2021-06-03"));

            eventRepository.save(event);
        };
    }

}

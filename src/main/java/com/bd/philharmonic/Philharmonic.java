package com.bd.philharmonic;

import com.bd.philharmonic.Backend.Entity.Event;
import com.bd.philharmonic.Backend.Repository.ContestRepository;
import com.bd.philharmonic.Backend.Repository.EventRepository;
import com.bd.philharmonic.Backend.Repository.PrizewinnerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class Philharmonic {
    public static void main(String[] args) {
        SpringApplication.run(Philharmonic.class, args);
    }

    @Bean
    public CommandLineRunner loadData(EventRepository eventRepository) {
        return (args) -> {

            List<Object[]> events = eventRepository.getEventsByCulturalBuildingName("Глобус");
            System.out.println(Arrays.toString(events.get(0)));

        };
    }
}

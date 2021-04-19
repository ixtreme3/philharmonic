package com.bd.philharmonic;

import com.bd.philharmonic.Backend.Repository.EventRepository;
import com.bd.philharmonic.Backend.Repository.HouseOfCultureRepository;
import com.bd.philharmonic.Backend.Repository.TheaterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Philharmonic {
    public static void main(String[] args) {
        SpringApplication.run(Philharmonic.class, args);
    }

    @Bean
    public CommandLineRunner loadData(EventRepository eventRepository, TheaterRepository theaterRepository, HouseOfCultureRepository houseOfCultureRepository) {
        return (args) -> {
//            List<Event> eventsByCulturalBuildingName = eventRepository.getEventsByCulturalBuildingName(2);
//            for (Event event : eventsByCulturalBuildingName) {
//                System.out.println(event);
//                if (event instanceof Event){
//                    System.out.println("yes");
//                } else System.out.println("no");
//            }
        };
    }
}

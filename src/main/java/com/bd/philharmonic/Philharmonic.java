package com.bd.philharmonic;

import com.bd.philharmonic.Backend.Entity.Event;
import com.bd.philharmonic.Backend.Repository.EventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Philharmonic {
    public static void main(String[] args) {
        SpringApplication.run(Philharmonic.class, args);
    }

//    @Bean
//    public CommandLineRunner loadData(EventRepository eventRepository) {
//        return (args) -> {
//            Event event = new Event();
//        };
//    }

}

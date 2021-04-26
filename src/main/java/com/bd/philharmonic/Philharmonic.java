package com.bd.philharmonic;

import com.bd.philharmonic.Backend.Entity.*;
import com.bd.philharmonic.Backend.Repository.*;
import com.bd.philharmonic.Backend.Service.ArtistService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.transaction.Transactional;
import java.util.Set;


@SpringBootApplication
public class Philharmonic {
    public static void main(String[] args) {
        SpringApplication.run(Philharmonic.class, args);
    }

    @Bean
    public CommandLineRunner loadData(CulturalBuildingRepository culturalBuildingRepository, ArtistRepository artistRepository) {
        return (args) -> {

        };
    }
}

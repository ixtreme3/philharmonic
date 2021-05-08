package com.bd.philharmonic;

import com.bd.philharmonic.Backend.Repository.ContestRepository;
import com.bd.philharmonic.Backend.Repository.PrizewinnerRepository;
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
    public CommandLineRunner loadData(ContestRepository contestRepository, PrizewinnerRepository prizewinnerRepository) {
        return (args) -> {

//            Contest contest = contestRepository.findById(13L).get();
//            System.out.println(contest.getWinnerNameByPlace(contestRepository, 1));

        };
    }
}

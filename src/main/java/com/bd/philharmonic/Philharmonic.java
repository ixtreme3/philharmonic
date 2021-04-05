package com.bd.philharmonic;

import com.bd.philharmonic.CulturalBuilding.Cinema.Cinema;
import com.bd.philharmonic.CulturalBuilding.Cinema.CinemaRepository;
import com.bd.philharmonic.CulturalBuilding.CulturalBuilding;
import com.bd.philharmonic.CulturalBuilding.CulturalBuildingRepository;
import com.bd.philharmonic.CulturalBuilding.Theater.Theater;
import com.bd.philharmonic.CulturalBuilding.Theater.TheaterRepository;
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
    public CommandLineRunner loadData(TheaterRepository theaterRepository, CinemaRepository cinemaRepository) {
        return (args) -> {

            // create
            // Такая запись приведет к вставке соответствующих строчек в обе таблицы (как в дочернюю так и в родительскую) :
            Theater theater = new Theater("Большой театр",
                    "Театр",
                    "Театральная пл., 1",
                    1500,
                    "Большая центральная полукруглая сцена",
                    20
            );
            theaterRepository.save(theater);

            Cinema cinema = new Cinema("Киносити",
                    "Кинотеатр",
                    "ул. Фрунзе, 238",
                    275,
                    27,
                    "3D"
            );
            cinemaRepository.save(cinema);

            // delete (by id)
            // Такая запись приведет к удалению строчек из обеих таблиц (как из дочерней так и из родительской) :
            theaterRepository.deleteById(1L);
            cinemaRepository.deleteById(4L);

            // update (by id)
            Theater updateTheater = theaterRepository.findById(3L).orElseThrow(() -> new IllegalStateException("Theater with id " + 3L + " not found"));
            updateTheater.setCapacity(222222222);
            theaterRepository.save(updateTheater);


        };
    }

}

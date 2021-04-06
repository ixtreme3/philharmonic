package com.bd.philharmonic;

import com.bd.philharmonic.CulturalBuilding.HouseOfCulture.HouseOfCulture;
import com.bd.philharmonic.CulturalBuilding.HouseOfCulture.HouseOfCultureRepository;
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
    public CommandLineRunner loadData(TheaterRepository theaterRepository, HouseOfCultureRepository houseOfCultureRepository) {
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

            HouseOfCulture houseOfCulture = new HouseOfCulture("Областной Дом Народного Творчества",
                    "Дом культуры",
                    "Каинская, 5",
                    45,
                    "Дом народного творчества");
            houseOfCultureRepository.save(houseOfCulture);

            // delete (by id)
            // Такая запись приведет к удалению строчек из обеих таблиц (как из дочерней так и из родительской) :
            theaterRepository.deleteById(1L);
            houseOfCultureRepository.deleteById(4L);

            // update (by id)
            Theater updateTheater = theaterRepository.findById(3L).orElseThrow(() -> new IllegalStateException("Theater with id " + 3L + " not found"));
            updateTheater.setCapacity(222222222);
            theaterRepository.save(updateTheater);


        };
    }

}

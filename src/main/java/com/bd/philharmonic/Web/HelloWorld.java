package com.bd.philharmonic.Web;

import com.bd.philharmonic.CulturalBuilding.Cinema.Cinema;
import com.bd.philharmonic.CulturalBuilding.Cinema.CinemaRepository;
import com.bd.philharmonic.CulturalBuilding.CulturalBuilding;
import com.bd.philharmonic.CulturalBuilding.CulturalBuildingRepository;
import com.bd.philharmonic.CulturalBuilding.Theater.Theater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(path = "api/v1")
public class HelloWorld {

//    private final CulturalBuildingRepository culturalBuildingRepository;
//
//    private final CinemaRepository cinemaRepository;
//
//    @Autowired
//    public HelloWorld(CulturalBuildingRepository culturalBuildingRepository, CinemaRepository cinemaRepository) {
//        this.culturalBuildingRepository = culturalBuildingRepository;
//        this.cinemaRepository = cinemaRepository;
//    }
//
//    public void fillTable() {
//
//        CulturalBuilding culturalBuilding = new CulturalBuilding();
//        culturalBuilding.setName("Большой театр");
//        culturalBuilding.setAddress("Театральная пл., 1");
//        culturalBuilding.setCapacity(1500);
//        culturalBuilding.setType_of_building("Театр");
//
//        Theater theater = new Theater();
//        theater.setScene("Большая центральная полукруглая сцена");
//        theater.setNumber_of_balconies(20);
//
//        culturalBuildingRepository.save(culturalBuilding);
//        cinemaRepository.save(theater);
//
//    }

    @GetMapping
    public String hello() {
//        fillTable();
        return "Hello world!";
    }

}

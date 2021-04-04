package com.bd.philharmonic.Web;

import com.bd.philharmonic.CulturalBuilding.Cinema.Cinema;
import com.bd.philharmonic.CulturalBuilding.Cinema.CinemaRepository;
import com.bd.philharmonic.CulturalBuilding.CulturalBuilding;
import com.bd.philharmonic.CulturalBuilding.CulturalBuildingRepository;
import com.bd.philharmonic.CulturalBuilding.Theater.Theater;
import com.bd.philharmonic.CulturalBuilding.Theater.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(path = "api/v1")
public class HelloWorld {

    private final CulturalBuildingRepository culturalBuildingRepository;

    private final TheaterRepository theaterRepository;

    @Autowired
    public HelloWorld(CulturalBuildingRepository culturalBuildingRepository, TheaterRepository theaterRepository) {
        this.culturalBuildingRepository = culturalBuildingRepository;
        this.theaterRepository = theaterRepository;
    }

    public void fillTable() {

        CulturalBuilding culturalBuilding = new CulturalBuilding();
        culturalBuilding.setName("Большой театр");
        culturalBuilding.setAddress("Театральная пл., 1");
        culturalBuilding.setCapacity(1500);
        culturalBuilding.setType_of_building("Театр");

        Theater theater = new Theater();
        theater.setScene("Большая центральная полукруглая сцена");
        theater.setNumber_of_balconies(20);


        culturalBuildingRepository.save(culturalBuilding);
        theaterRepository.save(theater);

    }

    @GetMapping
    public String hello() {
        fillTable();
        return "Hello world!";
    }

}

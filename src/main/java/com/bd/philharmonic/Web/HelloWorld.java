package com.bd.philharmonic.Web;

import com.bd.philharmonic.CulturalBuilding.CulturalBuilding;
import com.bd.philharmonic.CulturalBuilding.CulturalBuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(path = "api/v1")
public class HelloWorld {

//    private final CulturalBuildingRepository culturalBuildingRepository;
//
//    @Autowired
//    public HelloWorld(CulturalBuildingRepository culturalBuildingRepository) {
//        this.culturalBuildingRepository = culturalBuildingRepository;
//    }
//
//    public void fillTable() {
//
//        CulturalBuilding culturalBuilding = new CulturalBuilding();
//        culturalBuilding.setName("Moscow Theater");
//        culturalBuilding.setAddress("Red Square 1");
//        culturalBuilding.setCapacity(500);
//        culturalBuilding.setType_of_building("Theater");
//
//        culturalBuildingRepository.save(culturalBuilding);
//    }

    @GetMapping
    public String hello() {
//        fillTable();
        return "Hello world!";
    }

}

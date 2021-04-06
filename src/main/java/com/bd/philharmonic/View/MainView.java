package com.bd.philharmonic.View;

import com.bd.philharmonic.CulturalBuilding.CulturalBuilding;
import com.bd.philharmonic.CulturalBuilding.CulturalBuildingRepository;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.Collection;

@Route
public class MainView extends VerticalLayout {

    private final CulturalBuildingRepository culturalBuildingRepository;

    private final Grid<CulturalBuilding> grid;

    public MainView(CulturalBuildingRepository culturalBuildingRepository) {
        this.culturalBuildingRepository = culturalBuildingRepository;
        this.grid = new Grid<>(CulturalBuilding.class);
        add(grid);
        listCulturalBuildings();
    }

    private void listCulturalBuildings() {
        grid.setItems((Collection<CulturalBuilding>) culturalBuildingRepository.findAll());
    }


}

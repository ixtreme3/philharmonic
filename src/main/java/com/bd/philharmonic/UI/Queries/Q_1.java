package com.bd.philharmonic.UI.Queries;

import com.bd.philharmonic.Backend.Entity.HouseOfCulture;
import com.bd.philharmonic.Backend.Entity.Theater;
import com.bd.philharmonic.Backend.Service.HouseOfCultureService;
import com.bd.philharmonic.Backend.Service.TheaterService;
import com.bd.philharmonic.UI.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Route(value = "/queries/1", layout = MainLayout.class)
@PageTitle("Query №1")
public class Q_1 extends VerticalLayout {

    private final TheaterService theaterService;

    private final HouseOfCultureService houseOfCultureService;

    private final TextField fieldTypeOfBuilding = new TextField();

    private final TextField fieldCapacity = new TextField();

    public Q_1(TheaterService theaterService, HouseOfCultureService houseOfCultureService) {
        this.theaterService = theaterService;
        this.houseOfCultureService = houseOfCultureService;
        setSizeFull();
        addClassName("query_1_view");

        Grid<Object> grid = new Grid<>();
        add(getToolBar(), grid);
    }

    private HorizontalLayout getToolBar() {
        fieldTypeOfBuilding.setPlaceholder("Enter type of building...");
        fieldTypeOfBuilding.setClearButtonVisible(true);

        fieldCapacity.setPlaceholder("Enter minimum capacity...");
        fieldCapacity.setClearButtonVisible(true);

        Button queryButton = new Button("Query", click -> createAndSetProperGrid(fieldTypeOfBuilding.getValue(), fieldCapacity.getValue()));
        HorizontalLayout toolbar = new HorizontalLayout(fieldTypeOfBuilding, fieldCapacity, queryButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void createAndSetProperGrid(String type, String count_str) {
        if (!count_str.isEmpty() && (type.equals("Театр") || type.equals("театр"))) {
            int count = Integer.parseInt(count_str);
            Grid<Theater> grid = new Grid<>(Theater.class);
            configureTheaterGrid(grid);
            grid.setItems(theaterService.getTheaterByCapacityGreaterThanEqual(count));
            replace(getComponentAt(1), grid);
        } else if (type.equals("Театр") || type.equals("театр")) {
            Grid<Theater> newGrid = new Grid<>(Theater.class);
            configureTheaterGrid(newGrid);
            setTheaterGrid(type, newGrid);
            replace(getComponentAt(1), newGrid);
        }

        if (!count_str.isEmpty() && (type.equals("Дом культуры") || type.equals("дом культуры"))) {
            int count = Integer.parseInt(count_str);
            Grid<HouseOfCulture> grid = new Grid<>(HouseOfCulture.class);
            configureHouseOfCultureGrid(grid);
            grid.setItems(houseOfCultureService.getHouseOfCultureByCapacityGreaterThanEqual(count));
            replace(getComponentAt(1), grid);
        } else if (type.equals("Дом культуры") || type.equals("дом культуры")) {
            Grid<HouseOfCulture> grid = new Grid<>(HouseOfCulture.class);
            configureHouseOfCultureGrid(grid);
            setHouseOfCultureGrid(type, grid);
            replace(getComponentAt(1), grid);
        }
    }

    private void configureTheaterGrid(Grid<Theater> grid) {
        grid.addClassName("query-grid");
        grid.setColumns("name", "address", "capacity", "scene", "number_of_balconies");
        grid.getColumnByKey("number_of_balconies").setHeader("Number of balconies");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        grid.setSizeFull();
    }

    private void configureHouseOfCultureGrid(Grid<HouseOfCulture> grid) {
        grid.addClassName("query-grid");
        grid.setColumns("name", "address", "capacity", "type");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        grid.setSizeFull();
    }

    private void setTheaterGrid(String type, Grid<Theater> grid) {
        List<Theater> theaters = (List<Theater>) theaterService.findAll();
        grid.setItems(Objects.requireNonNullElse(theaters, Collections.emptyList()));
    }

    private void setHouseOfCultureGrid(String type, Grid<HouseOfCulture> grid) {
        List<HouseOfCulture> housesOfCulture = (List<HouseOfCulture>) houseOfCultureService.findAll();
        grid.setItems(Objects.requireNonNullElse(housesOfCulture, Collections.emptyList()));
    }
}

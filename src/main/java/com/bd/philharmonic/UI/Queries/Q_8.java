package com.bd.philharmonic.UI.Queries;

import com.bd.philharmonic.Backend.Entity.Event;
import com.bd.philharmonic.Backend.Repository.CulturalBuildingRepository;
import com.bd.philharmonic.Backend.Service.EventService;
import com.bd.philharmonic.UI.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.Collections;

@Route(value = "/queries/8", layout = MainLayout.class)
@PageTitle("Query №8")
public class Q_8 extends VerticalLayout {

    private final EventService eventService;

    private final CulturalBuildingRepository culturalBuildingRepository;

    private final Grid<Event> grid;

    private final TextField fieldBuildingName = new TextField();

    public Q_8(EventService eventService, CulturalBuildingRepository culturalBuildingRepository) {
        this.eventService = eventService;
        this.culturalBuildingRepository = culturalBuildingRepository;
        addClassName("query_8_view");
        this.grid = new Grid<>(Event.class);

        configureGrid();
        add(getToolBar(), grid);
        setSizeFull();

        grid.setItems(Collections.emptyList());
    }

    private HorizontalLayout getToolBar() {
        fieldBuildingName.setPlaceholder("Enter name of building...");
        fieldBuildingName.setClearButtonVisible(true);
        fieldBuildingName.setWidth("300px");

        Button queryButton = new Button("Query", click -> listEvents(resolveName(fieldBuildingName.getValue())));
        HorizontalLayout toolbar = new HorizontalLayout(fieldBuildingName, queryButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private int resolveName(String value) {
        Integer idByName = culturalBuildingRepository.getIdByName(value);
        if (idByName != null) {
            return idByName;
        }
        return 0;
    }

    private void configureGrid() {
        grid.addClassName("query_8_grid");
        grid.setColumns("name", "visit_price", "start_date", "end_date");
        grid.getColumnByKey("visit_price").setHeader("Visit price");
        grid.getColumnByKey("start_date").setHeader("Start date");
        grid.getColumnByKey("end_date").setHeader("End date");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        setSizeFull();
    }

    private void listEvents(int param) {
        if (param == 0) {
            grid.setItems(Collections.emptyList());
        } else grid.setItems(eventService.getEventsByCulturalBuildingName(param));
    }
}

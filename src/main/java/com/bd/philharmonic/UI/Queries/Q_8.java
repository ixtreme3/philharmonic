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

    private final Grid<Object[]> grid;

    private final TextField fieldBuildingName = new TextField();

    public Q_8(EventService eventService) {
        this.eventService = eventService;
        addClassName("query_8_view");
        this.grid = new Grid<>();

        configureGrid();
        add(getToolBar(), grid);
        setSizeFull();

        grid.setItems(Collections.emptyList());
    }

    private HorizontalLayout getToolBar() {
        fieldBuildingName.setPlaceholder("Enter name of building...");
        fieldBuildingName.setClearButtonVisible(true);
        fieldBuildingName.setWidth("300px");

        Button queryButton = new Button("Query", click -> listEvents(fieldBuildingName.getValue()));
        HorizontalLayout toolbar = new HorizontalLayout(fieldBuildingName, queryButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void configureGrid() {
        grid.addClassName("query_8_grid");
        grid.addColumn(objects -> objects[2]).setHeader("Name");
        grid.addColumn(objects -> objects[3]).setHeader("Visit price");
        grid.addColumn(objects -> objects[4]).setHeader("Start date");
        grid.addColumn(objects -> objects[5]).setHeader("End date");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        setSizeFull();
    }

    private void listEvents(String param) {
        if (param.isEmpty() ) {
            grid.setItems(Collections.emptyList());
        } else grid.setItems(eventService.getEventsByCulturalBuildingName(param));
    }
}

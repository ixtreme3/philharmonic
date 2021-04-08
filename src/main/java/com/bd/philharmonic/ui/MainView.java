package com.bd.philharmonic.ui;

import com.bd.philharmonic.backend.Entity.Theater;
import com.bd.philharmonic.backend.Service.TheaterService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;


@Route
public class MainView extends VerticalLayout {

    private TheaterService theaterService;

    private final Grid<Theater> grid;

    private final TextField filterText = new TextField();

    public MainView(TheaterService theaterService) {
        this.theaterService = theaterService;
        this.grid = new Grid<>(Theater.class);

        setSizeFull();

        configureGrid();
        configureFilter();
        listTheaters();

        add(filterText, grid);
    }

    private void configureFilter() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> listTheaters());

    }

    private void configureGrid() {
        grid.addClassName("theater-grid");
        setSizeFull();
        grid.setColumns("name", "address", "capacity", "scene", "number_of_balconies");
        grid.getColumnByKey("number_of_balconies").setHeader("Number of balconies");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private void listTheaters() {
        grid.setItems(theaterService.findAll(filterText.getValue()));
    }
}

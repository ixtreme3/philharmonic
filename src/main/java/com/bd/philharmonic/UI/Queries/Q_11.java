package com.bd.philharmonic.UI.Queries;

import com.bd.philharmonic.Backend.Service.OrganizerService;
import com.bd.philharmonic.UI.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;
import java.util.*;

@Route(value = "/queries/11", layout = MainLayout.class)
@PageTitle("Query №11")
public class Q_11 extends VerticalLayout {

    private final OrganizerService organizerService;

    private final Grid<Object[]> grid;

    private DatePicker startDate;

    private DatePicker endDate;

    public Q_11(OrganizerService organizerService) {
        this.organizerService = organizerService;
        addClassName("query_11_view");
        this.grid = new Grid<>();

        configureGrid();
        add(getToolBar(), grid);
        setSizeFull();

        grid.setItems(Collections.emptyList());
    }

    private HorizontalLayout getToolBar() {
        startDate = new DatePicker("Start date");
        endDate = new DatePicker("End date");
        startDate.setAutoOpen(false);
        endDate.setAutoOpen(false);
        startDate.setClearButtonVisible(true);
        endDate.setClearButtonVisible(true);

        Button queryButton = new Button("Query", click -> handleClick(startDate.getValue(), endDate.getValue()));
        HorizontalLayout toolbar = new HorizontalLayout(startDate, endDate, queryButton);
        toolbar.setAlignItems(Alignment.BASELINE);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void configureGrid() {
        grid.addClassName("query_11_grid");
        grid.addColumn(objects -> objects[0]).setHeader("Organizer");
        grid.addColumn(objects -> objects[1]).setHeader("Events count");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        setSizeFull();
    }

    private void handleClick(LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null) {
            grid.setItems(Collections.emptyList());
            return;
        }
        listOrganizers(startDate, endDate);
    }

    private void listOrganizers(LocalDate startDate, LocalDate endDate) {
        List<Object[]> organizers = organizerService.getEventOrganizersAndTheirEventCount(startDate, endDate);
        if (organizers.isEmpty()) {
            grid.setItems(Collections.emptyList());
        } else grid.setItems(organizers);
    }

}

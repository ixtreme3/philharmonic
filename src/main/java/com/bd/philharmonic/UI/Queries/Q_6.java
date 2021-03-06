package com.bd.philharmonic.UI.Queries;

import com.bd.philharmonic.Backend.Service.EventService;
import com.bd.philharmonic.UI.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Route(value = "/queries/6", layout = MainLayout.class)
@PageTitle("Query №6")
public class Q_6 extends VerticalLayout {

    private final EventService eventService;

    private final Grid<Object[]> grid;

    private DatePicker startDate;

    private DatePicker endDate;

    private final TextField fieldOrganizerName = new TextField();

    public Q_6(EventService eventService) {
        this.eventService = eventService;
        addClassName("query_6_view");
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

        fieldOrganizerName.setPlaceholder("Enter name of organizer...");
        fieldOrganizerName.setClearButtonVisible(true);
        fieldOrganizerName.setWidth("300px");

        Button queryButtonDate = new Button("Query", click -> handleClickDate(startDate.getValue(), endDate.getValue()));
        Button queryButtonOrganizer = new Button("Query", click -> handleClickOrganizer(fieldOrganizerName.getValue()));
        HorizontalLayout toolbar = new HorizontalLayout(startDate, endDate, queryButtonDate, fieldOrganizerName, queryButtonOrganizer);
        toolbar.setAlignItems(Alignment.BASELINE);
        toolbar.addClassName("toolbar");

        return toolbar;
    }

    private void configureGrid() {
        grid.addClassName("query_6_grid");
        grid.addColumn(objects -> objects[2]).setHeader("Name");
        grid.addColumn(objects -> objects[3]).setHeader("Visit price");
        grid.addColumn(objects -> objects[4]).setHeader("Start date");
        grid.addColumn(objects -> objects[5]).setHeader("End date");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        setSizeFull();
    }

    private void listOrganizerEvents(String param) {
        List<Object[]> eventList = eventService.getEventsByOrganizerName(param);
        if (eventList.isEmpty()) {
            grid.setItems(Collections.emptyList());
        } else grid.setItems(eventList);
    }

    private void listDateEvents(LocalDate startDate, LocalDate endDate) {
        List<Object[]> eventList = eventService.getEventsBetweenDates(startDate, endDate);
        if (eventList.isEmpty()) {
            grid.setItems(Collections.emptyList());
        } else grid.setItems(eventList);
    }

    private void handleClickDate(LocalDate startDate, LocalDate endDate) {
        fieldOrganizerName.setValue("");
        if (startDate == null || endDate == null) {
            grid.setItems(Collections.emptyList());
            return;
        }
        listDateEvents(startDate, endDate);
    }

    private void handleClickOrganizer(String param) {
        startDate.setValue(null);
        endDate.setValue(null);
        listOrganizerEvents(param);
    }

}
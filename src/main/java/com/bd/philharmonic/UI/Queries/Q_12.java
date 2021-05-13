package com.bd.philharmonic.UI.Queries;

import com.bd.philharmonic.Backend.Service.CulturalBuildingService;
import com.bd.philharmonic.UI.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Route(value = "/queries/12", layout = MainLayout.class)
@PageTitle("Query №12")
public class Q_12 extends VerticalLayout {

    private final CulturalBuildingService culturalBuildingService;

    private final Grid<Object[]> grid;

    private DatePicker startDate;

    private DatePicker endDate;

    public Q_12(CulturalBuildingService culturalBuildingService) {
        this.culturalBuildingService = culturalBuildingService;
        addClassName("query_12_view");
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
        toolbar.setAlignItems(FlexComponent.Alignment.BASELINE);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void configureGrid() {
        grid.addClassName("query_12_grid");
        grid.addColumn(objects -> objects[0]).setHeader("Building");
        grid.addColumn(objects -> objects[1]).setHeader("Event");
        grid.addColumn(objects -> objects[2]).setHeader("Start date");
        grid.addColumn(objects -> objects[3]).setHeader("End date");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        setSizeFull();
    }

    private void handleClick(LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null) {
            grid.setItems(Collections.emptyList());
            return;
        }
        listBuildingsAndEvents(startDate, endDate);
    }

    private void listBuildingsAndEvents(LocalDate startDate, LocalDate endDate) {
        List<Object[]> list = culturalBuildingService.getCulturalBuildingsAndRelatedEventsWithinGivenTimePeriod(startDate, endDate);
        if (list.isEmpty()) {
            grid.setItems(Collections.emptyList());
        } else grid.setItems(list);
    }

}

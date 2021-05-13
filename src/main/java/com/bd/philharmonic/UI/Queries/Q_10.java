package com.bd.philharmonic.UI.Queries;

import com.bd.philharmonic.Backend.Entity.Artist;
import com.bd.philharmonic.Backend.Service.ArtistService;
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

@Route(value = "/queries/10", layout = MainLayout.class)
@PageTitle("Query №10")
public class Q_10 extends VerticalLayout {

    private final ArtistService artistService;

    private final Grid<Artist> grid;

    private DatePicker startDate;

    private DatePicker endDate;

    public Q_10(ArtistService artistService) {
        this.artistService = artistService;
        addClassName("query_10_view");
        this.grid = new Grid<>(Artist.class);

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
        grid.addClassName("query_10_grid");
        grid.setColumns("full_name", "age", "gender");
        grid.getColumnByKey("full_name").setHeader("Full name");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        setSizeFull();
    }

    private void handleClick(LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null) {
            grid.setItems(Collections.emptyList());
            return;
        }
        listArtists(startDate, endDate);
    }

    private void listArtists(LocalDate startDate, LocalDate endDate) {
        List<Artist> artistList = artistService.getArtistsNotParticipatingInContestsWithinGivenTimePeriod(startDate, endDate);
        if (artistList.isEmpty()) {
            grid.setItems(Collections.emptyList());
        } else grid.setItems(artistList);
    }

}

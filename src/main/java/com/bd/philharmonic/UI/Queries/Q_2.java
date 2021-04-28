package com.bd.philharmonic.UI.Queries;

import com.bd.philharmonic.Backend.Entity.Artist;
import com.bd.philharmonic.Backend.Service.ArtistService;
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

@Route(value = "/queries/2", layout = MainLayout.class)
@PageTitle("Query №2")
public class Q_2 extends VerticalLayout {

    private final ArtistService artistService;

    private final Grid<Artist> grid;

    private final TextField fieldGenreName = new TextField();

    public Q_2(ArtistService artistService) {
        this.artistService = artistService;
        addClassName("query_2_view");
        this.grid = new Grid<>(Artist.class);

        configureGrid();
        add(getToolBar(), grid);
        setSizeFull();

        grid.setItems(Collections.emptyList());
    }

    private HorizontalLayout getToolBar() {
        fieldGenreName.setPlaceholder("Enter name of genre...");
        fieldGenreName.setClearButtonVisible(true);

        Button queryButton = new Button("Query", click -> listEvents(fieldGenreName.getValue()));
        HorizontalLayout toolbar = new HorizontalLayout(fieldGenreName, queryButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void configureGrid() {
        grid.addClassName("query_2_grid");
        grid.setColumns("full_name", "age", "gender");
        grid.getColumnByKey("full_name").setHeader("Full name");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        setSizeFull();
    }

    private void listEvents(String param) {
        List<Artist> artistList = artistService.getArtistsByGenre(param);
        if (artistList.isEmpty()) {
            grid.setItems(Collections.emptyList());
        } else grid.setItems(artistList);
    }
}

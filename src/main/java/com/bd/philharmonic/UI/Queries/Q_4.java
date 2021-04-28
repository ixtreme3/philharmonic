package com.bd.philharmonic.UI.Queries;

import com.bd.philharmonic.Backend.Entity.Artist;
import com.bd.philharmonic.Backend.Service.ArtistService;
import com.bd.philharmonic.UI.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.Collections;
import java.util.List;

@Route(value = "/queries/4", layout = MainLayout.class)
@PageTitle("Query №4")
public class Q_4 extends VerticalLayout {

    private final ArtistService artistService;

    private final Grid<Artist> grid;

    public Q_4(ArtistService artistService) {
        this.artistService = artistService;
        addClassName("query_4_view");
        this.grid = new Grid<>(Artist.class);

        configureGrid();
        add(grid);
        setSizeFull();

        listArtist();
    }

    private void configureGrid() {
        grid.addClassName("query_3_grid");
        grid.setColumns("full_name", "age", "gender");
        grid.getColumnByKey("full_name").setHeader("Full name");
        grid.addColumn(Artist::getGenres_String).setHeader("Genres");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        setSizeFull();
    }

    private void listArtist() {
        List<Artist> artistList = artistService.getArtistWithMoreThanOneGenre();
        if (artistList.isEmpty()) {
            grid.setItems(Collections.emptyList());
        } else grid.setItems(artistList);
    }
}

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

@Route(value = "/queries/3", layout = MainLayout.class)
@PageTitle("Query №3")
public class Q_3 extends VerticalLayout {

    private final ArtistService artistService;

    private final Grid<Artist> grid;

    private final TextField fieldImpresarioName = new TextField();

    public Q_3(ArtistService artistService) {
        this.artistService = artistService;
        addClassName("query_3_view");
        this.grid = new Grid<>(Artist.class);

        configureGrid();
        add(getToolBar(), grid);
        setSizeFull();

        grid.setItems(Collections.emptyList());
    }

    private HorizontalLayout getToolBar() {
        fieldImpresarioName.setPlaceholder("Enter name of impresario...");
        fieldImpresarioName.setClearButtonVisible(true);
        fieldImpresarioName.addClassName("name_button");
        fieldImpresarioName.setWidth("300px");

        Button queryButton = new Button("Query", click -> listEvents(fieldImpresarioName.getValue()));
        HorizontalLayout toolbar = new HorizontalLayout(fieldImpresarioName, queryButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void configureGrid() {
        grid.addClassName("query_3_grid");
        grid.setColumns("full_name", "age", "gender");
        grid.getColumnByKey("full_name").setHeader("Full name");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        setSizeFull();
    }

    private void listEvents(String param) {
        List<Artist> artistList = artistService.getArtistsByImpresario(param);
        if (artistList.isEmpty()) {
            grid.setItems(Collections.emptyList());
        } else grid.setItems(artistList);
    }
}

package com.bd.philharmonic.UI.Queries;

import com.bd.philharmonic.Backend.Entity.Impresario;
import com.bd.philharmonic.Backend.Service.ImpresarioService;
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

@Route(value = "/queries/5", layout = MainLayout.class)
@PageTitle("Query №5")
public class Q_5 extends VerticalLayout {

    private final ImpresarioService impresarioService;

    private final Grid<Impresario> grid;

    private final TextField fieldArtistName = new TextField();

    public Q_5(ImpresarioService impresarioService) {
        this.impresarioService = impresarioService;
        addClassName("query_5_view");
        this.grid = new Grid<>(Impresario.class);

        configureGrid();
        add(getToolBar(), grid);
        setSizeFull();

        grid.setItems(Collections.emptyList());
    }

    private HorizontalLayout getToolBar() {
        fieldArtistName.setPlaceholder("Enter name of artist...");
        fieldArtistName.setClearButtonVisible(true);
        fieldArtistName.setWidth("300px");

        Button queryButton = new Button("Query", click -> listEvents(fieldArtistName.getValue()));
        HorizontalLayout toolbar = new HorizontalLayout(fieldArtistName, queryButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void configureGrid() {
        grid.addClassName("query_5_grid");
        grid.setColumns("full_name", "age", "gender");
        grid.getColumnByKey("full_name").setHeader("Full name");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        setSizeFull();
    }

    private void listEvents(String param) {
        List<Impresario> impresarioList = impresarioService.getImpresariosByArtist(param);
        if (impresarioList.isEmpty()) {
            grid.setItems(Collections.emptyList());
        } else grid.setItems(impresarioList);
    }
}

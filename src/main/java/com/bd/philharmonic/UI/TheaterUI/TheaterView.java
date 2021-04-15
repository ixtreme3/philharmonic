package com.bd.philharmonic.UI.TheaterUI;

import com.bd.philharmonic.Backend.Entity.Theater;
import com.bd.philharmonic.Backend.Service.TheaterService;
import com.bd.philharmonic.UI.MainLayout;
import com.bd.philharmonic.UI.TheaterUI.TheaterForm;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "/theaters", layout = MainLayout.class)
@PageTitle("Theaters | Vaadin CRM")
public class TheaterView extends VerticalLayout {

    private final TheaterService theaterService;

    private final Grid<Theater> grid;

    private final TextField filterText = new TextField();

    private final TheaterForm theaterForm;

    public TheaterView(TheaterService theaterService) {
        this.theaterService = theaterService;
        addClassName("theater-view");
        this.grid = new Grid<>(Theater.class);

        configureGrid();

        theaterForm = new TheaterForm();
        theaterForm.addListener(TheaterForm.SaveEvent.class, this::saveTheater);
        theaterForm.addListener(TheaterForm.DeleteEvent.class, this:: deleteTheater);
        theaterForm.addListener(TheaterForm.CloseEvent.class, e -> closeEditor());

        Div content = new Div(grid, theaterForm);
        content.addClassName("content");
        content.setSizeFull();

        add(getToolBar(), content);
        listTheaters();
        closeEditor();
    }

    private void deleteTheater(TheaterForm.DeleteEvent theater) {
        theaterService.delete(theater.getTheater());
        listTheaters();
        closeEditor();
    }

    private void saveTheater(TheaterForm.SaveEvent evt) {
        theaterService.save(evt.getTheater());
        listTheaters();
        closeEditor();
    }


    private HorizontalLayout getToolBar() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> listTheaters());

        Button addTheaterButton = new Button("Add theater", click -> addTheater());

        HorizontalLayout toolbar = new HorizontalLayout(filterText, addTheaterButton);
        toolbar.addClassName("toolbar");

        return toolbar;
    }

    private void addTheater() {
        grid.asSingleSelect().clear();
        editTheater(new Theater());
    }

    private void configureGrid() {
        grid.addClassName("theater-grid");
        setSizeFull();
        grid.setColumns("name", "address", "capacity", "scene", "number_of_balconies");
        grid.getColumnByKey("number_of_balconies").setHeader("Number of balconies");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));

        grid.asSingleSelect().addValueChangeListener(evt -> editTheater(evt.getValue()));
    }

    private void editTheater(Theater theater) {
        if (theater == null) {
            closeEditor();
        } else {
            theaterForm.setTheater(theater);
            theaterForm.setVisible(true);
            addClassName("editing");
        }
    }

    private void closeEditor() {
        theaterForm.setTheater(null);
        theaterForm.setVisible(false);
        removeClassName("editing");
    }

    private void listTheaters() {
        grid.setItems(theaterService.findAll(filterText.getValue()));
    }
}

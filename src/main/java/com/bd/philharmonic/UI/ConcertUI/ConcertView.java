package com.bd.philharmonic.UI.ConcertUI;

import com.bd.philharmonic.Backend.Entity.Concert;
import com.bd.philharmonic.Backend.Service.ArtistService;
import com.bd.philharmonic.Backend.Service.ConcertService;
import com.bd.philharmonic.Backend.Service.CulturalBuildingService;
import com.bd.philharmonic.Backend.Service.OrganizerService;
import com.bd.philharmonic.UI.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.Arrays;

@Route(value = "/concerts", layout = MainLayout.class)
@PageTitle("Concerts")
public class ConcertView extends VerticalLayout {

    private final ConcertService concertService;

    private final Grid<Concert> grid;

    private final TextField filterText = new TextField();

    private final ConcertForm concertForm;

    public ConcertView(ConcertService concertService, ArtistService artistService, OrganizerService organizerService,
                       CulturalBuildingService culturalBuildingService) {
        this.concertService = concertService;
        this.grid = new Grid<>(Concert.class);
        addClassName("concert-view");
        setSizeFull();
        configureGrid();

        concertForm = new ConcertForm(artistService.findAll(null),
                organizerService.findAll(null), culturalBuildingService.findAll());
        concertForm.addListener(ConcertForm.SaveEvent.class, this::saveConcert);
        concertForm.addListener(ConcertForm.DeleteEvent.class, this::deleteConcert);
        concertForm.addListener(ConcertForm.CloseEvent.class, e -> closeEditor());
        Div content = new Div(grid, concertForm);
        content.addClassName("content");
        content.setSizeFull();
        add(getToolBar(), content);
        listConcerts();
        closeEditor();
    }

    private void deleteConcert(ConcertForm.DeleteEvent concert) {
        concertService.delete(concert.getConcert());
        listConcerts();
        closeEditor();
    }

    private void saveConcert(ConcertForm.SaveEvent evt) {
        concertService.save(evt.getConcert());
        listConcerts();
        closeEditor();
    }

    private HorizontalLayout getToolBar() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> listConcerts());
        Button addConcertButton = new Button("Add concert", click -> addConcert());
        HorizontalLayout toolbar = new HorizontalLayout(filterText, addConcertButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void addConcert() {
        grid.asSingleSelect().clear();
        editConcert(new Concert());
    }

    private void configureGrid() {
        grid.addClassName("concert-grid");
        grid.setColumns("name", "visit_price", "start_date", "end_date");
        grid.getColumnByKey("visit_price").setHeader("Visit price");
        grid.getColumnByKey("start_date").setHeader("Start date");
        grid.getColumnByKey("end_date").setHeader("End date");
        grid.addColumn(Concert::get_LiveMusic_String).setHeader("Live music").setKey("live_music");
        grid.addColumn(Concert::getCulturalBuildingName_String).setHeader("Place").setKey("place");
        grid.setColumnOrder(Arrays.asList(grid.getColumns().get(0), grid.getColumns().get(5), grid.getColumns().get(1),
                grid.getColumns().get(2), grid.getColumns().get(3), grid.getColumns().get(4)));
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        grid.asSingleSelect().addValueChangeListener(evt -> editConcert(evt.getValue()));
        grid.setSizeFull();
    }

    private void editConcert(Concert concert) {
        if (concert == null) {
            closeEditor();
        } else {
            concertForm.setConcert(concert);
            concertForm.setVisible(true);
            addClassName("editing");
        }
    }

    private void closeEditor() {
        concertForm.setConcert(null);
        concertForm.setVisible(false);
        removeClassName("editing");
    }

    private void listConcerts() {
        grid.setItems(concertService.findAll(filterText.getValue()));
    }

}

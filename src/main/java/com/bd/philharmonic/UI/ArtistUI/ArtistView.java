package com.bd.philharmonic.UI.ArtistUI;

import com.bd.philharmonic.Backend.Entity.Artist;
import com.bd.philharmonic.Backend.Service.ArtistService;
import com.bd.philharmonic.Backend.Service.GenreService;
import com.bd.philharmonic.Backend.Service.ImpresarioService;
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

@Route(value = "/artists", layout = MainLayout.class)
@PageTitle("Artists | Vaadin CRM")
public class ArtistView extends VerticalLayout {

    private final ArtistService artistService;

    private final Grid<Artist> grid;

    private final TextField filterText = new TextField();

    private final ArtistForm artistForm;

    public ArtistView(ArtistService artistService, GenreService genreService, ImpresarioService impresarioService) {
        this.artistService = artistService;
        this.grid = new Grid<>(Artist.class);
        addClassName("artist-view");
        setSizeFull();
        configureGrid();
        artistForm = new ArtistForm(genreService.findAll(null), impresarioService.findAll(null));
        artistForm.addListener(ArtistForm.SaveEvent.class, this::saveArtist);
        artistForm.addListener(ArtistForm.DeleteEvent.class, this::deleteArtist);
        artistForm.addListener(ArtistForm.CloseEvent.class, e -> closeEditor());
        Div content = new Div(grid, artistForm);
        content.addClassName("content");
        content.setSizeFull();
        add(getToolBar(), content);
        listArtists();
        closeEditor();
    }

    private void deleteArtist(ArtistForm.DeleteEvent artist) {
        artistService.delete(artist.getArtist());
        listArtists();
        closeEditor();
    }

    private void saveArtist(ArtistForm.SaveEvent evt) {
        artistService.save(evt.getArtist());
        listArtists();
        closeEditor();
    }

    private HorizontalLayout getToolBar() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> listArtists());

        Button addArtistButton = new Button("Add artist", click -> addArtist());

        HorizontalLayout toolbar = new HorizontalLayout(filterText, addArtistButton);
        toolbar.addClassName("toolbar");

        return toolbar;
    }

    private void addArtist() {
        grid.asSingleSelect().clear();
        editArtist(new Artist());
    }

    private void configureGrid() {
        grid.addClassName("artist-grid");
        grid.setColumns("full_name", "age", "gender");
        grid.getColumnByKey("full_name").setHeader("Full name");

        grid.addColumn(Artist::getGenres_String).setHeader("Genres");

        grid.addColumn(Artist::getImpresarios_String).setHeader("Impresarios");

        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        grid.asSingleSelect().addValueChangeListener(evt -> editArtist(evt.getValue()));
        grid.setSizeFull();
    }

    private void editArtist(Artist artist) {
        if (artist == null) {
            closeEditor();
        } else {
            artistForm.setArtist(artist);
            artistForm.setVisible(true);
            addClassName("editing");
        }
    }

    private void closeEditor() {
        artistForm.setArtist(null);
        artistForm.setVisible(false);
        removeClassName("editing");
    }

    private void listArtists() {
        grid.setItems(artistService.findAll(filterText.getValue()));
    }

}

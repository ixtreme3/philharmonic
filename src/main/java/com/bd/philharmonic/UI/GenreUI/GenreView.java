package com.bd.philharmonic.UI.GenreUI;

import com.bd.philharmonic.Backend.Entity.Genre;
import com.bd.philharmonic.Backend.Service.GenreService;
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

@Route(value = "/genres", layout = MainLayout.class)
@PageTitle("Genres")
public class GenreView extends VerticalLayout {

    private final GenreService genreService;

    private final Grid<Genre> grid;

    private final TextField filterText = new TextField();

    private final GenreForm genreForm;

    public GenreView(GenreService genreService) {
        this.genreService = genreService;
        this.grid = new Grid<>(Genre.class);
        addClassName("genre-view");
        setSizeFull();
        configureGrid();
        genreForm = new GenreForm();
        genreForm.addListener(GenreForm.SaveEvent.class, this::saveGenre);
        genreForm.addListener(GenreForm.DeleteEvent.class, this::deleteGenre);
        genreForm.addListener(GenreForm.CloseEvent.class, e -> closeEditor());
        Div content = new Div(grid, genreForm);
        content.addClassName("content");
        content.setSizeFull();
        add(getToolBar(), content);
        listGenres();
        closeEditor();
    }

    private void deleteGenre(GenreForm.DeleteEvent genre) {
        genreService.delete(genre.getGenre());
        listGenres();
        closeEditor();
    }

    private void saveGenre(GenreForm.SaveEvent evt) {
        genreService.save(evt.getGenre());
        listGenres();
        closeEditor();
    }


    private HorizontalLayout getToolBar() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> listGenres());

        Button addGenreButton = new Button("Add genre", click -> addGenre());

        HorizontalLayout toolbar = new HorizontalLayout(filterText, addGenreButton);
        toolbar.addClassName("toolbar");

        return toolbar;
    }

    private void addGenre() {
        grid.asSingleSelect().clear();
        editGenre(new Genre());
    }

    private void configureGrid() {
        grid.addClassName("genre-grid");
        grid.setColumns("genre_name");
        grid.getColumnByKey("genre_name").setHeader("Name of genre");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        grid.asSingleSelect().addValueChangeListener(evt -> editGenre(evt.getValue()));
        grid.setSizeFull();
    }

    private void editGenre(Genre genre) {
        if (genre == null) {
            closeEditor();
        } else {
            genreForm.setGenre(genre);
            genreForm.setVisible(true);
            addClassName("editing");
        }
    }

    private void closeEditor() {
        genreForm.setGenre(null);
        genreForm.setVisible(false);
        removeClassName("editing");
    }

    private void listGenres() {
        grid.setItems(genreService.findAll(filterText.getValue()));
    }

}

package com.bd.philharmonic.UI.OrganizerUI;

import com.bd.philharmonic.Backend.Entity.Organizer;
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

@Route(value = "/organizers", layout = MainLayout.class)
@PageTitle("Organizers | Vaadin CRM")
public class OrganizerView extends VerticalLayout {

    private final OrganizerService organizerService;

    private final OrganizerForm organizerForm;

    private final Grid<Organizer> grid;

    private final TextField filterText = new TextField();

    public OrganizerView(OrganizerService organizerService) {
        this.organizerService = organizerService;
        this.grid = new Grid<>(Organizer.class);
        addClassName("organizer-view");
        setSizeFull();
        configureGrid();
        organizerForm = new OrganizerForm();
        organizerForm.addListener(OrganizerForm.SaveEvent.class, this::saveOrganizer);
        organizerForm.addListener(OrganizerForm.DeleteEvent.class, this::deleteOrganizer);
        organizerForm.addListener(OrganizerForm.CloseEvent.class, e -> closeEditor());
        Div content = new Div(grid, organizerForm);
        content.addClassName("content");
        content.setSizeFull();
        add(getToolBar(), content);
        listOrganizers();
        closeEditor();
    }

    private void deleteOrganizer(OrganizerForm.DeleteEvent theater) {
        organizerService.delete(theater.getTheater());
        listOrganizers();
        closeEditor();
    }

    private void saveOrganizer(OrganizerForm.SaveEvent evt) {
        organizerService.save(evt.getTheater());
        listOrganizers();
        closeEditor();
    }

    private HorizontalLayout getToolBar() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> listOrganizers());

        Button addTheaterButton = new Button("Add organizer", click -> addOrganizer());

        HorizontalLayout toolbar = new HorizontalLayout(filterText, addTheaterButton);
        toolbar.addClassName("toolbar");

        return toolbar;
    }

    private void addOrganizer() {
        grid.asSingleSelect().clear();
        editOrganizer(new Organizer());
    }

    private void configureGrid() {
        grid.addClassName("organizer-grid");
        grid.setColumns("full_name", "gender");
        grid.getColumnByKey("full_name").setHeader("Full name");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        grid.asSingleSelect().addValueChangeListener(evt -> editOrganizer(evt.getValue()));
        grid.setSizeFull();
    }

    private void editOrganizer(Organizer organizer) {
        if (organizer == null) {
            closeEditor();
        } else {
            organizerForm.setOrganizer(organizer);
            organizerForm.setVisible(true);
            addClassName("editing");
        }
    }

    private void closeEditor() {
        organizerForm.setOrganizer(null);
        organizerForm.setVisible(false);
        removeClassName("editing");
    }

    private void listOrganizers() {
        grid.setItems(organizerService.findAll(filterText.getValue()));
    }

}

package com.bd.philharmonic.UI.PerformanceUI;

import com.bd.philharmonic.Backend.Entity.Performance;
import com.bd.philharmonic.Backend.Service.*;
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

@Route(value = "/performances", layout = MainLayout.class)
@PageTitle("Performances")
public class PerformanceView extends VerticalLayout {

    private final PerformanceService performanceService;

    private final Grid<Performance> grid;

    private final TextField filterText = new TextField();

    private final PerformanceForm performanceForm;

    public PerformanceView(PerformanceService performanceService, ArtistService artistService, OrganizerService organizerService,
                           CulturalBuildingService culturalBuildingService) {
        this.performanceService = performanceService;
        this.grid = new Grid<>(Performance.class);
        addClassName("performance-view");
        setSizeFull();
        configureGrid();

        performanceForm = new PerformanceForm(artistService.findAll(null), organizerService.findAll(null),
                culturalBuildingService.findAll());
        performanceForm.addListener(PerformanceForm.SaveEvent.class, this::savePerformance);
        performanceForm.addListener(PerformanceForm.DeleteEvent.class, this::deletePerformance);
        performanceForm.addListener(PerformanceForm.CloseEvent.class, e -> closeEditor());
        Div content = new Div(grid, performanceForm);
        content.addClassName("content");
        content.setSizeFull();
        add(getToolBar(), content);
        listPerformances();
        closeEditor();
    }

    private void deletePerformance(PerformanceForm.DeleteEvent performance) {
        performanceService.delete(performance.getPerformance());
        listPerformances();
        closeEditor();
    }

    private void savePerformance(PerformanceForm.SaveEvent evt) {
        performanceService.save(evt.getPerformance());
        listPerformances();
        closeEditor();
    }

    private HorizontalLayout getToolBar() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> listPerformances());
        Button addPerformanceButton = new Button("Add performance", click -> addPerformance());
        HorizontalLayout toolbar = new HorizontalLayout(filterText, addPerformanceButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void addPerformance() {
        grid.asSingleSelect().clear();
        editPerformance(new Performance());
    }

    private void configureGrid() {
        grid.addClassName("performance-grid");
        grid.setColumns("name", "visit_price", "start_date", "end_date");
        grid.getColumnByKey("visit_price").setHeader("Visit price");
        grid.getColumnByKey("start_date").setHeader("Start date");
        grid.getColumnByKey("end_date").setHeader("End date");
        grid.addColumn(Performance::getIntermission_length).setHeader("Intermission length");
        grid.addColumn(Performance::getCulturalBuildingName_String).setHeader("Place");
        grid.setColumnOrder(Arrays.asList(grid.getColumns().get(0), grid.getColumns().get(5), grid.getColumns().get(1),
                grid.getColumns().get(2), grid.getColumns().get(3), grid.getColumns().get(4)));
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        grid.asSingleSelect().addValueChangeListener(evt -> editPerformance(evt.getValue()));
        grid.setSizeFull();
    }

    private void editPerformance(Performance performance) {
        if (performance == null) {
            closeEditor();
        } else {
            performanceForm.setPerformance(performance);
            performanceForm.setVisible(true);
            addClassName("editing");
        }
    }

    private void closeEditor() {
        performanceForm.setPerformance(null);
        performanceForm.setVisible(false);
        removeClassName("editing");
    }

    private void listPerformances() {
        grid.setItems(performanceService.findAll(filterText.getValue()));
    }

}

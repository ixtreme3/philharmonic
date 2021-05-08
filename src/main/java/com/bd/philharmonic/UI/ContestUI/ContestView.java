package com.bd.philharmonic.UI.ContestUI;

import com.bd.philharmonic.Backend.Entity.Contest;
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

@Route(value = "/contests", layout = MainLayout.class)
@PageTitle("Contests")
public class ContestView extends VerticalLayout {

    private final ContestService contestService;

    private final Grid<Contest> grid;

    private final TextField filterText = new TextField();

    private final ContestForm contestForm;

    public ContestView(ContestService contestService, ArtistService artistService, OrganizerService organizerService,
                       CulturalBuildingService culturalBuildingService, PrizewinnerService prizewinnerService) {
        this.contestService = contestService;
        this.grid = new Grid<>(Contest.class);
        addClassName("contest-view");
        setSizeFull();
        configureGrid();

        contestForm = new ContestForm(artistService.findAll(null), organizerService.findAll(null),
                culturalBuildingService.findAll(), contestService, prizewinnerService);
        contestForm.addListener(ContestForm.SaveEvent.class, this::saveContest);
        contestForm.addListener(ContestForm.DeleteEvent.class, this::deleteContest);
        contestForm.addListener(ContestForm.CloseEvent.class, e -> closeEditor());
        Div content = new Div(grid, contestForm);
        content.addClassName("content");
        content.setSizeFull();
        add(getToolBar(), content);
        listContests();
        closeEditor();
    }

    private void deleteContest(ContestForm.DeleteEvent contest) {
        contestService.delete(contest.getContest());
        listContests();
        closeEditor();
    }

    private void saveContest(ContestForm.SaveEvent evt) {
        contestService.save(evt.getContest());
        listContests();
        closeEditor();
    }

    private HorizontalLayout getToolBar() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> listContests());
        Button addContestButton = new Button("Add contest", click -> addContest());
        HorizontalLayout toolbar = new HorizontalLayout(filterText, addContestButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void addContest() {
        grid.asSingleSelect().clear();
        editContest(new Contest());
    }

    private void configureGrid() {
        grid.addClassName("contest-grid");
        grid.setColumns("name", "visit_price", "start_date", "end_date");
        grid.getColumnByKey("visit_price").setHeader("Visit price");
        grid.getColumnByKey("start_date").setHeader("Start date");
        grid.getColumnByKey("end_date").setHeader("End date");
        grid.addColumn(Contest::getNumber_of_participants).setHeader("Number of participants");
        grid.addColumn(Contest::getCulturalBuildingName_String).setHeader("Place");
        grid.setColumnOrder(Arrays.asList(grid.getColumns().get(0), grid.getColumns().get(5), grid.getColumns().get(1),
                grid.getColumns().get(2), grid.getColumns().get(3), grid.getColumns().get(4)));
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        grid.asSingleSelect().addValueChangeListener(evt -> editContest(evt.getValue()));
        grid.setSizeFull();
    }

    private void editContest(Contest contest) {
        if (contest == null) {
            closeEditor();
        } else {
            contestForm.setContest(contest);
            contestForm.setVisible(true);
            addClassName("editing");
        }
    }

    private void closeEditor() {
        contestForm.setContest(null);
        contestForm.setVisible(false);
        removeClassName("editing");
    }

    private void listContests() {
        grid.setItems(contestService.findAll(filterText.getValue()));
    }

}

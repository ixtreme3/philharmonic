package com.bd.philharmonic.UI.Queries;

import com.bd.philharmonic.Backend.Service.ContestService;
import com.bd.philharmonic.UI.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.Collections;
import java.util.List;

@Route(value = "/queries/7", layout = MainLayout.class)
@PageTitle("Query №7")
public class Q_7 extends VerticalLayout {

    private final ContestService contestService;

    private final Grid<Object[]> grid;

    private final TextField fieldContestName = new TextField();

    public Q_7(ContestService contestService) {
        this.contestService = contestService;
        addClassName("query_7_view");
        this.grid = new Grid<>();

        configureGrid();
        add(getToolBar(), grid);
        setSizeFull();

        grid.setItems(Collections.emptyList());
    }

    private HorizontalLayout getToolBar() {
        fieldContestName.setPlaceholder("Enter name of contest...");
        fieldContestName.setClearButtonVisible(true);
        fieldContestName.setWidth("300px");

        Button queryButton = new Button("Query", click -> handleClick(fieldContestName.getValue()));
        HorizontalLayout toolbar = new HorizontalLayout(fieldContestName, queryButton);
        toolbar.setAlignItems(FlexComponent.Alignment.BASELINE);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void configureGrid() {
        grid.addClassName("query_7_grid");
        grid.addColumn(objects -> objects[0]).setHeader("Prizewinner");
        grid.addColumn(objects -> objects[1]).setHeader("Place");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        setSizeFull();
    }

    private void handleClick(String contest) {
        listPrizewinners(contest);
    }

    private void listPrizewinners(String contest) {
        List<Object[]> contestPrizewinners = contestService.getContestPrizewinners(contest);
        if (contestPrizewinners.isEmpty()) {
            grid.setItems(Collections.emptyList());
        } else grid.setItems(contestPrizewinners);
    }

}

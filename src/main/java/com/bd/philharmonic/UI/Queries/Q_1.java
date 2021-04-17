package com.bd.philharmonic.UI.Queries;

import com.bd.philharmonic.Backend.Entity.CulturalBuilding;
import com.bd.philharmonic.Backend.Entity.HouseOfCulture;
import com.bd.philharmonic.Backend.Entity.Theater;
import com.bd.philharmonic.Backend.Service.CulturalBuildingService;
import com.bd.philharmonic.UI.MainLayout;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.Collections;
import java.util.List;

@Route(value = "/queries/1", layout = MainLayout.class)
@PageTitle("Query №1 | Vaadin CRM")
public class Q_1 extends VerticalLayout {

    private final CulturalBuildingService culturalBuildingService;

    private Grid<CulturalBuilding> grid = null;

    FormLayout details = new FormLayout();

    private final TextField filterText = new TextField();


    public Q_1(CulturalBuildingService culturalBuildingService) {
        this.culturalBuildingService = culturalBuildingService;
        addClassName("query-view");
        this.grid = new Grid<>(CulturalBuilding.class);
        configureGrid();

        details.addClassName("form-layout");

        Div content = new Div(grid, details);
        content.addClassName("content");
        content.setSizeFull();

        add(getToolBar(), content);
    }

    private HorizontalLayout getToolBar() {
        filterText.setPlaceholder("Enter type of building...");
        filterText.setClearButtonVisible(true);
        Button addTheaterButton = new Button("Query", click -> listBuildings(filterText.getValue()));
        HorizontalLayout toolbar = new HorizontalLayout(filterText, addTheaterButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void configureGrid() {
        grid.addClassName("query-grid");
        setSizeFull();
        grid.setColumns("name", "address", "capacity");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));

        grid.asSingleSelect().addValueChangeListener(evt -> showBuildingDetails(evt.getValue()));
    }

    private void showBuildingDetails(CulturalBuilding building){
        details.removeAll();
        if (building instanceof Theater) {
            details.add(
                    new H3("Сцена"),
                    new Text(((Theater) building).getScene()),
                    new H3("Количество балконов"),
                    new Text(String.valueOf(((Theater) building).getNumber_of_balconies()))
            );
        }
        if (building instanceof HouseOfCulture) {
            details.add(
                    new H3("Тип"),
                    new Text(((HouseOfCulture) building).getType())
            );
        }
    }

    private void listBuildings(String type) {
        List<CulturalBuilding> buildingsOfType = culturalBuildingService.getBuildingsOfType(type);
        if (buildingsOfType == null) {
            grid.setItems(Collections.emptyList());
        } else {
            grid.setItems(culturalBuildingService.getBuildingsOfType(type));
        }
    }

}

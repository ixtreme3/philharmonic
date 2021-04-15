package com.bd.philharmonic.UI.HouseOfCultureUI;

import com.bd.philharmonic.Backend.Entity.HouseOfCulture;
import com.bd.philharmonic.Backend.Service.HouseOfCultureService;
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

@Route(value = "/houses_of_culture", layout = MainLayout.class)
@PageTitle("Houses of culture | Vaadin CRM")
public class HouseOfCultureView extends VerticalLayout {

    private final HouseOfCultureService houseOfCultureService;

    private final Grid<HouseOfCulture> grid;

    private final TextField filterText = new TextField();

    private final HouseOfCultureForm houseOfCultureForm;

    public HouseOfCultureView(HouseOfCultureService houseOfCultureService) {
        this.houseOfCultureService = houseOfCultureService;
        addClassName("house_of_culture-view");
        this.grid = new Grid<>(HouseOfCulture.class);

        configureGrid();

        houseOfCultureForm = new HouseOfCultureForm();
        houseOfCultureForm.addListener(HouseOfCultureForm.SaveEvent.class, this::saveHouseOfCulture);
        houseOfCultureForm.addListener(HouseOfCultureForm.DeleteEvent.class, this:: deleteHouseOfCulture);
        houseOfCultureForm.addListener(HouseOfCultureForm.CloseEvent.class, e -> closeEditor());

        Div content = new Div(grid, houseOfCultureForm);
        content.addClassName("content");
        content.setSizeFull();

        add(getToolBar(), content);
        listHousesOfCulture();
        closeEditor();
    }

    private void deleteHouseOfCulture(HouseOfCultureForm.DeleteEvent houseOfCulture) {
        houseOfCultureService.delete(houseOfCulture.getHouseOfCulture());
        listHousesOfCulture();
        closeEditor();
    }

    private void saveHouseOfCulture(HouseOfCultureForm.SaveEvent evt) {
        houseOfCultureService.save(evt.getHouseOfCulture());
        listHousesOfCulture();
        closeEditor();
    }


    private HorizontalLayout getToolBar() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> listHousesOfCulture());

        Button addTheaterButton = new Button("Add house of culture", click -> addHouseOfCulture());

        HorizontalLayout toolbar = new HorizontalLayout(filterText, addTheaterButton);
        toolbar.addClassName("toolbar");

        return toolbar;
    }

    private void addHouseOfCulture() {
        grid.asSingleSelect().clear();
        editHouseOfCulture(new HouseOfCulture());
    }

    private void configureGrid() {
        grid.addClassName("house_of_culture-grid");
        setSizeFull();
        grid.setColumns("name", "address", "capacity", "type");
//        grid.setColumns("name", "address", "capacity", "scene", "number_of_balconies");
//        grid.getColumnByKey("number_of_balconies").setHeader("Number of balconies");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));

        grid.asSingleSelect().addValueChangeListener(evt -> editHouseOfCulture(evt.getValue()));
    }

    private void editHouseOfCulture(HouseOfCulture houseOfCulture) {
        if (houseOfCulture == null) {
            closeEditor();
        } else {
            houseOfCultureForm.setHouseOfCulture(houseOfCulture);
            houseOfCultureForm.setVisible(true);
            addClassName("editing");
        }
    }

    private void closeEditor() {
        houseOfCultureForm.setHouseOfCulture(null);
        houseOfCultureForm.setVisible(false);
        removeClassName("editing");
    }

    private void listHousesOfCulture() {
        grid.setItems(houseOfCultureService.findAll(filterText.getValue()));
    }
}

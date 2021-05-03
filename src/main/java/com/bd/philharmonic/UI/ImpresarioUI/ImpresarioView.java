package com.bd.philharmonic.UI.ImpresarioUI;

import com.bd.philharmonic.Backend.Entity.Impresario;
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

@Route(value = "/impresarios", layout = MainLayout.class)
@PageTitle("Impresarios")
public class ImpresarioView extends VerticalLayout {

    private final ImpresarioService impresarioService;

    private final Grid<Impresario> grid;

    private final TextField filterText = new TextField();

    private final ImpresarioForm impresarioForm;

    public ImpresarioView(ImpresarioService impresarioService) {
        this.impresarioService = impresarioService;
        this.grid = new Grid<>(Impresario.class);
        addClassName("impresario-view");
        setSizeFull();
        configureGrid();
        impresarioForm = new ImpresarioForm();
        impresarioForm.addListener(ImpresarioForm.SaveEvent.class, this::saveImpresario);
        impresarioForm.addListener(ImpresarioForm.DeleteEvent.class, this::deleteImpresario);
        impresarioForm.addListener(ImpresarioForm.CloseEvent.class, e -> closeEditor());
        Div content = new Div(grid, impresarioForm);
        content.addClassName("content");
        content.setSizeFull();
        add(getToolBar(), content);
        listImpresarios();
        closeEditor();
    }

    private void deleteImpresario(ImpresarioForm.DeleteEvent impresario) {
        impresarioService.delete(impresario.getImpresario());
        listImpresarios();
        closeEditor();
    }

    private void saveImpresario(ImpresarioForm.SaveEvent evt) {
        impresarioService.save(evt.getImpresario());
        listImpresarios();
        closeEditor();
    }


    private HorizontalLayout getToolBar() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> listImpresarios());
        Button addImpresarioButton = new Button("Add impresario", click -> addImpresario());
        HorizontalLayout toolbar = new HorizontalLayout(filterText, addImpresarioButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void addImpresario() {
        grid.asSingleSelect().clear();
        editImpresario(new Impresario());
    }

    private void configureGrid() {
        grid.addClassName("impresario-grid");
        grid.setColumns("full_name", "age", "gender");
        grid.getColumnByKey("full_name").setHeader("Full name");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        grid.asSingleSelect().addValueChangeListener(evt -> editImpresario(evt.getValue()));
        grid.setSizeFull();
    }

    private void editImpresario(Impresario impresario) {
        if (impresario == null) {
            closeEditor();
        } else {
            impresarioForm.setImpresario(impresario);
            impresarioForm.setVisible(true);
            addClassName("editing");
        }
    }

    private void closeEditor() {
        impresarioForm.setImpresario(null);
        impresarioForm.setVisible(false);
        removeClassName("editing");
    }

    private void listImpresarios() {
        grid.setItems(impresarioService.findAll(filterText.getValue()));
    }

}

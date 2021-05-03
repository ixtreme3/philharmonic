package com.bd.philharmonic.UI.PerformanceUI;

import com.bd.philharmonic.Backend.Entity.*;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.shared.Registration;
import org.vaadin.gatanaso.MultiselectComboBox;

import java.util.List;

public class PerformanceForm extends FormLayout {

    TextField name = new TextField("Name");
    IntegerField visit_price = new IntegerField("Visit price");
    DatePicker start_date = new DatePicker("Start Date");
    DatePicker end_date = new DatePicker("End Date");
    ComboBox<CulturalBuilding> culturalBuilding = new ComboBox<>("Event location");
    MultiselectComboBox<Artist> artists = new MultiselectComboBox<>("Event artists");
    MultiselectComboBox<Organizer> organizers = new MultiselectComboBox<>("Event organizers");
    IntegerField intermission_length = new IntegerField("Intermission length");

    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button close = new Button("Cancel");

    Binder<Performance> binder = new Binder<>(Performance.class);

    public PerformanceForm(List<Artist> artistList, List<Organizer> organizerList,
                           List<CulturalBuilding> culturalBuildingList) {
        addClassName("performance-form");
        binder.bindInstanceFields(this);
        artists.setItems(artistList);
        artists.setItemLabelGenerator(Artist::getFull_name);
        organizers.setItems(organizerList);
        organizers.setItemLabelGenerator(Organizer::getFull_name);
        culturalBuilding.setItems(culturalBuildingList);
        culturalBuilding.setItemLabelGenerator(CulturalBuilding::getName);
        start_date.setAutoOpen(false);
        end_date.setAutoOpen(false);
        start_date.setClearButtonVisible(true);
        end_date.setClearButtonVisible(true);
        add(
                name,
                visit_price,
                start_date,
                end_date,
                artists,
                organizers,
                culturalBuilding,
                intermission_length,
                createButtonsLayout()
        );
    }

    public void setPerformance(Performance performance) {
        binder.setBean(performance);
    }

    private Component createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickListener(click -> validateAndSave());
        delete.addClickListener(click -> fireEvent(new PerformanceForm.DeleteEvent(this, binder.getBean())));
        close.addClickListener(click -> fireEvent(new PerformanceForm.CloseEvent(this)));

        binder.addStatusChangeListener(evt -> save.setEnabled(binder.isValid()));

        return new HorizontalLayout(save, delete, close);
    }

    private void validateAndSave() {
        if (binder.isValid()) {
            fireEvent(new PerformanceForm.SaveEvent(this, binder.getBean()));
        }
    }

    // Events
    public static abstract class PerformanceFormEvent extends ComponentEvent<PerformanceForm> {
        private final Performance performance;

        protected PerformanceFormEvent(PerformanceForm source, Performance performance) {
            super(source, false);
            this.performance = performance;
        }

        public Performance getPerformance() {
            return performance;
        }
    }

    public static class SaveEvent extends PerformanceForm.PerformanceFormEvent {
        SaveEvent(PerformanceForm source, Performance performance) {
            super(source, performance);
        }
    }

    public static class DeleteEvent extends PerformanceForm.PerformanceFormEvent {
        DeleteEvent(PerformanceForm source, Performance performance) {
            super(source, performance);
        }

    }

    public static class CloseEvent extends PerformanceForm.PerformanceFormEvent {
        CloseEvent(PerformanceForm source) {
            super(source, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }

}

package com.bd.philharmonic.UI.ConcertUI;

import com.bd.philharmonic.Backend.Entity.*;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
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

public class ConcertForm extends FormLayout {

    TextField name = new TextField("Name");
    IntegerField visit_price = new IntegerField("Visit price");
    DatePicker start_date = new DatePicker("Start Date");
    DatePicker end_date = new DatePicker("End Date");
    ComboBox<CulturalBuilding> culturalBuilding = new ComboBox<>("Event location");
    MultiselectComboBox<Artist> artists = new MultiselectComboBox<>("Event artists");
    MultiselectComboBox<Organizer> organizers = new MultiselectComboBox<>("Event organizers");
    Checkbox live_music = new Checkbox("Live music");

    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button close = new Button("Cancel");

    Binder<Concert> binder = new Binder<>(Concert.class);

    public ConcertForm(List<Artist> artistList, List<Organizer> organizerList, List<CulturalBuilding> culturalBuildingList) {
        addClassName("concert-form");
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
                live_music,
                createButtonsLayout()
        );
    }

    public void setConcert(Concert concert) {
        binder.setBean(concert);
    }

    private Component createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickListener(click -> validateAndSave());
        delete.addClickListener(click -> fireEvent(new ConcertForm.DeleteEvent(this, binder.getBean())));
        close.addClickListener(click -> fireEvent(new ConcertForm.CloseEvent(this)));

        binder.addStatusChangeListener(evt -> save.setEnabled(binder.isValid()));

        return new HorizontalLayout(save, delete, close);
    }

    private void validateAndSave() {
        if (binder.isValid()) {
            fireEvent(new ConcertForm.SaveEvent(this, binder.getBean()));
        }
    }

    // Events
    public static abstract class ConcertFormEvent extends ComponentEvent<ConcertForm> {
        private final Concert concert;

        protected ConcertFormEvent(ConcertForm source, Concert concert) {
            super(source, false);
            this.concert = concert;
        }

        public Concert getConcert() {
            return concert;
        }
    }

    public static class SaveEvent extends ConcertForm.ConcertFormEvent {
        SaveEvent(ConcertForm source, Concert concert) {
            super(source, concert);
        }
    }

    public static class DeleteEvent extends ConcertForm.ConcertFormEvent {
        DeleteEvent(ConcertForm source, Concert concert) {
            super(source, concert);
        }

    }

    public static class CloseEvent extends ConcertForm.ConcertFormEvent {
        CloseEvent(ConcertForm source) {
            super(source, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }

}

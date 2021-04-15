package com.bd.philharmonic.UI.TheaterUI;

import com.bd.philharmonic.Backend.Entity.Theater;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.shared.Registration;

public class TheaterForm extends FormLayout {

    TextField name = new TextField("Name");
    TextField address = new TextField("Address");
    IntegerField capacity = new IntegerField ("Capacity");

    TextField scene = new TextField("Scene");
    IntegerField number_of_balconies = new IntegerField("Number of balconies");

    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button close = new Button("Cancel");

    Binder<Theater> binder = new Binder<>(Theater.class);

    public TheaterForm() {
        addClassName("theater-form");

        binder.bindInstanceFields(this);

        add(
            name,
            address,
            capacity,
            scene,
            number_of_balconies,
            createButtonsLayout()
        );
    }

    public void setTheater(Theater theater) {
        binder.setBean(theater);
    }

    private Component createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickListener(click -> validateAndSave());
        delete.addClickListener(click -> fireEvent(new DeleteEvent(this, binder.getBean())));
        close.addClickListener(click -> fireEvent(new CloseEvent(this)));

        binder.addStatusChangeListener(evt -> save.setEnabled(binder.isValid()));

        return new HorizontalLayout(save, delete, close);
    }

    private void validateAndSave() {
        if (binder.isValid()) {
            fireEvent(new SaveEvent(this, binder.getBean()));
        }
    }

    // Events
    public static abstract class TheaterFormEvent extends ComponentEvent<TheaterForm> {
        private final Theater theater;

        protected TheaterFormEvent(TheaterForm source, Theater theater) {
            super(source, false);
            this.theater = theater;
        }

        public Theater getTheater() {
            return theater;
        }
    }

    public static class SaveEvent extends TheaterFormEvent {
        SaveEvent(TheaterForm source, Theater theater) {
            super(source, theater);
        }
    }

    public static class DeleteEvent extends TheaterFormEvent {
        DeleteEvent(TheaterForm source, Theater theater) {
            super(source, theater);
        }

    }

    public static class CloseEvent extends TheaterFormEvent {
        CloseEvent(TheaterForm source) {
            super(source, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }

}

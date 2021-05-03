package com.bd.philharmonic.UI.OrganizerUI;

import com.bd.philharmonic.Backend.Entity.Organizer;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.shared.Registration;

public class OrganizerForm extends FormLayout {

    TextField full_name = new TextField("Full name");

    TextField gender = new TextField("Gender");

    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button close = new Button("Cancel");

    Binder<Organizer> binder = new Binder<>(Organizer.class);

    public OrganizerForm() {
        addClassName("organizer-form");

        binder.bindInstanceFields(this);

        add(
                full_name,
                gender,
                createButtonsLayout()
        );
    }

    public void setOrganizer(Organizer organizer) {
        binder.setBean(organizer);
    }

    private Component createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickListener(click -> validateAndSave());
        delete.addClickListener(click -> fireEvent(new OrganizerForm.DeleteEvent(this, binder.getBean())));
        close.addClickListener(click -> fireEvent(new OrganizerForm.CloseEvent(this)));

        binder.addStatusChangeListener(evt -> save.setEnabled(binder.isValid()));

        return new HorizontalLayout(save, delete, close);
    }

    private void validateAndSave() {
        if (binder.isValid()) {
            fireEvent(new OrganizerForm.SaveEvent(this, binder.getBean()));
        }
    }

    // Events
    public static abstract class OrganizerFormEvent extends ComponentEvent<OrganizerForm> {
        private final Organizer organizer;

        protected OrganizerFormEvent(OrganizerForm source, Organizer organizer) {
            super(source, false);
            this.organizer = organizer;
        }

        public Organizer getOrganizer() {
            return organizer;
        }
    }

    public static class SaveEvent extends OrganizerFormEvent {
        SaveEvent(OrganizerForm source, Organizer organizer) {
            super(source, organizer);
        }
    }

    public static class DeleteEvent extends OrganizerFormEvent {
        DeleteEvent(OrganizerForm source, Organizer organizer) {
            super(source, organizer);
        }

    }

    public static class CloseEvent extends OrganizerFormEvent {
        CloseEvent(OrganizerForm source) {
            super(source, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }
}

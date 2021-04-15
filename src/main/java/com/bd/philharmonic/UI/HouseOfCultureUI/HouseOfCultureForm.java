package com.bd.philharmonic.UI.HouseOfCultureUI;

import com.bd.philharmonic.Backend.Entity.HouseOfCulture;
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

public class HouseOfCultureForm extends FormLayout {

    TextField name = new TextField("Name");
    TextField address = new TextField("Address");
    IntegerField capacity = new IntegerField ("Capacity");

    TextField type = new TextField("Type");

    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button close = new Button("Cancel");

    Binder<HouseOfCulture> binder = new Binder<>(HouseOfCulture.class);

    public HouseOfCultureForm() {
        addClassName("house_of_culture-form");

        binder.bindInstanceFields(this);

        add(
                name,
                address,
                capacity,
                type,
                createButtonsLayout()
        );
    }

    public void setHouseOfCulture(HouseOfCulture houseOfCulture) {
        binder.setBean(houseOfCulture);
    }

    private Component createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickListener(click -> validateAndSave());
        delete.addClickListener(click -> fireEvent(new HouseOfCultureForm.DeleteEvent(this, binder.getBean())));
        close.addClickListener(click -> fireEvent(new HouseOfCultureForm.CloseEvent(this)));

        binder.addStatusChangeListener(evt -> save.setEnabled(binder.isValid()));

        return new HorizontalLayout(save, delete, close);
    }

    private void validateAndSave() {
        if (binder.isValid()) {
            fireEvent(new HouseOfCultureForm.SaveEvent(this, binder.getBean()));
        }
    }

    // Events
    public static abstract class HouseOfCultureFormEvent extends ComponentEvent<HouseOfCultureForm> {
        private final HouseOfCulture houseOfCulture;

        protected HouseOfCultureFormEvent(HouseOfCultureForm source, HouseOfCulture houseOfCulture) {
            super(source, false);
            this.houseOfCulture = houseOfCulture;
        }

        public HouseOfCulture getHouseOfCulture() {
            return houseOfCulture;
        }
    }

    public static class SaveEvent extends HouseOfCultureForm.HouseOfCultureFormEvent {
        SaveEvent(HouseOfCultureForm source, HouseOfCulture houseOfCulture) {
            super(source, houseOfCulture);
        }
    }

    public static class DeleteEvent extends HouseOfCultureForm.HouseOfCultureFormEvent {
        DeleteEvent(HouseOfCultureForm source, HouseOfCulture houseOfCulture) {
            super(source, houseOfCulture);
        }

    }

    public static class CloseEvent extends HouseOfCultureForm.HouseOfCultureFormEvent {
        CloseEvent(HouseOfCultureForm source) {
            super(source, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }


}

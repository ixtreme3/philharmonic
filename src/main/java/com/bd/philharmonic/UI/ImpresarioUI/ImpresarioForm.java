package com.bd.philharmonic.UI.ImpresarioUI;

import com.bd.philharmonic.Backend.Entity.Impresario;
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

public class ImpresarioForm extends FormLayout {

    TextField full_name = new TextField("Full name");

    IntegerField age = new IntegerField ("Age");

    TextField gender = new TextField("Gender");

    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button close = new Button("Cancel");

    Binder<Impresario> binder = new Binder<>(Impresario.class);

    public ImpresarioForm() {
        addClassName("impresario-form");

        binder.bindInstanceFields(this);

        add(
                full_name,
                age,
                gender,
                createButtonsLayout()
        );
    }

    public void setImpresario(Impresario impresario) {
        binder.setBean(impresario);
    }

    private Component createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickListener(click -> validateAndSave());
        delete.addClickListener(click -> fireEvent(new ImpresarioForm.DeleteEvent(this, binder.getBean())));
        close.addClickListener(click -> fireEvent(new ImpresarioForm.CloseEvent(this)));

        binder.addStatusChangeListener(evt -> save.setEnabled(binder.isValid()));

        return new HorizontalLayout(save, delete, close);
    }

    private void validateAndSave() {
        if (binder.isValid()) {
            fireEvent(new ImpresarioForm.SaveEvent(this, binder.getBean()));
        }
    }

    // Events
    public static abstract class ImpresarioFormEvent extends ComponentEvent<ImpresarioForm> {
        private final Impresario impresario;

        protected ImpresarioFormEvent(ImpresarioForm source, Impresario impresario) {
            super(source, false);
            this.impresario = impresario;
        }

        public Impresario getImpresario() {
            return impresario;
        }
    }

    public static class SaveEvent extends ImpresarioFormEvent {
        SaveEvent(ImpresarioForm source, Impresario impresario) {
            super(source, impresario);
        }
    }

    public static class DeleteEvent extends ImpresarioFormEvent {
        DeleteEvent(ImpresarioForm source, Impresario impresario) {
            super(source, impresario);
        }

    }

    public static class CloseEvent extends ImpresarioFormEvent {
        CloseEvent(ImpresarioForm source) {
            super(source, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }

}

package com.bd.philharmonic.UI.GenreUI;

import com.bd.philharmonic.Backend.Entity.Genre;
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

public class GenreForm extends FormLayout {

    TextField genre_name = new TextField("Genre name");

    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button close = new Button("Cancel");

    Binder<Genre> binder = new Binder<>(Genre.class);

    public GenreForm() {
        addClassName("genre-form");

        binder.bindInstanceFields(this);

        add(
            genre_name,
            createButtonsLayout()
        );
    }

    public void setGenre(Genre genre) {
        binder.setBean(genre);
    }

    private Component createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickListener(click -> validateAndSave());
        delete.addClickListener(click -> fireEvent(new GenreForm.DeleteEvent(this, binder.getBean())));
        close.addClickListener(click -> fireEvent(new GenreForm.CloseEvent(this)));

        binder.addStatusChangeListener(evt -> save.setEnabled(binder.isValid()));

        return new HorizontalLayout(save, delete, close);
    }

    private void validateAndSave() {
        if (binder.isValid()) {
            fireEvent(new GenreForm.SaveEvent(this, binder.getBean()));
        }
    }

    // Events
    public static abstract class GenreFormEvent extends ComponentEvent<GenreForm> {
        private final Genre genre;

        protected GenreFormEvent(GenreForm source, Genre genre) {
            super(source, false);
            this.genre = genre;
        }

        public Genre getGenre() {
            return genre;
        }
    }

    public static class SaveEvent extends GenreFormEvent {
        SaveEvent(GenreForm source, Genre genre) {
            super(source, genre);
        }
    }

    public static class DeleteEvent extends GenreFormEvent {
        DeleteEvent(GenreForm source, Genre genre) {
            super(source, genre);
        }

    }

    public static class CloseEvent extends GenreFormEvent {
        CloseEvent(GenreForm source) {
            super(source, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }

}

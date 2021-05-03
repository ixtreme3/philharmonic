package com.bd.philharmonic.UI.ArtistUI;

import com.bd.philharmonic.Backend.Entity.Artist;
import com.bd.philharmonic.Backend.Entity.Genre;
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
import org.vaadin.gatanaso.MultiselectComboBox;

import java.util.List;

public class ArtistForm extends FormLayout {

    TextField full_name = new TextField("Full name");
    IntegerField age = new IntegerField("Age");
    TextField gender = new TextField("Gender");

    MultiselectComboBox<Genre> genres = new MultiselectComboBox<>("Genres");
    MultiselectComboBox<Impresario> impresarios = new MultiselectComboBox<>("Impresarios");

    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button close = new Button("Cancel");

    Binder<Artist> binder = new Binder<>(Artist.class);

    public ArtistForm(List<Genre> genreList, List<Impresario> impresarioList) {
        addClassName("artist-form");
        binder.bindInstanceFields(this);
        genres.setItems(genreList);
        genres.setItemLabelGenerator(Genre::getGenre_name);
        impresarios.setItems(impresarioList);
        impresarios.setItemLabelGenerator(Impresario::getFull_name);
        add(
                full_name,
                age,
                gender,
                genres,
                impresarios,
                createButtonsLayout()
        );
    }

    public void setArtist(Artist artist) {
        binder.setBean(artist);
    }

    private Component createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickListener(click -> validateAndSave());
        delete.addClickListener(click -> fireEvent(new ArtistForm.DeleteEvent(this, binder.getBean())));
        close.addClickListener(click -> fireEvent(new ArtistForm.CloseEvent(this)));

        binder.addStatusChangeListener(evt -> save.setEnabled(binder.isValid()));

        return new HorizontalLayout(save, delete, close);
    }

    private void validateAndSave() {
        if (binder.isValid()) {
            fireEvent(new ArtistForm.SaveEvent(this, binder.getBean()));
        }
    }

    // Events
    public static abstract class ArtistFormEvent extends ComponentEvent<ArtistForm> {
        private final Artist artist;

        protected ArtistFormEvent(ArtistForm source, Artist artist) {
            super(source, false);
            this.artist = artist;
        }

        public Artist getArtist() {
            return artist;
        }
    }

    public static class SaveEvent extends ArtistFormEvent {
        SaveEvent(ArtistForm source, Artist artist) {
            super(source, artist);
        }
    }

    public static class DeleteEvent extends ArtistFormEvent {
        DeleteEvent(ArtistForm source, Artist artist) {
            super(source, artist);
        }
    }

    public static class CloseEvent extends ArtistFormEvent {
        CloseEvent(ArtistForm source) {
            super(source, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }

}

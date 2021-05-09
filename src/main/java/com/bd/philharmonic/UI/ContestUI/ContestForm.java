package com.bd.philharmonic.UI.ContestUI;

import com.bd.philharmonic.Backend.Entity.*;
import com.bd.philharmonic.Backend.Service.ArtistService;
import com.bd.philharmonic.Backend.Service.ContestService;
import com.bd.philharmonic.Backend.Service.PrizewinnerService;
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

public class ContestForm extends FormLayout {

    TextField name = new TextField("Name");
    IntegerField visit_price = new IntegerField("Visit price");
    DatePicker start_date = new DatePicker("Start Date");
    DatePicker end_date = new DatePicker("End Date");
    ComboBox<CulturalBuilding> culturalBuilding = new ComboBox<>("Event location");
    MultiselectComboBox<Artist> artists = new MultiselectComboBox<>("Event artists");
    MultiselectComboBox<Organizer> organizers = new MultiselectComboBox<>("Event organizers");
    IntegerField number_of_participants = new IntegerField("Number of participants");

    TextField firstPlace = new TextField("First place");
    TextField secondPlace = new TextField("Second place");
    TextField thirdPlace = new TextField("Third place");

//    ComboBox<Artist> firstPlaceComboBox = new ComboBox<>("First place");
//    ComboBox<Artist> secondPlaceComboBox = new ComboBox<>("Second place");
//    ComboBox<Artist> thirdPlaceComboBox = new ComboBox<>("Third place");

    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button close = new Button("Cancel");

    Binder<Contest> binder = new Binder<>(Contest.class);

    public ContestForm(List<Artist> artistList, List<Organizer> organizerList, List<CulturalBuilding> culturalBuildingList,
                       ContestService contestService, PrizewinnerService prizewinnerService, ArtistService artistService) {
        addClassName("contest-form");
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

        binder.bind(firstPlace, contest -> contest.getWinnerNameByPlace(contestService, 1), (contest, s) -> contest.setWinnerByPlace(prizewinnerService, firstPlace.getValue(), 1));
        binder.bind(secondPlace, contest -> contest.getWinnerNameByPlace(contestService, 2), (contest, s) -> contest.setWinnerByPlace(prizewinnerService, secondPlace.getValue(), 2));
        binder.bind(thirdPlace, contest -> contest.getWinnerNameByPlace(contestService, 3), (contest, s) -> contest.setWinnerByPlace(prizewinnerService, thirdPlace.getValue(), 3));

//        firstPlaceComboBox.setItemLabelGenerator(Artist::getFull_name);
//        secondPlaceComboBox.setItemLabelGenerator(Artist::getFull_name);
//        thirdPlaceComboBox.setItemLabelGenerator(Artist::getFull_name);
//
//        binder.bind(firstPlaceComboBox, contest -> null,
//                (contest, artist) -> contest.setWinnerByPlace(prizewinnerService, artist, 1));
//
//        binder.bind(secondPlaceComboBox, contest -> null,
//                (contest, artist) -> contest.setWinnerByPlace(prizewinnerService, artist, 2));
//
//        binder.bind(thirdPlaceComboBox, contest -> null,
//                (contest, artist) -> contest.setWinnerByPlace(prizewinnerService, artist, 3));

        add(
                name,
                visit_price,
                start_date,
                end_date,
                artists,
                organizers,
                culturalBuilding,
                number_of_participants,
                firstPlace,
                secondPlace,
                thirdPlace,
//                firstPlaceComboBox,
//                secondPlaceComboBox,
//                thirdPlaceComboBox,
                createButtonsLayout()
        );
    }

    public void setContest(Contest contest) {
        binder.setBean(contest);
    }

    private Component createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickListener(click -> validateAndSave());
        delete.addClickListener(click -> fireEvent(new ContestForm.DeleteEvent(this, binder.getBean())));
        close.addClickListener(click -> fireEvent(new ContestForm.CloseEvent(this)));

        binder.addStatusChangeListener(evt -> save.setEnabled(binder.isValid()));

        return new HorizontalLayout(save, delete, close);
    }

    private void validateAndSave() {
        if (binder.isValid()) {
            fireEvent(new ContestForm.SaveEvent(this, binder.getBean()));
        }
    }

    // Events
    public static abstract class ContestFormEvent extends ComponentEvent<ContestForm> {
        private final Contest contest;

        protected ContestFormEvent(ContestForm source, Contest contest) {
            super(source, false);
            this.contest = contest;
        }

        public Contest getContest() {
            return contest;
        }
    }

    public static class SaveEvent extends ContestForm.ContestFormEvent {
        SaveEvent(ContestForm source, Contest contest) {
            super(source, contest);
        }
    }

    public static class DeleteEvent extends ContestForm.ContestFormEvent {
        DeleteEvent(ContestForm source, Contest contest) {
            super(source, contest);
        }

    }

    public static class CloseEvent extends ContestForm.ContestFormEvent {
        CloseEvent(ContestForm source) {
            super(source, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }

}

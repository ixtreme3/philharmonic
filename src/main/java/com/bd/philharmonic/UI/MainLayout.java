package com.bd.philharmonic.UI;

import com.bd.philharmonic.UI.ArtistUI.ArtistView;
import com.bd.philharmonic.UI.ConcertUI.ConcertView;
import com.bd.philharmonic.UI.GenreUI.GenreView;
import com.bd.philharmonic.UI.HouseOfCultureUI.HouseOfCultureView;
import com.bd.philharmonic.UI.ImpresarioUI.ImpresarioView;
import com.bd.philharmonic.UI.OrganizerUI.OrganizerView;
import com.bd.philharmonic.UI.PerformanceUI.PerformanceView;
import com.bd.philharmonic.UI.Queries.*;
import com.bd.philharmonic.UI.TheaterUI.TheaterView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route(value = "/home")
@CssImport("./styles/shared-styles.css")
public class MainLayout extends AppLayout {

    public MainLayout() {
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        H1 logo = new H1("Philharmonic information system");
        logo.addClassName("logo");

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo);
        header.addClassName("header");
        header.setWidth("100%");
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        addToNavbar(header);
    }

    private void createDrawer() {
        RouterLink theatersLink = new RouterLink("Theaters", TheaterView.class);
        theatersLink.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink housesOfCultureLink = new RouterLink("Houses of culture", HouseOfCultureView.class);
        housesOfCultureLink.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink organizersLink = new RouterLink("Events organizers", OrganizerView.class);
        organizersLink.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink impresariosLink = new RouterLink("Impresarios", ImpresarioView.class);
        impresariosLink.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink artistsLink = new RouterLink("Artists", ArtistView.class);
        artistsLink.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink concertLink = new RouterLink("Concerts", ConcertView.class);
        concertLink.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink performanceLink = new RouterLink("Performances", PerformanceView.class);
        performanceLink.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink genresLink = new RouterLink("Genres", GenreView.class);
        genresLink.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink query1Link = new RouterLink("Query №1", Q_1.class);
        query1Link.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink query2Link = new RouterLink("Query №2", Q_2.class);
        query2Link.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink query3Link = new RouterLink("Query №3", Q_3.class);
        query3Link.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink query4Link = new RouterLink("Query №4", Q_4.class);
        query4Link.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink query5Link = new RouterLink("Query №5", Q_5.class);
        query5Link.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink query6Link = new RouterLink("Query №6", Q_6.class);
        query6Link.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink query8Link = new RouterLink("Query №8", Q_8.class);
        query8Link.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink query9Link = new RouterLink("Query №9", Q_9.class);
        query9Link.setHighlightCondition(HighlightConditions.sameLocation());

        addToDrawer(new VerticalLayout(
            theatersLink,
            housesOfCultureLink,
            organizersLink,
            impresariosLink,
            artistsLink,
            genresLink,
            concertLink,
            performanceLink,

            query1Link,
            query2Link,
            query3Link,
            query4Link,
            query5Link,
            query6Link,
            query8Link,
            query9Link
        ));
    }

}

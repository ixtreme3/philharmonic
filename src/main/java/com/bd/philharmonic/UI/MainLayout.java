package com.bd.philharmonic.UI;

import com.bd.philharmonic.UI.HouseOfCultureUI.HouseOfCultureView;
import com.bd.philharmonic.UI.Queries.Q_1;
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
        H1 logo = new H1("Vaadin CRM");
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
        theatersLink.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink query1Link = new RouterLink("Query №1", Q_1.class);
        theatersLink.setHighlightCondition(HighlightConditions.sameLocation());

        addToDrawer(new VerticalLayout(
            theatersLink,
            housesOfCultureLink,
            query1Link
        ));
    }

}

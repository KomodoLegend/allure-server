package ru.iopump.qa.allure.gui;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.IronIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;
import ru.iopump.qa.allure.gui.view.AboutView;
import ru.iopump.qa.allure.gui.view.ReportsView;
import ru.iopump.qa.allure.gui.view.ResultsView;
import ru.iopump.qa.allure.gui.view.SwaggerView;

@JsModule("./brands.js")
@CssImport(value = "./styles.css", themeFor = "vaadin-app-layout")

public class MainLayout extends AppLayout {

    public static final String ALLURE_SERVER = "Allure Server";

    private static final long serialVersionUID = 2881152775131362224L;

    public MainLayout() {
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        var logo = new H3(ALLURE_SERVER);
        logo.addClassName("logo");
        logo.getStyle().set("color", "#ffffff");

        var header = new HorizontalLayout(new DrawerToggle(), logo);
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.setWidth("100%");
        header.addClassName("header");
        header.getStyle().set("background-color", "#1a1a1a");
        addToNavbar(header);
    }

    private void createDrawer() {
        var reports = new RouterLink("Reports", ReportsView.class);
        reports.setHighlightCondition(HighlightConditions.sameLocation());
        var results = new RouterLink("Results", ResultsView.class);
        results.setHighlightCondition(HighlightConditions.sameLocation());
        var swagger = new RouterLink("Swagger", SwaggerView.class);
        results.setHighlightCondition(HighlightConditions.sameLocation());
        var about = new RouterLink("About", AboutView.class);
        results.setHighlightCondition(HighlightConditions.sameLocation());

        Tabs tabs = new Tabs(new Tab(reports), new Tab(results), new Tab(swagger), new Tab(about));
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        tabs.setSizeFull();

        var menu = new VerticalLayout(tabs);
        menu.setHeightFull();
        menu.getStyle().set("background-color", "#1a1a1a");

        addToDrawer(menu);
    }
}
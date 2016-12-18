/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.stmiktime.stea.ui.commons;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import id.ac.stmiktime.stea.navigator.SteaNavigator;
import id.ac.stmiktime.stea.ui.students.StudentLayoutFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author zigic
 */
@SpringUI(path = SteaMainUI.NAME)
@Title(" S T E A")
@Theme("valo")
//@Theme("chameleon")
//@Theme("reindeer")
//@Theme("runo")
//@Theme("liferay")
public class SteaMainUI extends UI {

    public static final String NAME = "/ui";
    private Panel changeTab = new Panel();

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private SpringViewProvider viewProvider;

    @Autowired
    private SteaLogoLayoutFactory steaLogoLayoutFactory;

    @Autowired
    private SteaMenuFactory steaMenuFactory;

    @Override
    protected void init(VaadinRequest request) {
        changeTab.setWidth("100%");
        VerticalLayout rootlayout = new VerticalLayout();
        rootlayout.setSizeFull();
        rootlayout.setMargin(true);

        Panel contentPanel = new Panel();
        contentPanel.setWidth("75%");
        contentPanel.setHeight("100%");

        Panel logoPanel = new Panel();
        logoPanel.setWidth("75%");
        logoPanel.setSizeUndefined();

        HorizontalLayout uiLayout = new HorizontalLayout();
        uiLayout.setSizeFull();
        uiLayout.setMargin(true);

        //logo
        Component logo = steaLogoLayoutFactory.createComponent();
        Component menu = steaMenuFactory.createComponent();

        uiLayout.addComponent(menu);
        uiLayout.addComponent(changeTab);
        uiLayout.setComponentAlignment(changeTab, Alignment.TOP_CENTER);
        uiLayout.setComponentAlignment(menu, Alignment.TOP_CENTER);
        uiLayout.setExpandRatio(menu, 1);
        uiLayout.setExpandRatio(changeTab, 2);

        logoPanel.setContent(logo);
        contentPanel.setContent(uiLayout);

        rootlayout.addComponent(logoPanel);
        rootlayout.addComponent(contentPanel);
        rootlayout.setComponentAlignment(logoPanel, Alignment.TOP_CENTER);
        rootlayout.setComponentAlignment(contentPanel, Alignment.MIDDLE_CENTER);
        rootlayout.setExpandRatio(contentPanel, 1);

        initNavigator();
        setContent(rootlayout);
    }

    private void initNavigator() {
        SteaNavigator navigator = new SteaNavigator(this, changeTab);
        applicationContext.getAutowireCapableBeanFactory().autowireBean(navigator);
        navigator.addProvider(viewProvider);
        navigator.navigateTo(StudentLayoutFactory.NAME);
    }

}

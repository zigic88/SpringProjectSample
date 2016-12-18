/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.stmiktime.stea.ui.commons;

import com.vaadin.data.Property;
import com.vaadin.ui.Component;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;
import id.ac.stmiktime.stea.navigator.SteaNavigator;
import id.ac.stmiktime.stea.utils.StringUtils;

/**
 *
 * @author zigic
 */
@org.springframework.stereotype.Component
public class SteaMenuFactory implements UIComponentBuilder {

    private Tree mainMenu;

    private class SteaMenu extends VerticalLayout implements  Property.ValueChangeListener{

        private Tree mainMenu;

        public SteaMenu init() {
            mainMenu = new Tree();
            mainMenu.addValueChangeListener(this);
            return this;
        }

        public SteaMenu layout() {
            setWidth("100%");
            setHeightUndefined();

            mainMenu.addItem(StringUtils.MENU_STUDENT.getString());
            mainMenu.addItem(StringUtils.MENU_UNIVERSITY.getString());

            mainMenu.expandItem(StringUtils.MENU_STUDENT.getString());
            mainMenu.expandItem(StringUtils.MENU_UNIVERSITY.getString());

            mainMenu.addItem(StringUtils.MENU_ADD_STUDENT.getString());
            mainMenu.addItem(StringUtils.MENU_REMOVE_STUDENT.getString());
            mainMenu.setChildrenAllowed(StringUtils.MENU_ADD_STUDENT.getString(), false);
            mainMenu.setChildrenAllowed(StringUtils.MENU_REMOVE_STUDENT.getString(), false);
            mainMenu.setParent(StringUtils.MENU_ADD_STUDENT.getString(), StringUtils.MENU_STUDENT.getString());
            mainMenu.setParent(StringUtils.MENU_REMOVE_STUDENT.getString(), StringUtils.MENU_STUDENT.getString());

            mainMenu.addItem(StringUtils.MENU_OPERATIONS.getString());
            mainMenu.setChildrenAllowed(StringUtils.MENU_OPERATIONS.getString(), false);
            mainMenu.setParent(StringUtils.MENU_OPERATIONS.getString(), StringUtils.MENU_UNIVERSITY.getString());
            addComponent(mainMenu);

            return this;
        }

        @Override
        public void valueChange(Property.ValueChangeEvent event) {
            String selectedItemPath = (String) event.getProperty().getValue();
            if (selectedItemPath==null) return;
            String path = selectedItemPath.toLowerCase().replaceAll("\\s+", "");
            SteaNavigator.navigate(path);
            
        }

    }

    public Component createComponent() {
        return new SteaMenu().init().layout();
    }

}

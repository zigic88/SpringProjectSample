/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.stmiktime.stea.ui.commons;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author zigic
 */
@org.springframework.stereotype.Component
public class SteaLogoLayoutFactory implements UIComponentBuilder {

    private class logoLayout extends VerticalLayout {

        private Embedded logo;

        public logoLayout init() {
            logo = new Embedded();
            logo.setSource(new ThemeResource("../../images/logo_sample.png"));
            logo.setWidth("400px");
            logo.setHeight("270px");
            return this;  
        }
        
        public logoLayout layout(){
            addComponent(logo);
            setComponentAlignment(logo, Alignment.MIDDLE_CENTER);
            return this;
        }
    }

    @Override
    public Component createComponent() {
        return new logoLayout().init().layout();
    }

}

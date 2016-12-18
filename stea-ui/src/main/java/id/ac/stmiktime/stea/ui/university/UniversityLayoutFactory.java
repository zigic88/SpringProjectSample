/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.stmiktime.stea.ui.university;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import id.ac.stmiktime.stea.ui.commons.SteaMainUI;

/**
 *
 * @author zigic
 */

@SpringView(name = UniversityLayoutFactory.NAME, ui=SteaMainUI.class)
public class UniversityLayoutFactory extends  VerticalLayout implements View{
    public static final String NAME= "operations";

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        addComponent(new Label("University Layout"));
    }
    
}

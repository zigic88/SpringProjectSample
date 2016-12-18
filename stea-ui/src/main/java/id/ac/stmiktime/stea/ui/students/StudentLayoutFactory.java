/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.stmiktime.stea.ui.students;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import id.ac.stmiktime.stea.ui.commons.SteaMainUI;
import id.ac.stmiktime.stea.utils.StudentStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author zigic
 */
@SpringView(name = StudentLayoutFactory.NAME, ui = SteaMainUI.class)
public class StudentLayoutFactory extends VerticalLayout implements View, StudentSavedListener {

    public static final String NAME = "addstudent";

    @Autowired
    private AddStudentMainLayoutFactory mainLayoutFactory;

    @Autowired
    private ShowAllStudentLayoutFactory showStudentLayoutFactory;

    private TabSheet tabSheet;

    private void addLayout() {
        setMargin(true);
        tabSheet = new TabSheet();
        tabSheet.setWidth("100%");

        Component addStudentMainTab = mainLayoutFactory.createComponent(this);
        Component showStudentMainTab = showStudentLayoutFactory.createComponent();
        tabSheet.addTab(addStudentMainTab, StudentStringUtils.MAIN_MENU.getString());
        tabSheet.addTab(showStudentMainTab, StudentStringUtils.SHOW_ALL_STUDENTS.getString());
        addComponent(tabSheet);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        removeAllComponents();
        addLayout();
    }

    @Override
    public void studentSaved() {
         showStudentLayoutFactory.refreshTable();
    }

}

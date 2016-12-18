/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.stmiktime.stea.ui.students;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import id.ac.stmiktime.stea.model.entity.Student;
import id.ac.stmiktime.stea.service.showallstudents.ShowAllStudentsService;
import id.ac.stmiktime.stea.ui.commons.UIComponentBuilder;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author zigic
 */
@org.springframework.stereotype.Component
public class ShowAllStudentLayoutFactory implements UIComponentBuilder {

    private List<Student> students;
    private BeanItemContainer<Student> container;



    private class ShowAllStudentLayout extends VerticalLayout {

        private Grid studentTable;

        public ShowAllStudentLayout init() {
            setMargin(true);
            container = new BeanItemContainer<>(Student.class, students);
            studentTable = new Grid(container);
            studentTable.setColumnOrder("firstName", "lastName", "age", "gender");
            studentTable.removeColumn("id");
            studentTable.setImmediate(true);
            return this;
        }

        public ShowAllStudentLayout load() {
            students = showAllStudentsService.getAllStudents();
            return this;
        }

        public ShowAllStudentLayout layout() {
            addComponent(studentTable);
            return this;
        }

    }
    
    public    void refreshTable() {
        students = showAllStudentsService.getAllStudents();
        container.removeAllItems();
        container.addAll(students);
    }
        
    @Autowired
    private ShowAllStudentsService showAllStudentsService;

    @Override
    public Component createComponent() {
        return new ShowAllStudentLayout().load().init().layout();
    }

}

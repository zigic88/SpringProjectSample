/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.stmiktime.stea.ui.students;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.MultiSelectMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.MultiSelectionModel;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import id.ac.stmiktime.stea.model.entity.Student;
import id.ac.stmiktime.stea.service.removeStudent.RemoveStudentsService;
import id.ac.stmiktime.stea.service.showallstudents.ShowAllStudentsService;
import id.ac.stmiktime.stea.ui.commons.SteaMainUI;
import id.ac.stmiktime.stea.utils.NotificationMessage;
import id.ac.stmiktime.stea.utils.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author zigic
 */
@SpringView(name = RemoveStudentLayoutFactory.NAME, ui = SteaMainUI.class)
public class RemoveStudentLayoutFactory extends VerticalLayout implements View, Button.ClickListener {

    public static final String NAME = "removestudent";
    private Grid removeStudentTable;
    private Button removeStudentButton;
    private List<Student> students;
    @Autowired
    private ShowAllStudentsService allStudentsService;

    @Autowired
    private RemoveStudentsService removeStudentService;
    
    private void addLayout() {
        removeStudentButton = new Button("Remove");
        setMargin(true);
        BeanItemContainer<Student> container = new BeanItemContainer<Student>(Student.class, students);
        removeStudentTable = new Grid(container);
        removeStudentTable.setColumnOrder("firstName", "lastName", "age", "gender");
        removeStudentTable.removeColumn("id");
        removeStudentTable.setImmediate(true);
        removeStudentTable.setSelectionMode(Grid.SelectionMode.MULTI);

        removeStudentButton.addClickListener(this);
        removeStudentButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
        addComponents(removeStudentTable, removeStudentButton);
    }

    private void loadStudents() {
        students = allStudentsService.getAllStudents();
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        MultiSelectionModel selectionModel = (MultiSelectionModel) removeStudentTable.getSelectionModel();
        for (Object selectedItem : selectionModel.getSelectedRows()) {
            Student student = (Student) selectedItem;
            removeStudentTable.getContainerDataSource().removeItem(student);
            removeStudentService.removeStudent(student);
        }
        Notification.show(NotificationMessage.STUDENT_DELETE_TITLE.getString(), NotificationMessage.STUDENT_DELETE_MESSAGE.getString(),
                Notification.Type.HUMANIZED_MESSAGE);
        removeStudentTable.getSelectionModel().reset();
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        if (removeStudentTable != null) {
            return;
        }
        loadStudents();
        addLayout();
    }

}

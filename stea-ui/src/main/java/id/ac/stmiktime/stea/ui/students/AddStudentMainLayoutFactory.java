/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.stmiktime.stea.ui.students;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import id.ac.stmiktime.stea.model.entity.Student;
import id.ac.stmiktime.stea.service.addstudent.AddStudentService;
import id.ac.stmiktime.stea.utils.Gender;
import id.ac.stmiktime.stea.utils.NotificationMessage;
import id.ac.stmiktime.stea.utils.StudentStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author zigic
 */
@org.springframework.stereotype.Component
public class AddStudentMainLayoutFactory {

    private class AddStudentMainLayout extends VerticalLayout implements Button.ClickListener {

        private TextField firstName;
        private TextField lastName;
        private TextField age;
        private ComboBox gender;
        private Button saveButton;
        private Button clearButton;

        private BeanFieldGroup<Student> fieldGroup;
        private Student student;
        private StudentSavedListener studentSavedListener;

        public AddStudentMainLayout(StudentSavedListener studentSavedListener) {
            this.studentSavedListener = studentSavedListener;
        }

        public AddStudentMainLayout init() {
            fieldGroup = new BeanFieldGroup<Student>(Student.class);
            student = new Student();

            firstName = new TextField(StudentStringUtils.FIRST_NAME.getString());
            lastName = new TextField(StudentStringUtils.LAST_NAME.getString());
            age = new TextField(StudentStringUtils.AGE.getString());
            gender = new ComboBox(StudentStringUtils.GENDER.getString());

            saveButton = new Button(StudentStringUtils.SAVE_BUTTON.getString());
            clearButton = new Button(StudentStringUtils.CLEAR_BUTTON.getString());

            saveButton.addStyleName(ValoTheme.BUTTON_FRIENDLY);
            clearButton.addStyleName(ValoTheme.BUTTON_PRIMARY);

            saveButton.addClickListener(this);
            clearButton.addClickListener(this);

            gender.addItem(Gender.MALE.getString());
            gender.addItem(Gender.FEMALE.getString());

            firstName.setNullRepresentation("");
            lastName.setNullRepresentation("");
            age.setNullRepresentation("");

            return this;
        }

        public AddStudentMainLayout bind() {
            fieldGroup.bindMemberFields(this);
            fieldGroup.setItemDataSource(student);
            return this;
        }

        public Component layout() {
            setMargin(true);
            GridLayout gridLayout = new GridLayout(2, 3);
            gridLayout.setSizeUndefined();
            gridLayout.setSpacing(true);

            gridLayout.addComponent(firstName, 0, 0);
            gridLayout.addComponent(lastName, 1, 0);

            gridLayout.addComponent(age, 0, 1);
            gridLayout.addComponent(gender, 1, 1);

            gridLayout.addComponent(new HorizontalLayout(saveButton, clearButton), 0, 2);
            return gridLayout;
        }

        @Override
        public void buttonClick(Button.ClickEvent event) {
            if (event.getSource() == this.saveButton) {
                //save
                save();
            } else {
                //clear
                clearField();
            }

        }

        private void save() {
            try {
                fieldGroup.commit();
            } catch (CommitException e) {
                Notification.show(NotificationMessage.STUDENT_SAVE_ERROR_TITLE.getString(),
                        NotificationMessage.STUDENT_SAVE_ERROR_MESSAGE.getString(), Notification.Type.ERROR_MESSAGE);
                return;
            }
            addStudentService.saveStudent(student);
            studentSavedListener.studentSaved();
            clearField();
            Notification.show("SAVE", "Student has been saved", Notification.Type.HUMANIZED_MESSAGE);

        }

        private void clearField() {
            firstName.setValue(null);
            lastName.setValue(null);
            gender.setValue(null);
            age.setValue(null);
        }

    }

    @Autowired
    private AddStudentService addStudentService;

    public Component createComponent(StudentSavedListener studentSavedListener) {
        return new AddStudentMainLayout(studentSavedListener).init().bind().layout();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.stmiktime.stea.service.addstudent;

import id.ac.stmiktime.stea.model.entity.Student;
import id.ac.stmiktime.stea.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author zigic
 */

@Service
public class AddStudentServiceImpl implements AddStudentService{
    @Autowired
    private StudentRepository studentRepository;
    
    @Override
    public void saveStudent(Student studentDAO) {
        Student student = new Student();
        student.setFirstName(studentDAO.getFirstName());
        student.setLastName(studentDAO.getLastName());
        student.setAge(studentDAO.getAge());
        student.setGender(studentDAO.getGender());
        studentRepository.save(student);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.stmiktime.stea.service.showallstudents;

import id.ac.stmiktime.stea.model.entity.Student;
import id.ac.stmiktime.stea.repository.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author zigic
 */

@Service
public class ShowAllStudentsServiceImpl implements ShowAllStudentsService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

}

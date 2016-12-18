/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.stmiktime.stea.service.removeStudent;

import id.ac.stmiktime.stea.model.entity.Student;
import id.ac.stmiktime.stea.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author zigic
 */
@Service
public class RemoveStudentsServiceImpl implements RemoveStudentsService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void removeStudent(Student student) {
        studentRepository.delete(student);
    }

}

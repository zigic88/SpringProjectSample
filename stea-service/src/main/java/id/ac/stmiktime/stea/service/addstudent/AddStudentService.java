/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.stmiktime.stea.service.addstudent;

import id.ac.stmiktime.stea.model.entity.Student;

/**
 *
 * @author zigic
 */
public interface AddStudentService {
    
    public void saveStudent(Student studentDAO);
    
}

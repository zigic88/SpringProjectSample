/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.stmiktime.stea.repository;

import id.ac.stmiktime.stea.model.entity.Student;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author zigic
 */

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{
    
    @Query("select s from Student s order by s.firstName")
    List<Student>getAllStudents();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.stmiktime.stea.repository.security;

import id.ac.stmiktime.stea.model.entity.User;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author zigic
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    @Query("select u from User u where u.username=:username")
    User findbyUsername(@Param("username") String username);

}

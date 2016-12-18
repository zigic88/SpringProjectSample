/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.stmiktime.stea.utils;

/**
 *
 * @author zigic
 */
public enum StringUtils {
    MENU_STUDENT("STUDENT"),
    MENU_UNIVERSITY("UNIVERSITY"),
    MENU_ADD_STUDENT("Add Student"),
    MENU_REMOVE_STUDENT("Remove Student"),
    MENU_OPERATIONS("Operations")
    ; 
    
    private final String string;
    
    private StringUtils(String string){
        this.string = string;
    }
    
    public String getString(){
        return this.string;
    }
}

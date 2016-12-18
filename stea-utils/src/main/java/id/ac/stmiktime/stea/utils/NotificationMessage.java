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
public enum NotificationMessage {
    STUDENT_SAVE_ERROR_TITLE("ERROR"),
    STUDENT_SAVE_ERROR_MESSAGE("Fields must be filled"),
    STUDENT_DELETE_TITLE("Remove"),
    STUDENT_DELETE_MESSAGE("Student (s) successfully removed");
    
    private final String string;

    private NotificationMessage(String string) {
        this.string = string;
    }

    public String getString() {
        return this.string;
    }
}

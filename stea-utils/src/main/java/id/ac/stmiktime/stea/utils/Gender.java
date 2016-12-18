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
public enum Gender {
    MALE("Male"), 
    FEMALE("Female");

    private final String string;

    private Gender(String string) {
        this.string = string;
    }

    public String getString() {
        return this.string;
    }

}

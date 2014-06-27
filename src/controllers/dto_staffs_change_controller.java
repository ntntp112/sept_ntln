/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.Arrays;
import javafx.collections.ListChangeListener;
import javafx.collections.MapChangeListener;
import models.dto_song;
import models.dto_staff;

/**
 *
 * @author NTN
 */
public class dto_staffs_change_controller implements ListChangeListener {

    @Override
    public void onChanged(Change c) {
        System.out.println("Detected a change! ");

        while (c.next()) {
            System.out.println("Was added? " + c.wasAdded());
            System.out.println("Was removed? " + c.wasRemoved());
            System.out.println("Was replaced? " + c.wasReplaced());
            System.out.println("Was permutated? " + c.wasPermutated());
        }
        for (Object so : c.getAddedSubList()) {
            dto_staff s = (dto_staff) so;
            System.out.println(s.getUsername() + " " + s.getEmail()+"\n");
        }
    }
}
    
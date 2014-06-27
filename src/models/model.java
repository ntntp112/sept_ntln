/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import controllers.dto_staffs_change_controller;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

/**
 *
 * @author NTN
 */
public class model extends Observable{

    private dataobject data_object;

    public model() {
        intialize();
    }

    private void intialize() {
        data_object = new dataobject();
    }
    
    
}

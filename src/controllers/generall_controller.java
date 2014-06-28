/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import models.model;

/**
 *
 * @author NTN
 */
public class generall_controller {
    private final model model;

    public generall_controller(model model) {
        this.model = model;
    }
    
    public void write_object_to_file(){
        model.write_data_object_to_file();
    }
}

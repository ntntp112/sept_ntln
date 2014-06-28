/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import controllers.generall_controller;
import java.util.Observable;

/**
 *
 * @author NTN
 */
public class model extends Observable{

    private dataobject data_object;
    private fileIO fileIO;


    public dataobject getData_object() {
        return data_object;
    }
    
    public model() {
        fileIO = new fileIO();
    }

    public void initialize() {
        data_object = (dataobject) fileIO.loaddata();
        if(data_object == null){
            data_object = new dataobject();
        }
        
        //test
        write_data_object_to_file();
    }

    public void write_data_object_to_file() {
        fileIO.savedata(data_object);
    }

    @Override
    protected synchronized void setChanged() {
        
    }
    
    
    
}

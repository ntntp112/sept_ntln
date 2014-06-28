/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sept_ntln;

import controllers.generall_controller;
import javafx.application.Application;
import javafx.stage.Stage;
import models.model;
import views.stage_login;
import views.stage_main;
import views.stage_song;
import views.stage_staff;

/**
 *
 * @author NTN
 */
public class Sept_ntln extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        stage_main stgmain = new stage_main();
//        stgmain.show();
////        
//        stage_staff stgsatff= new stage_staff();
//        stgsatff.show();
//        
//        stage_song stgsong = new stage_song();
//        stgsong.show();
//        
//        stage_login stglogin = new stage_login();
//        stglogin.show();

        app_initialize();
    }
    model m;
    generall_controller ctrler;
    
    private void app_initialize() {
        //model
        m = new model();
        
        //controller
        ctrler = new generall_controller(m);
        
        //view
        
        
        //mapping
        
        m.initialize();
    }


}

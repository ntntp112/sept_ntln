/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import java.util.Observable;
import java.util.Observer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author NTN
 */
public class stage_login extends Stage implements Observer{

    public stage_login() {
        initialize();
    }

    private void initialize() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome to NTLN");
        scenetitle.setId("welcome-text");
        grid.add(scenetitle, 0, 0, 2, 1);

        Label lbl_username = new Label("User Name:");
        grid.add(lbl_username, 0, 1);

        TextField txt_user = new TextField();
        grid.add(txt_user, 1, 1);

        Label lbl_password = new Label("Password:");
        grid.add(lbl_password, 0, 2);

        PasswordField pw_password = new PasswordField();
        grid.add(pw_password, 1, 2);

        Button btn_login = new Button("Log in");
        HBox hb_btn_login = new HBox(10);
        hb_btn_login.setAlignment(Pos.BOTTOM_RIGHT);
        hb_btn_login.getChildren().add(btn_login);
        grid.add(hb_btn_login, 1, 4);
        
        Scene scene = new Scene(grid, 300, 275);
        this.setScene(scene);
        scene.getStylesheets().add
        (stage_login.class.getResource("/css/stage_login.css").toExternalForm());
    }

    @Override
    public void update(Observable o, Object o1) {
        
    }
    
}

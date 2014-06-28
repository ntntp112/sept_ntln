/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import models.dto_song;

/**
 *
 * @author NTN
 */
public class stage_song extends Stage{
    BorderPane border_pane;
    MenuBar menubar;
    HBox statusbar;
    Scene scene;

    public stage_song() {
        initialize();
    }

    private void initialize() {
        //Create border layout
        border_pane = new BorderPane();

        //Border Layout Center
        SplitPane splitpane_main = new SplitPane();
        AnchorPane left_pane = new AnchorPane();
        AnchorPane right_pane = new AnchorPane();
        splitpane_main.setOrientation(Orientation.HORIZONTAL);
        splitpane_main.setFocusTraversable(false);
        splitpane_main.setDividerPositions(0.2, 0.8);
        splitpane_main.getItems().add(left_pane);
        splitpane_main.getItems().add(right_pane);

        //Split Pane Left
        //Data
        TreeItem<dto_song> root = new TreeItem<>(new dto_song(0,"","","","",0f));
        ObservableList<dto_song> songs = FXCollections.observableArrayList(new dto_song(2, "Song1","","","",0f),new dto_song(2, "Song2","","","",0f),new dto_song(3, "Song4","","","",0f));
        songs.stream().forEach((song) -> {
            root.getChildren().add(new TreeItem<>(song));
        });
        
        //End_Data
        
        TreeTableView ttv_song = new TreeTableView(root);

        TreeTableColumn<dto_song, Integer> col_code = new TreeTableColumn<>("Code");
        col_code.setPrefWidth(150);
//        col_code.setCellValueFactory(
//                (TreeTableColumn.CellDataFeatures<dto_song, Integer> param) -> 
//                        new ReadOnlyIntegerWrapper(param.getValue().getValue().getCode());
        
        TreeTableColumn<dto_song, String> col_title = new TreeTableColumn<>("Title");
        col_title.setPrefWidth(150);
        col_title.setCellValueFactory((TreeTableColumn.CellDataFeatures<dto_song, String> param) -> new ReadOnlyStringWrapper(param.getValue().getValue().getTitle()));
        
        ttv_song.getColumns().addAll(col_title);
        
        
        ScrollPane scrollpane_song = new ScrollPane(ttv_song);
        left_pane.getChildren().add(scrollpane_song);

        AnchorPane.setTopAnchor(scrollpane_song, 1.0);
        AnchorPane.setBottomAnchor(scrollpane_song, 1.0);
        AnchorPane.setRightAnchor(scrollpane_song, 1.0);
        AnchorPane.setLeftAnchor(scrollpane_song, 1.0);
        
        //Split Pane Right
        BorderPane borderpane_right = new BorderPane();
        GridPane girdpane_right = new GridPane();
        girdpane_right.setPadding(new Insets(10, 10, 10, 10));
        
        girdpane_right.setAlignment(Pos.CENTER);
        girdpane_right.setHgap(10);
        girdpane_right.setVgap(10);
        girdpane_right.setPadding(new Insets(10, 10, 10, 10));
        
        Label lbl_Title = new Label("Title");
        girdpane_right.add(lbl_Title, 0, 0);
        TextField txt_Title = new TextField();
        girdpane_right.add(txt_Title, 2, 0);
        
        HBox box_command = new HBox();
        Button btn_Update = new Button("Update");
        
        
        box_command.getChildren().add(btn_Update);
        
        borderpane_right.setBottom(box_command);
        borderpane_right.setCenter(girdpane_right);
        right_pane.getChildren().add(borderpane_right);
        
        AnchorPane.setTopAnchor(borderpane_right, 1.0);
        AnchorPane.setBottomAnchor(borderpane_right, 1.0);
        AnchorPane.setRightAnchor(borderpane_right, 1.0);
        AnchorPane.setLeftAnchor(borderpane_right, 1.0);
        
        //Menu Bar
        menubar = new MenuBar();
        menubar.getMenus().add(new Menu("My menu"));
        statusbar = new HBox();

        border_pane.setTop(menubar);
        border_pane.setCenter(splitpane_main);
        border_pane.setBottom(statusbar);

        scene = new Scene(border_pane);
        this.setScene(scene);
        this.setTitle("Welcome staff!");

        //Window setting
        Rectangle2D screen = Screen.getPrimary().getVisualBounds();
        this.setX(screen.getMinX() + screen.getWidth() / 8);
        this.setY(screen.getMinY() + screen.getHeight() / 8);
        this.setWidth(screen.getWidth() * 3 / 4);
        this.setHeight(screen.getHeight() * 3 / 4);

    }
}



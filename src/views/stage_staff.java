/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.util.Arrays;
import java.util.List;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Screen;
import javafx.stage.Stage;
import models.dto_staff;

/**
 *
 * @author NTN
 */
public class stage_staff extends Stage {

    BorderPane border_pane;
    MenuBar menubar;
    HBox statusbar;
    Scene scene;

    public stage_staff() {
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
        TreeItem<dto_staff> root = new TreeItem<>(new dto_staff("Staffs", ""));
        ObservableList<dto_staff> staffs = FXCollections.observableArrayList(new dto_staff("ntn", "ntn@gmail.com"), new dto_staff("liem", "liem@gmail.com"));
        staffs.stream().forEach((staff) -> {
            root.getChildren().add(new TreeItem<>(staff));
        });
        
        //End_Data
        
        TreeTableView ttv_staff = new TreeTableView(root);

        TreeTableColumn<dto_staff, String> col_username = new TreeTableColumn<>("Username");
        col_username.setPrefWidth(150);
        col_username.setCellValueFactory((TreeTableColumn.CellDataFeatures<dto_staff, String> param) -> new ReadOnlyStringWrapper(param.getValue().getValue().getUsername()));
        
        TreeTableColumn<dto_staff, String> col_email = new TreeTableColumn<>("Email");
        col_email.setPrefWidth(150);
        col_email.setCellValueFactory((TreeTableColumn.CellDataFeatures<dto_staff, String> param) -> new ReadOnlyStringWrapper(param.getValue().getValue().getEmail()));
        
        ttv_staff.getColumns().addAll(col_username,col_email);
        
        
        ScrollPane scrollpane_staff = new ScrollPane(ttv_staff);
        left_pane.getChildren().add(scrollpane_staff);

        AnchorPane.setTopAnchor(scrollpane_staff, 1.0);
        AnchorPane.setBottomAnchor(scrollpane_staff, 1.0);
        AnchorPane.setRightAnchor(scrollpane_staff, 1.0);
        AnchorPane.setLeftAnchor(scrollpane_staff, 1.0);
        
        //Split Pane Right
        GridPane girdpane_right = new GridPane();
        
        
        
        right_pane.getChildren().add(girdpane_right);
        
        //Menu Bar
        menubar = new MenuBar();
        menubar.getMenus().add(new Menu("My menu"));
        statusbar = new HBox();

        border_pane.setTop(menubar);
        border_pane.setCenter(splitpane_main);
        border_pane.setBottom(statusbar);

        scene = new Scene(border_pane);
        this.setScene(scene);
        this.setTitle("Stage Staff");

        //Window setting
        Rectangle2D screen = Screen.getPrimary().getVisualBounds();
        this.setX(screen.getMinX() + screen.getWidth() / 8);
        this.setY(screen.getMinY() + screen.getHeight() / 8);
        this.setWidth(screen.getWidth() * 3 / 4);
        this.setHeight(screen.getHeight() * 3 / 4);

    }
}


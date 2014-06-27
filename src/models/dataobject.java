/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.util.Collections;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

/**
 *
 * @author NTN
 */
public class dataobject {
    ObservableMap<String, dto_staff> om_staffs;
    ObservableMap<Integer, dto_song> om_songs;
    
    public dataobject() {
        om_staffs = FXCollections.observableHashMap();
        om_staffs.addListener(new MapChangeListener<String, dto_staff>() {

            @Override
            public void onChanged(MapChangeListener.Change<? extends String, ? extends dto_staff> change) {
                if (change.wasAdded()) {
                    System.out.println("Add "+change.getKey());
                }
                if (change.wasRemoved()) {
                    System.out.println("Remove "+change.getKey());
                }
            }
        });
        
        test();
    }

    private void test() {
        om_staffs.put("ntntp112",new dto_staff("ntntp112", "hahahaha"));
        om_staffs.put("nhn",new dto_staff("nhn", "nhn@nhn.com"));
        om_staffs.remove("nhn");
        om_staffs.get("ntntp112").setEmail("ntn@ntn.com");
    }
    
    public ObservableList get_staffs_list(){
        ObservableList stafflist = FXCollections.observableList((List<dto_staff>) om_staffs.values());
        return stafflist;
    }
    
    public void add(){
        
    }
}

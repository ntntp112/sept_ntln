/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controllers.generall_controller;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author NTN
 */
public final class dataobject implements Serializable{

    HashMap<String, dto_staff> om_staffs;
    HashMap<Integer, dto_song> om_songs;

    
    //contructor
    public dataobject() {
        initialize();

        //test();
    }
    
    //initialize somethings
    private void initialize(){
        om_staffs = new HashMap<>();
        om_songs = new HashMap<>();
    }
    
    // nerver mind...
    private void test() {
        om_staffs.put("ntntp112", new dto_staff("ntntp112", "hahahaha"));
        om_staffs.put("nhn", new dto_staff("nhn", "nhn@nhn.com"));
        om_staffs.remove("nhn");
        om_staffs.get("ntntp112").setEmail("ntn@ntn.com");
        get_staffs_list();
    }

    // get list of staff 
    public ObservableList get_staffs_list() {
        return FXCollections.observableList(om_staffs.values().stream().filter(s -> s.isRemove()).collect(Collectors.toList()));
    }

    //add staff to data object
    public void add_staff(dto_staff staff_input) {
        if (!om_staffs.containsKey(staff_input.getUsername())) {
            om_staffs.put(staff_input.getUsername(), staff_input);
        }
    }

    //remove staff from data object search by dto
    public void remove_staff(dto_staff staff_input) {
        if (om_staffs.containsKey(staff_input.getUsername())) {
            om_staffs.get(staff_input.getUsername()).setRemove(true);
        }
    }

    //remove staff from data object search by username
    public void remove_staff(String staff_username_input) {
        if (om_staffs.containsKey(staff_username_input)) {
            om_staffs.get(staff_username_input).setRemove(true);
        }
    }
    
    //update staff
    public void update_staff(dto_staff staff_input) {
        if (om_staffs.containsKey(staff_input.getUsername())) {
            om_staffs.remove(staff_input.getUsername());
            om_staffs.put(staff_input.getUsername(), staff_input);
        }
    }

    //get list of songs
    public ObservableList get_songs_list() {
        return FXCollections.observableList(om_songs.values().stream().filter(s -> s.isRemove()).collect(Collectors.toList()));
    }

    //add song to data object
    public void add_song(dto_song song_input) {
        Integer max_key = 1 + om_songs.keySet().stream().max(Integer::max).get();
        song_input.setCode(max_key);
        om_songs.put(max_key, song_input);
    }

    //remove song from data object search by dto
    public void remove_song(dto_song song_input) {
        if (om_songs.containsKey(song_input.getCode())) {
            om_songs.get(song_input.getCode()).setRemove(true);
        }
    }

    //remove song from data object search by username
    public void remove_song(int song_code_input) {
        if (om_songs.containsKey(song_code_input)) {
            om_songs.get(song_code_input).setRemove(true);
        }
    }
    
    //update song
    public void update_song(dto_song song_input) {
        if (om_songs.containsKey(song_input.getCode())) {
            om_songs.remove(song_input.getCode());
            om_songs.put(song_input.getCode(), song_input);
        }
    }
    
    //Testing for search - not implement yet
    public static boolean like(String str, String expr) {
        expr = expr.toLowerCase(); // ignoring locale for now
        expr = expr.replace(".", "\\."); // "\\" is escaped to "\" (thanks, Alan M)
        // ... escape any other potentially problematic characters here
        expr = expr.replace("?", ".");
        expr = expr.replace("%", ".*");
        str = str.toLowerCase();
        return str.matches(expr);
    }
    //Done
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author HNguyen
 */
public class dto_song {
    private final IntegerProperty code;

    public int getCode() {
        return code.get();
    }

    public void setCode(int value) {
        code.set(value);
    }

    public IntegerProperty codeProperty() {
        return code;
    }
    
    
    private final StringProperty title;

    public String getTitle() {
        return title.get();
    }

    public void setTitle(String value) {
        title.set(value);
    }

    public StringProperty titleProperty() {
        return title;
    }
    private final StringProperty artist;

    public String getArtist() {
        return artist.get();
    }

    public void setArtist(String value) {
        artist.set(value);
    }

    public StringProperty artistProperty() {
        return artist;
    }
    private final StringProperty albumName;

    public String getAlbumName() {
        return albumName.get();
    }

    public void setAlbumName(String value) {
        albumName.set(value);
    }

    public StringProperty albumNameProperty() {
        return albumName;
    }
    private final StringProperty lyrics;

    public String getLyrics() {
        return lyrics.get();
    }

    public void setLyrics(String value) {
        lyrics.set(value);
    }

    public StringProperty lyricsProperty() {
        return lyrics;
    }
    private final FloatProperty duration;

    public float getDuration() {
        return duration.get();
    }

    public void setDuration(float value) {
        duration.set(value);
    }

    public FloatProperty durationProperty() {
        return duration;
    }

    public dto_song(int code, String title, String artist, String albumName, String lyrics, float duration) {
        this.albumName = new SimpleStringProperty(albumName);
        this.artist = new SimpleStringProperty(artist);
        this.title = new SimpleStringProperty(title);
        this.code = new SimpleIntegerProperty(code);
        this.lyrics = new SimpleStringProperty(lyrics);
        this.duration = new SimpleFloatProperty(duration);
        
    }
    private final BooleanProperty remove = new SimpleBooleanProperty();

    public boolean isRemove() {
        return remove.get();
    }

    public void setRemove(boolean value) {
        remove.set(value);
    }

    public BooleanProperty removeProperty() {
        return remove;
    }
    
}

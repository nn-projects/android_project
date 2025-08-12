package com.example.assignment1.provider;

//import androidx.room.ColumnInfo;
//import androidx.room.Entity;
//import androidx.room.PrimaryKey;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = Event.TABLE_NAME)
public class Event {

    public static final String TABLE_NAME = "events";
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")

    private int id;
    @ColumnInfo(name = "eventId")

    private String eventId;
    @ColumnInfo(name = "eventName")
    private String eventName;
    @ColumnInfo(name = "catID")
    private String catID;
    @ColumnInfo(name = "eventTicNumber")

    private Integer eventTicNumber;
    @ColumnInfo(name = "isEventActive")

    private boolean isEventActive;

    public Event( String eventName, String catID, Integer eventTicNumber,  boolean isEventActive) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.catID = catID;
        this.eventTicNumber = eventTicNumber;
        this.isEventActive = isEventActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getCatID() {
        return catID;
    }

    public void setCatID(String catID) {
        this.catID = catID;
    }

    public Integer getEventTicNumber() {
        return eventTicNumber;
    }

    public void setEventTicNumber(Integer eventTicNumber) {
        this.eventTicNumber = eventTicNumber;
    }

    public boolean isEventActive() {
        return isEventActive;
    }

    public void setEventActive(boolean eventActive) {
        isEventActive = eventActive;
    }


}

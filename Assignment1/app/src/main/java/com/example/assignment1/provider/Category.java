package com.example.assignment1.provider;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = Category.TABLE_NAME)
public class Category {
    public static final String TABLE_NAME = "categories";

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "catId")
    private String catId;
    @ColumnInfo(name = "categoryName")
    private String categoryName;
    @ColumnInfo(name = "eventCount")

    private Integer eventCount;
    @ColumnInfo(name = "isCatActive")

    private boolean isCatActive;
    @ColumnInfo(name = "categoryLocation")
    private String categoryLocation;


    public Category( String categoryName, Integer eventCount, boolean isCatActive, String categoryLocation) {
        this.catId = catId;
        this.categoryName = categoryName;
        this.eventCount = eventCount;
        this.isCatActive = isCatActive;
        this.categoryLocation = categoryLocation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCatId() {return catId;}
    public void setCatId(String catId) {this.catId = catId;}

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getEventCount() {
        return eventCount;
    }

    public void setEventCount(Integer eventCount) {
        this.eventCount = eventCount;
    }

    public boolean isCatActive() {
        return isCatActive;
    }

    public void setCatActive(boolean catActive) {
        isCatActive = catActive;
    }

    public String getCategoryLocation() {
        return categoryLocation;
    }

    public void setCategoryLocation(String categoryLocation) {
        this.categoryLocation = categoryLocation;
    }
}

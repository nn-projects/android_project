package com.example.assignment1.provider;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.assignment1.provider.Event;
import java.util.List;

// Indicates that this interface is a Data Access Object (DAO),
// used for interacting with the database.
@Dao
public interface EventDAO  {
    // // Specifies a database query to retrieve all items from the "items" table. (referenced A.3.4)
    @Query("select * from events")
    LiveData<List<Event>> getAllEvents(); // Returns a LiveData object containing a list of Item objects.

    // Indicates that this method is used to insert data into the database.
    @Insert
    void addEvent(Event event); // Method signature for inserting an Item object into the database.

    @Query("DELETE FROM events")
    void deleteAllEvents();

    @Update
    void update(Event event);
}

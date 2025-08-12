package com.example.assignment1.provider;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.assignment1.provider.Category;
import java.util.List;

// Indicates that this interface is a Data Access Object (DAO),
// used for interacting with the database.
@Dao
public interface CategoryDAO {
    // // Specifies a database query to retrieve all items from the "items" table. (referenced A.3.4)
    @Query("select * from categories")
    LiveData<List<Category>> getAllCategories(); // Returns a LiveData object containing a list of Item objects.

    // Indicates that this method is used to insert data into the database.
    @Insert
    void addCategory(Category category); // Method signature for inserting an Item object into the database.

    @Query("DELETE FROM categories")
    void deleteAllCategories();

    @Update
    void update(Category category);

    @Query("UPDATE categories SET eventCount = eventCount + 1 WHERE catId = :categoryId")
    void incrementEventCount(String categoryId);
}



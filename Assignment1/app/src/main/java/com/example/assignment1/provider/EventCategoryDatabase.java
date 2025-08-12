package com.example.assignment1.provider;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Category.class, Event.class}, version = 2)

public abstract class EventCategoryDatabase extends RoomDatabase {

    // database name, this is important as data is contained inside a file named "card_database"
    public static final String EVENT_CATEGORY_DATABASE = "event_category_database";
    public abstract CategoryDAO categoryDAO();
    public abstract EventDAO eventDAO();

    // marking the instance as volatile to ensure atomic access to the variable
    private static volatile EventCategoryDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    // ExecutorService is a JDK API that simplifies running tasks in asynchronous mode.
    // Generally speaking, ExecutorService automatically provides a pool of threads and an API
    // for assigning tasks to it.
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static EventCategoryDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (EventCategoryDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    EventCategoryDatabase.class, EVENT_CATEGORY_DATABASE)
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}




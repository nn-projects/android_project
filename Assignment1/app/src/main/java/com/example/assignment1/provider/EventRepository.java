package com.example.assignment1.provider;

import android.app.Application;
import androidx.lifecycle.LiveData;
import java.util.List;
import com.example.assignment1.provider.Event;

public class EventRepository {

    // private class variable to hold reference to DAO
    private EventDAO eventDAO;
    // private class variable to temporary hold all the items retrieved and pass outside of this class
    private LiveData<List<Event>> allEventLiveData;

    // constructor to initialise the repository class
   EventRepository(Application application) {
        // get reference/instance of the database
        EventCategoryDatabase db = EventCategoryDatabase.getDatabase(application);

        // get reference to DAO, to perform CRUD operations
        eventDAO = db.eventDAO();

        // once the class is initialised get all the items in the form of LiveData
        allEventLiveData = eventDAO.getAllEvents();
    }

    /**
     * Repository method to get all events
     * @return LiveData of type List<Item>
     */
    LiveData<List<Event>> getAllEvents() {
        return allEventLiveData;
    }

    /**
     * Repository method to insert one single item
     * @param event object containing details of new Item to be inserted
     */
    void insert(Event event) {
        // Executes the database operation to insert the item in a background thread.
        EventCategoryDatabase.databaseWriteExecutor.execute(() -> eventDAO.addEvent(event));
    }
    public void update(Event event) {
        EventCategoryDatabase.databaseWriteExecutor.execute(() -> eventDAO.update(event));
    }

    public void deleteAllEvents() {
        EventCategoryDatabase.databaseWriteExecutor.execute(() -> eventDAO.deleteAllEvents());
    }

}

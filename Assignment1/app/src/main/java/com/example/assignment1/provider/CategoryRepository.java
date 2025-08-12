package com.example.assignment1.provider;

import android.app.Application;
import androidx.lifecycle.LiveData;
import java.util.List;
import com.example.assignment1.provider.Category;

public class CategoryRepository {

    // private class variable to hold reference to DAO
    private CategoryDAO categoryDAO;
    // private class variable to temporary hold all the items retrieved and pass outside of this class
    private LiveData<List<Category>> allCategoryLiveData;

    // constructor to initialise the repository class
    CategoryRepository(Application application) {
        // get reference/instance of the database
        EventCategoryDatabase db = EventCategoryDatabase.getDatabase(application);

        // get reference to DAO, to perform CRUD operations
        categoryDAO = db.categoryDAO();

        // once the class is initialised get all the items in the form of LiveData
        allCategoryLiveData = categoryDAO.getAllCategories();
    }

    /**
     * Repository method to get all categorys
     * @return LiveData of type List<Item>
     */
    LiveData<List<Category>> getAllCategories() {
        return allCategoryLiveData;
    }

    /**
     * Repository method to insert one single item
     * @param category object containing details of new Item to be inserted
     */
    void insert(Category category) {
        EventCategoryDatabase.databaseWriteExecutor.execute(() -> {
            categoryDAO.addCategory(category);

        });
    }
    public void incrementEventCount(String categoryId) {
        categoryDAO.incrementEventCount(categoryId);
    }

    public void update(Category category) {
        EventCategoryDatabase.databaseWriteExecutor.execute(() -> categoryDAO.update(category));
    }

    public void deleteAllCategories() {
        EventCategoryDatabase.databaseWriteExecutor.execute(() -> categoryDAO.deleteAllCategories());
    }

    }



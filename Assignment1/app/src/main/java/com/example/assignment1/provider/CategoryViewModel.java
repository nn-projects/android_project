package com.example.assignment1.provider;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.assignment1.provider.Category;

import java.util.List;


/**
 * ViewModel class is used for pre-processing the data,
 * before passing it to the controllers (Activity or Fragments). ViewModel class should not hold
 * direct reference to database. ViewModel class relies on repository class, hence the database is
 * accessed using the Repository class.
 */
public class CategoryViewModel extends AndroidViewModel {
    // reference to CategoryRepository
    private CategoryRepository categoryRepository;
    // private class variable to temporary hold all the items retrieved and pass outside of this class
    private LiveData<List<Category>> allCategoriesLiveData;

    public CategoryViewModel(@NonNull Application application) {
        super(application);

        // get reference to the repository class
        categoryRepository = new CategoryRepository(application);

        // get all items by calling method defined in repository class
        allCategoriesLiveData = categoryRepository.getAllCategories();
    }

    /**
     * ViewModel method to get all categorys
     * @return LiveData of type List<Category>
     */
    public LiveData<List<Category>> getAllCategories() {
        return allCategoriesLiveData;
    }

    /**
     * ViewModel method to insert one single item,
     * usually calling insert method defined in repository class
     * @param category object containing details of new Category to be inserted
     */
    public void insert(Category category) {
        categoryRepository.insert(category);
    }

    public void update(Category category) {
        categoryRepository.update(category);
    }

    public void updateEventCount(String categoryId) {
        categoryRepository.incrementEventCount(categoryId);
    }

    public void deleteAllCategories() {
       categoryRepository.deleteAllCategories();
    }



}

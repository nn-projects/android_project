package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Switch;

import com.example.assignment1.provider.Category;
import com.example.assignment1.provider.CategoryViewModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {
    EditText etCategoryId, etCategoryName, etCategoryEventCount, etCategoryLocation;
    Switch isActiveCategory;

    ArrayList<Category> categoryList;

    private CategoryViewModel categoryViewModel;


    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        etCategoryId = findViewById(R.id.editTextCategoryId);
        etCategoryName = findViewById(R.id.editTextCategoryName);
        etCategoryEventCount = findViewById(R.id.editTextEventCount);
        isActiveCategory = findViewById(R.id.categorySwitch);
        etCategoryLocation = findViewById(R.id.editTextCategoryLocation);
        categoryViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);

        Toolbar toolbar = findViewById(R.id.toolbarShared);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("All Categories");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void updateFields(String _categoryName, String _eventCount, boolean _isActive, String _categoryLocation) {
        etCategoryName.setText(_categoryName);
        etCategoryEventCount.setText(_eventCount);
        isActiveCategory.setChecked(_isActive);
        etCategoryLocation.setText(_categoryLocation);
    }

    public void onSaveCategoryButton(View view) {
        saveCategory();
    }

    private void saveCategory() {
        String categoryName = etCategoryName.getText().toString();
        String categoryLocation = etCategoryLocation.getText().toString();
        if (RandomGenerator.isNumeric(categoryName) || !RandomGenerator.isAlphaNumeric(categoryName)) {
            Toast.makeText(this, "Invalid category name", Toast.LENGTH_SHORT).show();
            return;
        }

        if (RandomGenerator.isNumeric(categoryLocation)) {
            Toast.makeText(this, "Invalid location", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            Integer.parseInt(etCategoryEventCount.getText().toString());
        } catch (Exception e) {
            Toast.makeText(this, "Event count, valid integer value expected", Toast.LENGTH_SHORT).show();
            return;
        }

        String categoryId = RandomGenerator.generateCategoryId();

        Category newEventC = new Category(
                etCategoryName.getText().toString(),
                Integer.parseInt(etCategoryEventCount.getText().toString()),
                isActiveCategory.isChecked(),
                etCategoryLocation.getText().toString());
        newEventC.setCatId(categoryId);

        categoryViewModel.insert(newEventC);
        etCategoryId.setText(newEventC.getCatId());
        Toast.makeText(this, "Category saved successfully: " + newEventC.getCatId(), Toast.LENGTH_SHORT).show();

        finish();

    }
}





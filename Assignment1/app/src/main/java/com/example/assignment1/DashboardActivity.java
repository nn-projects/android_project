package com.example.assignment1;

import static com.example.assignment1.RandomGenerator.TAG_KEY;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import com.example.assignment1.provider.Category;
import com.example.assignment1.provider.CategoryViewModel;
import com.example.assignment1.provider.Event;
import com.example.assignment1.provider.EventViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;


public class DashboardActivity extends AppCompatActivity {

    //for event form
    EditText etEventId, etEventName, etEventCategoryId, etEventTicketNumber;

    Switch isActiveEvent;


    ArrayList<Event> dataListEvent = new ArrayList<>();
    ArrayList<Category> dataListCategory = new ArrayList<>();

    NavigationView navigationView;
    DrawerLayout drawerLayout;

    private EventViewModel eventViewModel;
    private CategoryViewModel categoryViewModel;
    TextView gestureTV;
    View touchPad;

    private GestureDetector mDetector;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout);

        etEventId = findViewById(R.id.editTextEventId);
        etEventName = findViewById(R.id.editTextEventName);
        etEventCategoryId = findViewById(R.id.editTextEventCategoryId);
        etEventTicketNumber = findViewById(R.id.editTextTicketNumber);
        isActiveEvent = findViewById(R.id.eventSwitch);

        eventViewModel = new ViewModelProvider(this).get(EventViewModel.class);

        categoryViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);

        eventViewModel.getAllEvents().observe(this, newEvent -> {
            dataListEvent = (ArrayList<Event>) newEvent;
        });

        categoryViewModel.getAllCategories().observe(this, newCategory -> {
            dataListCategory = (ArrayList<Category>) newCategory;
        });

        Toolbar myToolBar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer_layout);

        setSupportActionBar(myToolBar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, myToolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new MyNavigationListener());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> {
            saveRecord();
        });

        touchPad = findViewById(R.id.view);
        gestureTV = findViewById(R.id.gestureTV);

        MyGestureListener listener = new MyGestureListener();
        mDetector= new GestureDetector(this, listener);
        touchPad.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mDetector.onTouchEvent(event);
                return true;
            }
        });

        }


    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public void onLongPress(@NonNull MotionEvent e) {
            gestureTV.setText("onLongPress");
            clearFormEvent();
        }

        @Override
        public boolean onDoubleTap(@NonNull MotionEvent e) {
            gestureTV.setText("onDoubleTap");
            saveRecord();
            return true;
        }
    }


    public void saveRecord() {

        String eventName = etEventName.getText().toString();
        String categoryId = etEventCategoryId.getText().toString();
        if (RandomGenerator.isNumeric(eventName) || !RandomGenerator.isAlphaNumeric(eventName)){
            Toast.makeText(this, "Invalid event name", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            Integer.parseInt(etEventTicketNumber.getText().toString());
        } catch (Exception e){
            Toast.makeText(this, "Tickets available, valid integer value expected", Toast.LENGTH_SHORT).show();
            return;
        }

//        eventCount increment
        for (Category e : dataListCategory) {
            if (e.getCatId().equalsIgnoreCase(categoryId)) {
                categoryViewModel.updateEventCount(categoryId);
            }
        }

        // check category Id exists
        Category categoryById = findCategoryById(categoryId);
        if (categoryById == null){
            Toast.makeText(this, "Category does not exist", Toast.LENGTH_SHORT).show();
            return;
        }


        Event newEvent = new Event(
                eventName,
                categoryId,
                Integer.parseInt(etEventTicketNumber.getText().toString()),
                isActiveEvent.isChecked());

        String eventId = RandomGenerator.generateEventId();
        newEvent.setEventId(eventId);

        eventViewModel.insert(newEvent);

        etEventId.setText(eventId);

        Toast.makeText(this, "Event saved: " + eventId + " to "+ categoryId, Toast.LENGTH_SHORT).show();

    }


    private Category findCategoryById(String categoryId){
        Log.d(TAG_KEY,"Searching for: "+ categoryId);
        Log.d(TAG_KEY,"eventCategories size: "+dataListCategory.size());
        for (Category e : dataListCategory) {
            Log.d(TAG_KEY,"CategoryID: "+ e.getCatId());
            if (e.getCatId().equals(categoryId)) {
                return e;
            }
        }
        return null;
    }




    //for options menu
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }
    @Override
    //for functions when options are clicked
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.option_menu_refresh) {

            }

        if (item.getItemId() == R.id.option_clear_event_form) {

            clearFormEvent();

        } else if (item.getItemId() == R.id.option_delete_category) {

            clearFieldsCategory();
        }
        else if (item.getItemId() == R.id.option_delete_event) {

            clearFieldsEvent();
        }
        return true;
    }
    private void clearFormEvent() {
        etEventId.setText("");
        etEventName.setText("");
        etEventCategoryId.setText("");
        etEventTicketNumber.setText("");
        isActiveEvent.setChecked(false);
    }

    private void clearFieldsEvent() {
        eventViewModel.deleteAllEvents();

    }
    private void clearFieldsCategory() {
        categoryViewModel.deleteAllCategories();


    }



    class MyNavigationListener implements NavigationView.OnNavigationItemSelectedListener {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            int itemId = menuItem.getItemId();

            if (itemId == R.id.option_view_event) {
                Intent intent = new Intent(DashboardActivity.this, ListEventActivity.class);
                startActivity(intent);
            }
            else if (itemId == R.id.option_view_all_categories) {
                Intent intent = new Intent(DashboardActivity.this, ListCategoryActivity.class);
                startActivity(intent);
            }
            else if (itemId == R.id.option_add_category) {
                Intent intent = new Intent(DashboardActivity.this, CategoryActivity.class);
                startActivity(intent);
            }

            else if (itemId == R.id.option_log_out) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }

            drawerLayout.closeDrawers();
            return true;
        }
    }
}













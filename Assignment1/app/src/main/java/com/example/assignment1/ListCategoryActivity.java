package com.example.assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class ListCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_category);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, new FragmentListCategory()).commit();

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
}
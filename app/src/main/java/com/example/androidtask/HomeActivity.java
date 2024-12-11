package com.example.androidtask;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    private RecyclerView recyclerView;
    private CoursesAdapter coursesAdapter;
    private List<Course> courseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Set up Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set up DrawerLayout and NavigationView
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Handle Navigation Item Clicks
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_profile:
                        Toast.makeText(HomeActivity.this, "My Profile", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_courses:
                        Toast.makeText(HomeActivity.this, "My Courses", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_about:
                        Toast.makeText(HomeActivity.this, "About Us", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_logout:
                        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                }
                drawerLayout.closeDrawers(); // Close the drawer after item selection
                return true;
            }
        });

        // Set up RecyclerView for displaying courses
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Populate course data
        courseList = new ArrayList<>();
        courseList.add(new Course("Java Programming", "1500rs"));
        courseList.add(new Course("Android Development", "1599rs"));
        courseList.add(new Course("Data Structures", "999rs"));

        // Set up adapter
        coursesAdapter = new CoursesAdapter(courseList);
        recyclerView.setAdapter(coursesAdapter);
    }

    // Inflate the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);  // Menu resource is inflated here
        return true;
    }

    // Handle clicks on the icons in the toolbar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_notifications:
                // Handle Bell Icon Click
                Toast.makeText(this, "Notifications", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_search:
                // Handle Search Icon Click
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

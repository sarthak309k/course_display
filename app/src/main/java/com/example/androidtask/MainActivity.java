package com.example.androidtask;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CoursesAdapter coursesAdapter;
    private List<Course> courseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up RecyclerView
        recyclerView = findViewById(R.id.recyclerViewMain);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Populate course data
        courseList = new ArrayList<>();
        courseList.add(new Course("Java Programming", "$49"));
        courseList.add(new Course("Android Development", "$59"));
        courseList.add(new Course("Data Structures", "$39"));
        courseList.add(new Course("Web Development", "$45"));
        courseList.add(new Course("Machine Learning", "$69"));

        // Set up adapter
        coursesAdapter = new CoursesAdapter(courseList);
        recyclerView.setAdapter(coursesAdapter);
    }
}
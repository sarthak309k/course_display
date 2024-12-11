package com.example.androidtask;

public class Course {
    private String title;
    private String price;

    public Course(String title, String price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }
}

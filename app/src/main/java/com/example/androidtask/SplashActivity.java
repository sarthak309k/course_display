package com.example.androidtask;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Delay for 3 seconds (3000 ms) before navigating to the next screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Navigate to Registration or Login Activity
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish(); // Close the Splash Screen so it's not part of the back stack
            }
        }, 3000); // 3 seconds delay
    }
}
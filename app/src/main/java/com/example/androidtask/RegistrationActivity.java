package com.example.androidtask;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    private EditText fullNameEditText, emailEditText, contactEditText, passwordEditText;
    private RadioGroup genderRadioGroup;
    private Button registerButton, goToLoginButton; // Button for manual redirection to login

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // Initialize UI components
        fullNameEditText = findViewById(R.id.editTextFullName);
        emailEditText = findViewById(R.id.editTextEmail);
        contactEditText = findViewById(R.id.editTextContact);
        passwordEditText = findViewById(R.id.editTextPassword);
        genderRadioGroup = findViewById(R.id.radioGroupGender);
        registerButton = findViewById(R.id.buttonRegister);
        goToLoginButton = findViewById(R.id.buttonGoToLogin); // Button for manual redirection to login

        // Register Button Click Listener
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        // Go to Login Button Click Listener
        goToLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to Login Activity
                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
                finish(); // Finish current activity so user can't go back to registration
            }
        });
    }

    private void registerUser() {
        String fullName = fullNameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String contact = contactEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        int selectedGenderId = genderRadioGroup.getCheckedRadioButtonId();

        // Validate Input
        if (TextUtils.isEmpty(fullName) || TextUtils.isEmpty(email) ||
                TextUtils.isEmpty(contact) || TextUtils.isEmpty(password) || selectedGenderId == -1) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton selectedGender = findViewById(selectedGenderId);
        String gender = selectedGender.getText().toString();

        // Save Data (for simplicity, we'll use SharedPreferences)
        getSharedPreferences("UserPrefs", MODE_PRIVATE)
                .edit()
                .putString("FullName", fullName)
                .putString("Email", email)
                .putString("Contact", contact)
                .putString("Gender", gender)
                .putString("Password", password)
                .apply();

        Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();

        // Navigate to Login Screen after successful registration
        Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}

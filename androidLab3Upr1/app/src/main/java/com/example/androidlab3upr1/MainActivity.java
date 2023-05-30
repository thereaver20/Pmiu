package com.example.androidlab3upr1;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidlab3upr1.R;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText emailEditText;
    private EditText phoneNumberEditText;
    private EditText birthdayEditText;
    private EditText heightEditText;
    private Button validateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.editTextName);
        emailEditText = findViewById(R.id.editTextEmail);
        phoneNumberEditText = findViewById(R.id.editTextPhoneNumber);
        birthdayEditText = findViewById(R.id.editTextBirthday);
        heightEditText = findViewById(R.id.editTextHeight);
        validateButton = findViewById(R.id.validateButton);

        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInputFields();
            }
        });
    }

    private void validateInputFields() {
        boolean isNameValid = validateName();
        boolean isEmailValid = validateEmail();
        boolean isPhoneNumberValid = validatePhoneNumber();
        boolean isBirthdayValid = validateBirthday();
        boolean isHeightValid = validateHeight();

        if (isNameValid && isEmailValid && isPhoneNumberValid && isBirthdayValid && isHeightValid) {
            Toast.makeText(this, "Всички полета са валидни", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validateName() {
        String name = nameEditText.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            nameEditText.setError("Въведете име");
            return false;
        } else if (!name.contains(" ")) {
            nameEditText.setError("Въведете пълно име (две имена)");
            return false;
        } else if (name.length() < 5) {
            nameEditText.setError("Минимална дължина на името: 5 символа");
            return false;
        }
        return true;
    }

    private boolean validateEmail() {
        String email = emailEditText.getText().toString().trim();
        if (TextUtils.isEmpty(email)) {
            emailEditText.setError("Въведете имейл");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.setError("Въведете валиден имейл");
            return false;
        }
        return true;
    }

    private boolean validatePhoneNumber() {
        String phoneNumber = phoneNumberEditText.getText().toString().trim();
        if (TextUtils.isEmpty(phoneNumber)) {
            phoneNumberEditText.setError("Въведете мобилен телефон");
            return false;
        } else if (!phoneNumber.matches("^08\\d{8}$")) {
            phoneNumberEditText.setError("Въведете валиден мобилен телефон (започващ с 08 и с дължина 10 символа)");
            return false;
        }
        return true;
    }

    private boolean validateBirthday() {
        String dob = birthdayEditText.getText().toString().trim();
        if (TextUtils.isEmpty(dob)) {
            birthdayEditText.setError("Въведете дата на раждане");
            return false;
        }

        Calendar currentDate = Calendar.getInstance();
        Calendar lowerBound = Calendar.getInstance();
        lowerBound.add(Calendar.YEAR, -150);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date selectedDate = dateFormat.parse(dob);
            Calendar selectedCalendar = Calendar.getInstance();
            selectedCalendar.setTime(selectedDate);

            if (selectedCalendar.after(currentDate) || selectedCalendar.before(lowerBound)) {
                birthdayEditText.setError("Въведете валидна дата на раждане");
                return false;
            }
        } catch (ParseException e) {
            birthdayEditText.setError("Въведете валиден формат на датата (дд/мм/гггг)");
            return false;
        }

        return true;
    }

    private boolean validateHeight() {
        String heightString = heightEditText.getText().toString().trim();
        if (TextUtils.isEmpty(heightString)) {
            heightEditText.setError("Въведете височина");
            return false;
        } else {
            try {
                double height = Double.parseDouble(heightString);
                if (height <= 0.5 || height >= 3.0) {
                    heightEditText.setError("Въведете валидна височина (по-малко от 3 и по-голямо от 0.5)");
                    return false;
                }
            } catch (NumberFormatException e) {
                heightEditText.setError("Въведете валидно число за височината");
                return false;
            }
        }
        return true;
    }
}

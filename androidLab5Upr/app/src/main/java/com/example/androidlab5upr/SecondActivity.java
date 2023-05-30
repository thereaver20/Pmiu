package com.example.androidlab5upr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends BaseActivity {

    private EditText nameEditText;
    private EditText addressEditText;
    private EditText cityEditText;
    private EditText phoneEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        nameEditText = findViewById(R.id.nameEditText);
        addressEditText = findViewById(R.id.addressEditText);
        cityEditText = findViewById(R.id.cityEditText);
        phoneEditText = findViewById(R.id.phoneEditText);

        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidData()) {
                    Intent intent = createIntent();
                    startActivity(intent);
                }
            }
        });

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    protected Intent createIntent() {
        String name = nameEditText.getText().toString();
        String address = addressEditText.getText().toString();
        String city = cityEditText.getText().toString();
        String phone = phoneEditText.getText().toString();

        People people = new People(name, address, city, phone);

        Intent intent = new Intent(this, ThirdActivity.class);
        intent.putExtra("people", people);
        return intent;
    }

    private boolean isValidData() {
        String name = nameEditText.getText().toString();
        String address = addressEditText.getText().toString();
        String city = cityEditText.getText().toString();
        String phone = phoneEditText.getText().toString();


        if (name.length() < 2 || name.length() > 100) {
            Toast.makeText(this, "Invalid name", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (address.length() < 5 || address.length() > 255) {
            Toast.makeText(this, "Invalid address", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (city.length() < 5 || city.length() > 150) {
            Toast.makeText(this, "Invalid city", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!phone.startsWith("08") || phone.length() != 10) {
            Toast.makeText(this, "Invalid phone number", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}

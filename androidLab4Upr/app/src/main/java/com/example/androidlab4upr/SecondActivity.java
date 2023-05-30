package com.example.androidlab4upr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends BaseActivity {
    private EditText ageEditText;
    private EditText addressEditText;
    private EditText cityEditText;
    private Button backButton;
    private Button nextButton;

    private People people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ageEditText = findViewById(R.id.editTextAge);
        addressEditText = findViewById(R.id.editTextAddress);
        cityEditText = findViewById(R.id.editTextCity);
        backButton = findViewById(R.id.buttonBack);
        nextButton = findViewById(R.id.buttonNext);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int age = Integer.parseInt(ageEditText.getText().toString());
                String address = addressEditText.getText().toString();
                String city = cityEditText.getText().toString();

                people.setAge(age);
                people.setAddress(address);
                people.setCity(city);

                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                intent.putExtra("people", people);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        people = new People(name);
    }
}

package com.example.androidlab4upr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends BaseActivity {
    private TextView nameTextView;
    private TextView ageTextView;
    private TextView addressTextView;
    private TextView cityTextView;
    private Button finishButton;

    private People people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        nameTextView = findViewById(R.id.textViewName);
        ageTextView = findViewById(R.id.textViewAge);
        addressTextView = findViewById(R.id.textViewAddress);
        cityTextView = findViewById(R.id.textViewCity);
        finishButton = findViewById(R.id.buttonFinish);

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAndRemoveTask();
            }
        });

        Intent intent = getIntent();
        people = intent.getParcelableExtra("people");

        if (people != null) {
            nameTextView.setText(people.getName());
            ageTextView.setText(String.valueOf(people.getAge()));
            addressTextView.setText(people.getAddress());
            cityTextView.setText(people.getCity());
        }
    }
}

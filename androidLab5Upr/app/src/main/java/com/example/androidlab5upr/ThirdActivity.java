package com.example.androidlab5upr;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity extends BaseActivity {

    private TextView nameTextView;
    private TextView addressTextView;
    private TextView cityTextView;
    private TextView phoneTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        nameTextView = findViewById(R.id.nameTextView);
        addressTextView = findViewById(R.id.addressTextView);
        cityTextView = findViewById(R.id.cityTextView);
        phoneTextView = findViewById(R.id.phoneTextView);

        Intent intent = getIntent();
        if (intent != null) {
            People people = intent.getParcelableExtra("people");
            if (people != null) {
                nameTextView.setText(people.getName());
                addressTextView.setText(people.getAddress());
                cityTextView.setText(people.getCity());
                phoneTextView.setText(people.getPhone());
            }
        }
    }

    @Override
    protected Intent createIntent() {
        return null;
    }
}

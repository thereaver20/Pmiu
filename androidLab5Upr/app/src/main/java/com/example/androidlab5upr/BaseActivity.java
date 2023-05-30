package com.example.androidlab5upr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    protected Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent = createIntent();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (intent != null) {
            startActivity(intent);
        } else {
            // Логване на грешка, ако intent е null
            // Тук може да използвате Log или друг механизъм за логване
            // Log.e("BaseActivity", "Intent is null");
        }
    }

    protected abstract Intent createIntent();
}

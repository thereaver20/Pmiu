package com.example.androidlab5upr;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {

    private EditText emailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        emailEditText = findViewById(R.id.emailEditText);
    }

    @Override
    protected Intent createIntent() {
        String email = emailEditText.getText().toString();

        if (!isValidEmail(email)) {
            Toast.makeText(this, "Invalid email", Toast.LENGTH_SHORT).show();
            return null;
        }

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("email", email);
        return intent;
    }

    private boolean isValidEmail(String email) {
        if (email.isEmpty()) {
            return false;
        }

        if (!email.contains("@")) {
            return false;
        }

        if (!email.contains(".")) {
            return false;
        }

        String[] parts = email.split("@");
        String domain = parts[1];
        String[] domainParts = domain.split("\\.");
        String domainExtension = domainParts[domainParts.length - 1];
        if (domainExtension.length() < 2 || domainExtension.length() > 4) {
            return false;
        }

        return true;
    }
}

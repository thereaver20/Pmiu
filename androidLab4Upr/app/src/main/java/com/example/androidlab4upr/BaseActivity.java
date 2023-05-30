package com.example.androidlab4upr;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    protected String activityName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityName = getClass().getSimpleName();
        logMessage("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        logMessage("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        logMessage("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        logMessage("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        logMessage("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logMessage("onDestroy");
    }

    protected void logMessage(String message) {
        Toast.makeText(this, activityName + ": " + message, Toast.LENGTH_SHORT).show();
    }
}

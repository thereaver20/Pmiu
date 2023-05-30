package com.example.zadacha1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "19621834";
    private Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View view) {
        Random random = new Random();
        boolean start = random.nextBoolean();

        if (start)
        {
            Toast.makeText(this, R.string.on, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, RaceActivity2.class));
        }
        else
        {
            int millisecund = random.nextInt(5000);
            Log.i(TAG, "Sleep" + millisecund);
            try {
                Thread.sleep(millisecund);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Toast.makeText(this, R.string.error, Toast.LENGTH_SHORT).show();
        }
    }
}
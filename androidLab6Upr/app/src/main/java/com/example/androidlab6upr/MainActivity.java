package com.example.androidlab6upr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.frameLayout);

        findViewById(R.id.btnAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddCardDialog();
            }
        });

        findViewById(R.id.btnRemove).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeLastCard();
            }
        });
    }

    private void showAddCardDialog() {
        AddCardDialogFragment dialog = new AddCardDialogFragment();
        dialog.show(getSupportFragmentManager(), "add_card_dialog");
    }

    private void removeLastCard() {
        int childCount = frameLayout.getChildCount();
        if (childCount > 0) {
            frameLayout.removeViewAt(childCount - 1);
        }
    }

    @Override
    public void onCardAdded(BirthdayCard card) {
        BirthdayCardFragment fragment = BirthdayCardFragment.newInstance(card);
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, fragment).commit();
    }
}
}
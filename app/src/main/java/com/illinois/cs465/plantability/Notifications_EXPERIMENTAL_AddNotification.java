package com.illinois.cs465.plantability;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Notifications_EXPERIMENTAL_AddNotification extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications_experimental_add_notification);

        Button backButton = (Button) findViewById(R.id.backButtonNotification);
        backButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.backButtonNotification) {
            startActivity(new Intent(this, Notifications_Base.class));
            finish();
        }
    }
}

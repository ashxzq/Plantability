package com.illinois.cs465.plantability;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.illinois.cs465.plantability.plantDatabase.Plant;
import com.illinois.cs465.plantability.plantDatabase.PlantDatabase;
import com.illinois.cs465.plantability.plantDatabase.PlantListAdapter;

import java.util.List;

public class Plot_Base extends AppCompatActivity implements View.OnClickListener {
    private PlantListAdapter plantListAdapter;

    private LinearLayout myPlotsClickableLayout;
    private LinearLayout discoverClickableLayout;
    private LinearLayout notificationsClickableLayout;

    private Button addPlantButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plot);

        myPlotsClickableLayout = (LinearLayout) findViewById(R.id.my_plots_button_layout);
        discoverClickableLayout = (LinearLayout) findViewById(R.id.discover_button_layout);
        notificationsClickableLayout = (LinearLayout) findViewById(R.id.notifications_button_layout);

        myPlotsClickableLayout.setOnClickListener(this);
        discoverClickableLayout.setOnClickListener(this);
        notificationsClickableLayout.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.my_plots_button_layout) {
            startActivity(new Intent(this, MyPlots_Base.class));
            finish();

        } else if (v.getId() == R.id.discover_button_layout) {
            startActivity(new Intent(this, Discover_Base.class));
            finish();

        } else if (v.getId() == R.id.notifications_button_layout) {
            startActivity(new Intent(this, Notifications_Base.class));
            finish();
        }
    }
}

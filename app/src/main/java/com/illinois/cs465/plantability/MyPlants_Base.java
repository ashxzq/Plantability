package com.illinois.cs465.plantability;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.illinois.cs465.plantability.plantDatabase.Plant;
import com.illinois.cs465.plantability.plantDatabase.PlantDatabase;
import com.illinois.cs465.plantability.plantDatabase.PlantListAdapter;

import java.util.List;

public class MyPlants_Base extends AppCompatActivity implements View.OnClickListener {
    private PlantListAdapter plantListAdapter;

    private LinearLayout myPlotsClickableLayout;
    private LinearLayout discoverClickableLayout;
    private LinearLayout notificationsClickableLayout;

    private Button addPlantButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_plants_base);

        myPlotsClickableLayout = (LinearLayout) findViewById(R.id.my_plots_button_layout);
        discoverClickableLayout = (LinearLayout) findViewById(R.id.discover_button_layout);
        notificationsClickableLayout = (LinearLayout) findViewById(R.id.notifications_button_layout);

        myPlotsClickableLayout.setOnClickListener(this);
        discoverClickableLayout.setOnClickListener(this);
        notificationsClickableLayout.setOnClickListener(this);

        addPlantButton = (Button) findViewById(R.id.addPlantButton);
        addPlantButton.setOnClickListener(this);

        initRecyclerView();

        loadPlantList();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view_my_plants);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        plantListAdapter = new PlantListAdapter(this);
        recyclerView.setAdapter(plantListAdapter);
    }

    private void loadPlantList() {
        PlantDatabase plantDatabase = PlantDatabase.getPlantDatabaseInstance(this.getApplicationContext());
        List<Plant> plantList = plantDatabase.plantDao().getAllPlants();
        plantListAdapter.setPlantList(plantList);
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

        } else if (v.getId() == R.id.addPlantButton) {
            startActivity(new Intent(this, MyPlants_AddPlant1.class));
            finish();
        }
    }
}

package com.illinois.cs465.plantability;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.illinois.cs465.plantability.discoverDatabase.DiscoverPlantDatabase;
import com.illinois.cs465.plantability.discoverDatabase.DiscoverPlantListAdapter;
import com.illinois.cs465.plantability.discoverDatabase.DiscoverPlant;

import java.util.List;

public class Discover_Base extends AppCompatActivity implements View.OnClickListener {
    private DiscoverPlantListAdapter discoverPlantListAdapter;

    private LinearLayout myPlotsClickableLayout;
    private LinearLayout myPlantsClickableLayout;
    private LinearLayout notificationsClickableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.discover_base);

        DiscoverPlantDatabase discoverPlantDatabase = DiscoverPlantDatabase.getDiscoverDatabaseInstance(this.getApplicationContext());


        discoverPlantDatabase.discoverPlantDao().delete();
        addNewPlant("Corn", "corn","0.5","4","40","3","05/01/2021","70","Full",
                "7","2","1","More water when tassels and kernels develop.");
        
        addNewPlant("Pumpkin", "pumpkin", "2","2","3","4","05/01/2021","8","Partial",
                "9","10","11","I love pumpkins :)");
        addNewPlant("Grape", "grape", "3","2","3","4","05/01/2021","8","Full",
                "9","10","11","I love Grapes :)");
        addNewPlant("Watermelon", "watermelon", "3","2","3","4","05/01/2021","8","Shaded",
                "9","10","11","I love Watermelons :)");
        addNewPlant("Carrot", "carrot", "3","2","3","4","05/01/2021","8","Partial",
                "9","10","11","I love Carrots :)");
        addNewPlant("Potato", "potato", "2","2","3","4","05/01/2021","8","Partial",
                "9","10","11","I love Potatos :)");
        addNewPlant("Broccoli", "broccoli", "3","2","3","4","05/01/2021","8","Full",
                "9","10","11","I love Broccoli :)");
        addNewPlant("Blueberry", "blueberry", "3","2","3","4","05/01/2021","8","Shaded",
                "9","10","11","I love Blueberries :)");
        addNewPlant("Blackberry", "blackberry", "3","2","3","4","05/01/2021","8","Partial",
                "9","10","11","I love Blackberries :)");
        addNewPlant("Raspberry", "raspberry", "2","2","3","4","05/01/2021","8","Partial",
                "9","10","11","I love Raspberries :)");



        myPlotsClickableLayout = (LinearLayout) findViewById(R.id.my_plots_button_layout);
        myPlantsClickableLayout = (LinearLayout) findViewById(R.id.my_plants_button_layout);
        notificationsClickableLayout = (LinearLayout) findViewById(R.id.notifications_button_layout);

        myPlotsClickableLayout.setOnClickListener(this);
        myPlantsClickableLayout.setOnClickListener(this);
        notificationsClickableLayout.setOnClickListener(this);

        initRecyclerView();

        loadPlantList();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view_discover);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        discoverPlantListAdapter = new DiscoverPlantListAdapter(this);
        recyclerView.setAdapter(discoverPlantListAdapter);
    }

    private void loadPlantList() {
        DiscoverPlantDatabase discoverPlantDatabase = DiscoverPlantDatabase.getDiscoverDatabaseInstance(this.getApplicationContext());
        List<DiscoverPlant> plantList = discoverPlantDatabase.discoverPlantDao().getAllPlants();
        discoverPlantListAdapter.setPlantList(plantList);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.my_plots_button_layout) {
            startActivity(new Intent(this, MyPlots_Base.class));
            finish();

        } else if (v.getId() == R.id.my_plants_button_layout) {
            startActivity(new Intent(this, MyPlants_Base.class));
            finish();

        } else if (v.getId() == R.id.notifications_button_layout) {
            startActivity(new Intent(this, Notifications_Base.class));
            finish();

        }
    }

    private void addNewPlant(String plantName, String plantImage, String seedDepth, String seedSpacing, String rowSpacing, String plantsPerSquareFoot,
                             String startDate, String daysToHarvest, String sunLevel, String numWateringTimesPerWeek, String amountWaterPerWeek,
                             String numWeedingTimesPerWeek, String plantNotes) {
        DiscoverPlantDatabase discoverPlantDatabase = DiscoverPlantDatabase.getDiscoverDatabaseInstance(this.getApplicationContext());

        DiscoverPlant plant = new DiscoverPlant();
        if (!plantName.equals("")) {
            plant.plantName = plantName;
        }
        plant.plantImage = plantImage;
        if (!seedDepth.equals("")) {
            plant.seedDepth = seedDepth;
        }
        if (!seedSpacing.equals("")) {
            plant.seedSpacing = seedSpacing;
        }
        if (!rowSpacing.equals("")) {
            plant.rowSpacing = rowSpacing;
        }
        if (!plantsPerSquareFoot.equals("")) {
            plant.plantsPerSquareFoot = plantsPerSquareFoot;
        }
        if (!startDate.equals("")) {
            plant.startDate = startDate;
        }
        if (!daysToHarvest.equals("")) {
            plant.daysToHarvest = daysToHarvest;
        }
        if (sunLevel.equals("Shaded") || sunLevel.equals("Partial") || sunLevel.equals("Full")) {
            plant.sunLevel = sunLevel;
        }
        if (!numWateringTimesPerWeek.equals("")) {
            plant.numWateringTimesPerWeek = numWateringTimesPerWeek;
        }
        if (!amountWaterPerWeek.equals("")) {
            plant.amountWaterPerWeek = amountWaterPerWeek;
        }
        if (!numWeedingTimesPerWeek.equals("")) {
            plant.numWeedingTimesPerWeek = numWeedingTimesPerWeek;
        }
        if (!plantNotes.equals("")) {
            plant.plantNotes = plantNotes;
        }

        discoverPlantDatabase.discoverPlantDao().insertPlant(plant);
    }
}

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
import com.illinois.cs465.plantability.plantDatabase.PlantListAdapterAddPlantMyPlots;
import com.illinois.cs465.plantability.plotDatabase.Plot;
import com.illinois.cs465.plantability.plotDatabase.PlotDatabase;

import java.util.List;

public class MyPlots_SelectPlant extends AppCompatActivity implements View.OnClickListener {
    private PlantListAdapterAddPlantMyPlots plantListAdapterAddPlantMyPlots;

    private LinearLayout myPlotsClickableLayout;
    private LinearLayout myPlantsClickableLayout;
    private LinearLayout discoverClickableLayout;
    private LinearLayout notificationsClickableLayout;

    private Button cancelButton;
    private Intent previousIntent;
    private String plotName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_plots_select_plant);

        previousIntent = getIntent();
        plotName = previousIntent.getStringExtra("plot_name");

        myPlotsClickableLayout = (LinearLayout) findViewById(R.id.my_plots_button_layout);
        myPlantsClickableLayout = (LinearLayout) findViewById(R.id.my_plants_button_layout);
        discoverClickableLayout = (LinearLayout) findViewById(R.id.discover_button_layout);
        notificationsClickableLayout = (LinearLayout) findViewById(R.id.notifications_button_layout);

        myPlotsClickableLayout.setOnClickListener(this);
        myPlantsClickableLayout.setOnClickListener(this);
        discoverClickableLayout.setOnClickListener(this);
        notificationsClickableLayout.setOnClickListener(this);

        cancelButton = (Button) findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(this);

        initRecyclerView();
        loadPlantList();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view_my_plots_add_plant);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        plantListAdapterAddPlantMyPlots = new PlantListAdapterAddPlantMyPlots(this);
        recyclerView.setAdapter(plantListAdapterAddPlantMyPlots);
    }

    private void loadPlantList() {
        PlantDatabase plantDatabase = PlantDatabase.getPlantDatabaseInstance(this.getApplicationContext());
        List<Plant> plantList = plantDatabase.plantDao().getAllPlants();
        plantListAdapterAddPlantMyPlots.setPlantList(plantList);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.my_plots_button_layout) {
            startActivity(new Intent(this, MyPlots_Base.class));
            finish();

        } else if (v.getId() == R.id.my_plants_button_layout) {
            startActivity(new Intent(this, MyPlants_Base.class));
            finish();

        } else if (v.getId() == R.id.discover_button_layout) {
            startActivity(new Intent(this, Discover_Base.class));
            finish();

        } else if (v.getId() == R.id.notifications_button_layout) {
            startActivity(new Intent(this, Notifications_Base.class));
            finish();

        } else if (v.getId() == R.id.cancelButton) {
            Plot curPlot = getPlot(plotName);
            // Determine which plot page to start based on plot dimensions
            if (curPlot.plotHeight == 4 && curPlot.plotWidth == 4) {
                Intent intent = new Intent(this, MyPlots_4x4_AddPlant.class);
                intent.putExtra("plot_name", previousIntent.getStringExtra("plot_name"));
                startActivity(intent);
            }else if (curPlot.plotHeight == 8 && curPlot.plotWidth == 6) {
                Intent intent = new Intent(this, MyPlots_6x8_AddPlant.class);
                intent.putExtra("plot_name", previousIntent.getStringExtra("plot_name"));
                startActivity(intent);
            }

            finish();
        }
    }

    private Plot getPlot(String plotName) {
        Plot plot = null;
        PlotDatabase plotDatabase = PlotDatabase.getPlotDatabaseInstance(getApplicationContext());
        List<Plot> plotList = plotDatabase.plotDao().getAllPlots();
        for (int i = 0; i < plotList.size(); i++) {
            if (plotList.get(i).plotName.equals(plotName)) {
                plot = plotList.get(i);
                break;
            }
        }
        return plot;
    }
}

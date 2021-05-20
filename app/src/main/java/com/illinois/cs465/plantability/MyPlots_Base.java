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

import com.illinois.cs465.plantability.plotDatabase.Plot;
import com.illinois.cs465.plantability.plotDatabase.PlotDatabase;
import com.illinois.cs465.plantability.plotDatabase.PlotListAdapter;

import java.util.List;

public class MyPlots_Base extends AppCompatActivity implements View.OnClickListener {
    private PlotListAdapter plotListAdapter;

    private LinearLayout myPlantsClickableLayout;
    private LinearLayout discoverClickableLayout;
    private LinearLayout notificationsClickableLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_plots_base);

        myPlantsClickableLayout = (LinearLayout) findViewById(R.id.my_plants_button_layout);
        discoverClickableLayout = (LinearLayout) findViewById(R.id.discover_button_layout);
        notificationsClickableLayout = (LinearLayout) findViewById(R.id.notifications_button_layout);
        Button addPlotButton = (Button) findViewById(R.id.addPlotButton);

        myPlantsClickableLayout.setOnClickListener(this);
        discoverClickableLayout.setOnClickListener(this);
        notificationsClickableLayout.setOnClickListener(this);
        addPlotButton.setOnClickListener(this);

        initRecyclerView();

        loadPlotList();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view_my_plots);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        plotListAdapter = new PlotListAdapter(this);
        recyclerView.setAdapter(plotListAdapter);
    }

    private void loadPlotList() {
        PlotDatabase plotDatabase = PlotDatabase.getPlotDatabaseInstance(this.getApplicationContext());
        List<Plot> plotList = plotDatabase.plotDao().getAllPlots();
        plotListAdapter.setPlotList(plotList);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.my_plants_button_layout) {
            startActivity(new Intent(this, MyPlants_Base.class));
            finish();

        } else if (v.getId() == R.id.discover_button_layout) {
            startActivity(new Intent(this, Discover_Base.class));
            finish();

        } else if (v.getId() == R.id.notifications_button_layout) {
            startActivity(new Intent(this, Notifications_Base.class));
            finish();

        } else if (v.getId() == R.id.addPlotButton) {
            startActivity(new Intent(this, MyPlots_AddPlot.class));
            finish();

        }
    }
}
package com.illinois.cs465.plantability;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.illinois.cs465.plantability.plantDatabase.Plant;
import com.illinois.cs465.plantability.plantDatabase.PlantDatabase;
import com.illinois.cs465.plantability.plotDatabase.Plot;
import com.illinois.cs465.plantability.plotDatabase.PlotDatabase;

import java.util.List;

public class MyPlots_6x8_EditLighting extends AppCompatActivity implements View.OnClickListener {

    String[] tileIds = {"tile_1_1_border","tile_1_2_border","tile_1_3_border","tile_1_4_border","tile_1_5_border","tile_1_6_border","tile_2_1_border","tile_2_2_border","tile_2_3_border","tile_2_4_border",
            "tile_2_5_border","tile_2_6_border","tile_3_1_border","tile_3_2_border","tile_3_3_border","tile_3_4_border","tile_3_5_border","tile_3_6_border","tile_4_1_border","tile_4_2_border","tile_4_3_border","tile_4_4_border",
            "tile_4_5_border","tile_4_6_border","tile_5_1_border","tile_5_2_border","tile_5_3_border","tile_5_4_border","tile_5_5_border","tile_5_6_border","tile_6_1_border","tile_6_2_border","tile_6_3_border","tile_6_4_border",
            "tile_6_5_border","tile_6_6_border","tile_7_1_border","tile_7_2_border","tile_7_3_border","tile_7_4_border","tile_7_5_border","tile_7_6_border","tile_8_1_border","tile_8_2_border","tile_8_3_border","tile_8_4_border",
            "tile_8_5_border","tile_8_6_border",};

    private TextView pageTitle;
    // Top Control Bar
    private LinearLayout viewClickableLayout;
    private LinearLayout addPlantClickableLayout;
    private LinearLayout removePlantClickableLayout;
    private LinearLayout sharePlotClickableLayout;
    // Sun Icon Bar
    private LinearLayout shadeSunBorder;
    private LinearLayout partialSunBorder;
    private LinearLayout fullSunBorder;
    // Bottom Nav Bar
    private LinearLayout myPlotsClickableLayout;
    private LinearLayout myPlantsClickableLayout;
    private LinearLayout discoverClickableLayout;
    private LinearLayout notificationsClickableLayout;

    private Plot plot;
    private Intent previousIntent;
    private String plotName;
    private String selectedSunLevel = "shade"; // Start with shade selected

    private PlotDatabase plotDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_plots_6x8_edit_lighting);

        plotDatabase = PlotDatabase.getPlotDatabaseInstance(getApplicationContext());
        previousIntent = getIntent();
        plotName = previousIntent.getStringExtra("plot_name");

        // Get the current plot
        plot = getPlot(plotName);
        if (plot == null) {
            // This should never happen but it is here for good practice and just in case
            finish();
            return;
        }

        setPlotValues();

        pageTitle = (TextView) findViewById(R.id.opening_message);
        pageTitle.setText(plotName);
        // Top Control Bar
        viewClickableLayout = (LinearLayout) findViewById(R.id.view_button_layout);
        addPlantClickableLayout = (LinearLayout) findViewById(R.id.add_plant_button_layout);
        removePlantClickableLayout = (LinearLayout) findViewById(R.id.remove_plant_button_layout);
        sharePlotClickableLayout = (LinearLayout) findViewById(R.id.share_plot_button_layout);

        viewClickableLayout.setOnClickListener(this);
        addPlantClickableLayout.setOnClickListener(this);
        removePlantClickableLayout.setOnClickListener(this);
        sharePlotClickableLayout.setOnClickListener(this);

        // Sun Icon Bar
        shadeSunBorder = (LinearLayout) findViewById(R.id.shadeSunBorder);
        shadeSunBorder.setBackgroundColor(Color.BLACK); // Start with shade selected
        partialSunBorder = (LinearLayout) findViewById(R.id.partialSunBorder);
        fullSunBorder = (LinearLayout) findViewById(R.id.fullSunBorder);

        shadeSunBorder.setOnClickListener(this);
        partialSunBorder.setOnClickListener(this);
        fullSunBorder.setOnClickListener(this);

        // Bottom Nav Bar
        myPlotsClickableLayout = (LinearLayout) findViewById(R.id.my_plots_button_layout);
        myPlantsClickableLayout = (LinearLayout) findViewById(R.id.my_plants_button_layout);
        discoverClickableLayout = (LinearLayout) findViewById(R.id.discover_button_layout);
        notificationsClickableLayout = (LinearLayout) findViewById(R.id.notifications_button_layout);

        myPlotsClickableLayout.setOnClickListener(this);
        myPlantsClickableLayout.setOnClickListener(this);
        discoverClickableLayout.setOnClickListener(this);
        notificationsClickableLayout.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        // Top Control Bar
        if (v.getId() == R.id.view_button_layout) {
            Intent intent = new Intent(this, MyPlots_6x8_Base.class);
            intent.putExtra("plot_name", plotName);
            startActivity(intent);
            finish();

        } else if (v.getId() == R.id.add_plant_button_layout) {
            Intent intent = new Intent(this, MyPlots_6x8_AddPlant.class);
            intent.putExtra("plot_name", plotName);
            startActivity(intent);
            finish();

        } else if (v.getId() == R.id.remove_plant_button_layout) {
            Intent intent = new Intent(this, MyPlots_6x8_RemovePlant.class);
            intent.putExtra("plot_name", plotName);
            startActivity(intent);
            finish();
        } else if (v.getId() == R.id.share_plot_button_layout) {
            Intent intent = new Intent(this, MyPlots_6x8_SharePlot.class);
            intent.putExtra("plot_name", plotName);
            startActivity(intent);
            finish();


            // Sun Icon Bar
        } else if (v.getId() == R.id.shadeSunBorder) {
            shadeSunBorder.setBackgroundColor(Color.BLACK);
            partialSunBorder.setBackgroundColor(Color.WHITE);
            fullSunBorder.setBackgroundColor(Color.WHITE);
            selectedSunLevel = "shade";

        } else if (v.getId() == R.id.partialSunBorder) {
            shadeSunBorder.setBackgroundColor(Color.WHITE);
            partialSunBorder.setBackgroundColor(Color.BLACK);
            fullSunBorder.setBackgroundColor(Color.WHITE);
            selectedSunLevel = "partial";

        } else if (v.getId() == R.id.fullSunBorder) {
            shadeSunBorder.setBackgroundColor(Color.WHITE);
            partialSunBorder.setBackgroundColor(Color.WHITE);
            fullSunBorder.setBackgroundColor(Color.BLACK);
            selectedSunLevel = "full";


            // Bottom Nav Bar
        } else if (v.getId() == R.id.my_plots_button_layout) {
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

            // Tiles
        } else {
            // A tile was clicked! Determine which tile, then handle it
            for (int i = 0; i < tileIds.length; i++) {
                int tileId = getResources().getIdentifier(tileIds[i], "id", getPackageName());

                if (v.getId() == tileId) {
                    Plot curPlot = getPlot(plotName);
                    String[] curTileData = curPlot.getTileData(tileIds[i]);
                    String tilePlantName = curTileData[0];

                    plotDatabase.plotDao().deletePlot(plot); // Remove the soon to be outdated plot from DB
                    plot.putTileData(tileIds[i], tilePlantName, selectedSunLevel); // Set this tile's border to the cur selected sun level in the plot
                    plotDatabase.plotDao().insertPlot(plot); // Insert updated plot to DB
                    setPlotValues(); // Reset the plot values so this change is displayed
                    break;
                }
            }
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

    private Plant getPlant(String plantName) {
        Plant plant = null;
        PlantDatabase plantDatabase = PlantDatabase.getPlantDatabaseInstance(getApplicationContext());
        List<Plant> plantList = plantDatabase.plantDao().getAllPlants();
        for (int i = 0; i < plantList.size(); i++) {
            if (plantList.get(i).plantName.equals(plantName)) {
                plant = plantList.get(i);
                break;
            }
        }
        return plant;
    }

    private void setPlotValues() {
        for (int i = 1; i <= plot.plotHeight; i++) {
            for (int j = 1; j <= plot.plotWidth; j++) {
                String curTileId = "tile_"+i+"_"+j;
                String curTileBorderId = curTileId + "_border";

                int resIdTile = getResources().getIdentifier(curTileId, "id", getPackageName());
                ImageView curTile = (ImageView) findViewById(resIdTile);

                int resIdTileBorder = getResources().getIdentifier(curTileBorderId, "id", getPackageName());
                LinearLayout curTileBorder = (LinearLayout) findViewById(resIdTileBorder);

                // Get data of current tile
                String[] curTileData = plot.getTileData(curTileId);
                String curTilePlantName = curTileData[0];
                String curTileBorderSunString = curTileData[1];
                // Get plant associated with this tile (if any)
                Plant curTilePlant = getPlant(curTilePlantName);
                if (curTilePlant == null) {
                    curTile.setImageResource(getResources().getIdentifier("white_image", "drawable", getPackageName()));
                } else {
                    curTile.setImageResource(getResources().getIdentifier(curTilePlant.plantImage, "drawable", getPackageName()));
                }
                // Set the tile border color based on the sun level stored
                if (curTileBorderSunString.toLowerCase().equals("partial")) {
                    curTileBorder.setBackgroundColor(getResources().getColor(R.color.partialSun));

                } else if (curTileBorderSunString.toLowerCase().equals("full")) {
                    curTileBorder.setBackgroundColor(getResources().getColor(R.color.fullSun));

                } else {
                    curTileBorder.setBackgroundColor(getResources().getColor(R.color.shadedSun));
                }
                curTileBorder.setOnClickListener(this);
            }
        }
    }
}

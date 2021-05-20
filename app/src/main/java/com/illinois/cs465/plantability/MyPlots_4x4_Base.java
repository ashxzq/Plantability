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
import android.widget.Toast;

import com.illinois.cs465.plantability.plantDatabase.Plant;
import com.illinois.cs465.plantability.plantDatabase.PlantDatabase;
import com.illinois.cs465.plantability.plotDatabase.Plot;
import com.illinois.cs465.plantability.plotDatabase.PlotDatabase;

import org.w3c.dom.Text;

import java.util.List;

public class MyPlots_4x4_Base extends AppCompatActivity implements View.OnClickListener {

    String[] tileIds = {"tile_1_1_border","tile_1_2_border","tile_1_3_border","tile_1_4_border","tile_2_1_border","tile_2_2_border","tile_2_3_border","tile_2_4_border",
            "tile_3_1_border","tile_3_2_border","tile_3_3_border","tile_3_4_border","tile_4_1_border","tile_4_2_border","tile_4_3_border","tile_4_4_border",};

    private TextView pageTitle;
    // Top Control Bar
    private LinearLayout lightingClickableLayout;
    private LinearLayout addPlantClickableLayout;
    private LinearLayout removePlantClickableLayout;
    private LinearLayout sharePlotClickableLayout;
    // Bottom Nav Bar
    private LinearLayout myPlotsClickableLayout;
    private LinearLayout myPlantsClickableLayout;
    private LinearLayout discoverClickableLayout;
    private LinearLayout notificationsClickableLayout;

    private Intent previousIntent;
    private String plotName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_plots_4x4_base);

        previousIntent = getIntent();
        plotName = previousIntent.getStringExtra("plot_name");

        // Get the current plot
        Plot plot = getPlot(plotName);
        if (plot == null) {
            // This should never happen but it is here for good practice and just in case
            finish();
            return;
        }

        for (int i = 1; i <= plot.plotHeight; i++) {
            for (int j = 1; j <= plot.plotWidth; j++) {
                String curTileId = "tile_"+i+"_"+j;
                String curTileBorderId = curTileId + "_border";
                String curTileNotification1Id = curTileId + "_notification_1";
                String curTileNotification2Id = curTileId + "_notification_2";

                int resIdTile = getResources().getIdentifier(curTileId, "id", getPackageName());
                ImageView curTile = (ImageView) findViewById(resIdTile);

                int resIdTileBorder = getResources().getIdentifier(curTileBorderId, "id", getPackageName());
                LinearLayout curTileBorder = (LinearLayout) findViewById(resIdTileBorder);

                int resIdTileNotification1 = getResources().getIdentifier(curTileNotification1Id, "id", getPackageName());
                ImageView curTileNotification1 = (ImageView) findViewById(resIdTileNotification1);

                int resIdTileNotification2 = getResources().getIdentifier(curTileNotification2Id, "id", getPackageName());
                ImageView curTileNotification2 = (ImageView) findViewById(resIdTileNotification2);

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
                // Set the demo notification icons if the plant name contains the demo keywords
                if (curTilePlantName.contains("Water and Trim Today Demo")) {
                    Log.e("Setting water and trim", "");
                    curTileNotification1.setImageResource(getResources().getIdentifier("water_drop", "drawable", getPackageName()));
                    curTileNotification2.setImageResource(getResources().getIdentifier("scissor", "drawable", getPackageName()));

                } else if (curTilePlantName.contains("Water Today Demo")) {
                    curTileNotification1.setImageResource(getResources().getIdentifier("water_drop", "drawable", getPackageName()));
                    curTileNotification2.setImageResource(getResources().getIdentifier("white_image", "drawable", getPackageName()));

                } else if (curTilePlantName.contains("Trim Today Demo")) {
                    curTileNotification1.setImageResource(getResources().getIdentifier("scissor", "drawable", getPackageName()));
                    curTileNotification2.setImageResource(getResources().getIdentifier("white_image", "drawable", getPackageName()));

                } else if (curTilePlantName.contains("Plant Today Demo")) {
                    curTileNotification1.setImageResource(getResources().getIdentifier("planting_seeds", "drawable", getPackageName()));
                    curTileNotification2.setImageResource(getResources().getIdentifier("white_image", "drawable", getPackageName()));

                } else if (curTilePlantName.contains("Harvest Today Demo")) {
                    curTileNotification1.setImageResource(getResources().getIdentifier("harvest_icon", "drawable", getPackageName()));
                    curTileNotification2.setImageResource(getResources().getIdentifier("white_image", "drawable", getPackageName()));

                } else {
                    curTileNotification1.setImageResource(getResources().getIdentifier("white_image", "drawable", getPackageName()));
                    curTileNotification2.setImageResource(getResources().getIdentifier("white_image", "drawable", getPackageName()));
                }
                curTileBorder.setOnClickListener(this);
            }
        }

        pageTitle = (TextView) findViewById(R.id.opening_message);
        pageTitle.setText(plotName);
        // Top Control Bar
        lightingClickableLayout = (LinearLayout) findViewById(R.id.lighting_button_layout);
        addPlantClickableLayout = (LinearLayout) findViewById(R.id.add_plant_button_layout);
        removePlantClickableLayout = (LinearLayout) findViewById(R.id.remove_plant_button_layout);
        sharePlotClickableLayout = (LinearLayout) findViewById(R.id.share_plot_button_layout);

        lightingClickableLayout.setOnClickListener(this);
        addPlantClickableLayout.setOnClickListener(this);
        removePlantClickableLayout.setOnClickListener(this);
        sharePlotClickableLayout.setOnClickListener(this);

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
        if (v.getId() == R.id.lighting_button_layout) {
            Intent intent = new Intent(this, MyPlots_4x4_EditLighting.class);
            intent.putExtra("plot_name", plotName);
            startActivity(intent);
            finish();

        } else if (v.getId() == R.id.add_plant_button_layout) {
            Intent intent = new Intent(this, MyPlots_4x4_AddPlant.class);
            intent.putExtra("plot_name", plotName);
            startActivity(intent);
            finish();

        } else if (v.getId() == R.id.remove_plant_button_layout) {
            Intent intent = new Intent(this, MyPlots_4x4_RemovePlant.class);
            intent.putExtra("plot_name", plotName);
            startActivity(intent);
            finish();
        } else if (v.getId() == R.id.share_plot_button_layout) {
            Intent intent = new Intent(this, MyPlots_4x4_SharePlot.class);
            intent.putExtra("plot_name", plotName);
            startActivity(intent);
            finish();


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
            boolean contains_plant = false;
            for (int i = 0; i < tileIds.length; i++) {
                int tileId = getResources().getIdentifier(tileIds[i], "id", getPackageName());

                if (v.getId() == tileId) {
                    Plot curPlot = getPlot(plotName);
                    String[] curTileData = curPlot.getTileData(tileIds[i]);

                    String tilePlantName = curTileData[0];

                    if (!tilePlantName.equals("")) {
                        contains_plant = true;
                        Log.e("Tile plant name", tilePlantName);
                        Intent intent = new Intent(getApplicationContext(), MyPlots_PlantDetails.class);
                        intent.putExtra("plant_name", tilePlantName);
                        startActivity(intent);
                        break;
                    }
                    Log.e("Tile plant name was", "empty");
                    break;
                }
            }
            if (!contains_plant) {
                Toast.makeText(MyPlots_4x4_Base.this, "Currently in viewing plot mode.", Toast.LENGTH_SHORT).show();
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
}

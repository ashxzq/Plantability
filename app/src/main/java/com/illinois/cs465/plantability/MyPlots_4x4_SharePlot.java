package com.illinois.cs465.plantability;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.ClipboardManager;
import android.widget.Toast;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.illinois.cs465.plantability.plantDatabase.Plant;
import com.illinois.cs465.plantability.plantDatabase.PlantDatabase;
import com.illinois.cs465.plantability.plotDatabase.Plot;
import com.illinois.cs465.plantability.plotDatabase.PlotDatabase;

import java.util.List;

public class MyPlots_4x4_SharePlot extends AppCompatActivity implements View.OnClickListener {
    private TextView pageTitle;
    // Top Control Bar
    private LinearLayout viewClickableLayout;
    private LinearLayout lightingClickableLayout;
    private LinearLayout addPlantClickableLayout;
    private LinearLayout removePlantClickableLayout;
    // Bottom Nav Bar
    private LinearLayout myPlotsClickableLayout;
    private LinearLayout myPlantsClickableLayout;
    private LinearLayout discoverClickableLayout;
    private LinearLayout notificationsClickableLayout;
    //plot share textbox and copy button
    TextView text;
    Button copy;

    private Intent previousIntent;
    private String plotName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_plots_4x4_share_plot);

        previousIntent = getIntent();
        plotName = previousIntent.getStringExtra("plot_name");
        //assign vars the share plot elems
//        text = findViewById(R.id.plot_text);
//        copy = findViewById(R.id.copy_button);

        // Get the current plot
        Plot plot = getPlot(plotName);
        if (plot == null) {
            // This should never happen but it is here for good practice and just in case
            finish();
            return;
        }

        final TextView textViewToChange = (TextView) findViewById(R.id.plot_text);                      //set textview to plot info
        Map<String, Integer> plantDict = new HashMap<String, Integer>();
        for (int i=1; i<=plot.plotHeight; i++){                                                          //get num of plants for each plantname
            for (int j=1; j<=plot.plotWidth; j++){
                String plot_tile = "tile_" + i + "_" + j + "_border";
                String plot_data = plot.getTileData(plot_tile)[0];
                if (!plot_data.equals("")){
                    if (plantDict.containsKey(plot_data)){                      //increment or define key,val pairs
                        plantDict.put(plot_data, plantDict.get(plot_data)+1);
                    }else{
                        plantDict.put(plot_data, 1);
                    }
                }
            }
        }
        Iterator it = plantDict.entrySet().iterator();
        String plant_info = "\n";
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            plant_info = plant_info + pair.getKey() + " : " + pair.getValue() + "\n";
            it.remove(); // avoids a ConcurrentModificationException
        }
        String plot_text_to_set = plot.plotName + "\n\n Plot Dimensions: " + plot.plotWidth + " x " + plot.plotHeight + plant_info;
        textViewToChange.setText(plot_text_to_set);

        pageTitle = (TextView) findViewById(R.id.opening_message);
        pageTitle.setText(plotName);
        // Top Control Bar
        viewClickableLayout = (LinearLayout) findViewById(R.id.view_button_layout);
        lightingClickableLayout = (LinearLayout) findViewById(R.id.lighting_button_layout);
        addPlantClickableLayout = (LinearLayout) findViewById(R.id.add_plant_button_layout);
        removePlantClickableLayout = (LinearLayout) findViewById(R.id.remove_plant_button_layout);

        viewClickableLayout.setOnClickListener(this);
        lightingClickableLayout.setOnClickListener(this);
        addPlantClickableLayout.setOnClickListener(this);
        removePlantClickableLayout.setOnClickListener(this);

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
            Intent intent = new Intent(this, MyPlots_4x4_Base.class);
            intent.putExtra("plot_name", plotName);
            startActivity(intent);
            finish();

        } else if (v.getId() == R.id.lighting_button_layout) {
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

            // copy button
        } else if(v.getId() == R.id.copy_button){
            TextView plotText = (TextView) findViewById(R.id.plot_text);
            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);    //make clipboard
            ClipData clip = ClipData.newPlainText("plotText", plotText.getText().toString());             //get data stored in plot_text
            clipboard.setPrimaryClip(clip);                                                                 //put data stored clipboard

            Toast.makeText(getApplicationContext(), "Copied!", Toast.LENGTH_SHORT).show();   //pop up message to alert that message was copied
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

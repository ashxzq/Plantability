package com.illinois.cs465.plantability;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.illinois.cs465.plantability.plantDatabase.Plant;
import com.illinois.cs465.plantability.plantDatabase.PlantDatabase;

import java.util.List;

public class MyPlots_PlantDetails extends AppCompatActivity implements View.OnClickListener {
    Intent previousIntent;
    String plantName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_plots_plant_details);

        previousIntent = getIntent();
        plantName = previousIntent.getStringExtra("plant_name");
        Plant curPlant = getPlant(plantName); // Will never return null because this is checked before starting activity

        TextView plantName = (TextView) findViewById(R.id.plantName);
        String plantNameString = curPlant.plantName;
        plantName.setText(plantNameString);

        TextView seedDepth = (TextView) findViewById(R.id.seedDepth);
        String seedDepthString = curPlant.seedDepth + "(in) down.";
        seedDepth.setText(seedDepthString);

        TextView seedSpacing = (TextView) findViewById(R.id.seedSpacing);
        String seedSpacingString = curPlant.seedSpacing + "(in) apart.";
        seedSpacing.setText(seedSpacingString);

        TextView rowSpacing = (TextView) findViewById(R.id.rowSpacing);
        String rowSpacingString = curPlant.rowSpacing + "(in) apart.";
        rowSpacing.setText(rowSpacingString);

        TextView plantsPerSquareFoot = (TextView) findViewById(R.id.plantsPerSquareFoot);
        String plantsPerSquareFootString = curPlant.plantsPerSquareFoot + " per square foot.";
        plantsPerSquareFoot.setText(plantsPerSquareFootString);

        TextView startDate = (TextView) findViewById(R.id.startDate);
        String startDateString =  curPlant.startDate;
        startDate.setText(startDateString);

        TextView daysToHarvest = (TextView) findViewById(R.id.daysToHarvest);
        String daysToHarvestString = curPlant.daysToHarvest + " days.";
        daysToHarvest.setText(daysToHarvestString);

        TextView sunLevel = (TextView) findViewById(R.id.sunLevelTextView);
        String sunLevelIntent = curPlant.sunLevel;
        String sunLevelString = "Sun Level: " + sunLevelIntent;
        sunLevel.setText(sunLevelString);

        ImageView sunIcon = (ImageView) findViewById(R.id.sunIconDetails);
        if (sunLevelIntent.toLowerCase().equals("full")) {
            sunIcon.setImageResource(R.drawable.full_sun);
        } else if (sunLevelIntent.toLowerCase().equals("partial")) {
            sunIcon.setImageResource(R.drawable.partial_sun);
        } else {
            sunIcon.setImageResource(R.drawable.shady_sun);
        }

        TextView numWateringsPerWeek = (TextView) findViewById(R.id.numWateringsPerWeek);
        String numWateringsPerWeekString = curPlant.numWateringTimesPerWeek + " times a week.";

        numWateringsPerWeek.setText(numWateringsPerWeekString);

        TextView amountWaterPerWeek = (TextView) findViewById(R.id.amountWaterPerWeek);
        String amountWaterPerWeekString = curPlant.amountWaterPerWeek + " gallons per week.";
        amountWaterPerWeek.setText(amountWaterPerWeekString);

        TextView numWeedingsPerWeek = (TextView) findViewById(R.id.numWeedingsPerWeek);
        String numWeedingsPerWeekString = curPlant.numWeedingTimesPerWeek + " times per week.";
        numWeedingsPerWeek.setText(numWeedingsPerWeekString);

        TextView plantNotes = (TextView) findViewById(R.id.plantNotes);
        String plantNotesString = curPlant.plantNotes;
        plantNotes.setText(plantNotesString);


        ImageView plantImageView = (ImageView) findViewById(R.id.plantImageView);
        String plantImageIntent = curPlant.plantImage;

        // Sets image
        int imgId = getResources().getIdentifier(plantImageIntent, "drawable", getPackageName());
        plantImageView.setImageResource(imgId);


        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.backButton) {
            finish(); // A plot in the "view" state does not call finish() when tiles are clicked
            // so it is waiting for us to finish() here to be redisplayed.
        }
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

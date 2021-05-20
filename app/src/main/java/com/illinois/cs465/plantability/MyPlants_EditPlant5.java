package com.illinois.cs465.plantability;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.illinois.cs465.plantability.plantDatabase.Plant;
import com.illinois.cs465.plantability.plantDatabase.PlantDatabase;

import java.util.List;

public class MyPlants_EditPlant5 extends AppCompatActivity implements View.OnClickListener {
    private EditText numWeedingTimesPerWeekInput;
    private EditText plantNotesInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_plants_edit_plant_5);

        Intent intent = getIntent();
        final Bundle previousExtras = intent.getExtras();

        numWeedingTimesPerWeekInput = (EditText) findViewById(R.id.numWeedingTimesPerWeekInput);
        numWeedingTimesPerWeekInput.setText(intent.getStringExtra("num_weedings_per_week"));

        plantNotesInput = (EditText) findViewById(R.id.plantNotesInput);
        plantNotesInput.setText(intent.getStringExtra("plant_notes"));


        final String plantName = intent.getStringExtra("plant_name");
        final String plantImage = intent.getStringExtra("plant_image");
        final String seedDepth = intent.getStringExtra("seed_depth");
        final String seedSpacing = intent.getStringExtra("seed_spacing");
        final String rowSpacing = intent.getStringExtra("row_spacing");
        final String plantsPerSquareFoot = intent.getStringExtra("plants_per_square_foot");
        final String startDate = intent.getStringExtra("start_date");
        final String daysToHarvest = intent.getStringExtra("days_to_harvest");
        final String sunLevel = intent.getStringExtra("sun_level");
        final String numWateringTimesPerWeek = intent.getStringExtra("num_watering_times_per_week");
        final String amountWaterPerWeek = intent.getStringExtra("amount_water_per_week");


        Button doneButton = (Button) findViewById(R.id.doneButtonAP5);
        Button backButton = (Button) findViewById(R.id.backButtonAP5);
        Button cancelButton = (Button) findViewById(R.id.cancelButtonAP5);


        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String numWeedingTimesPerWeek = numWeedingTimesPerWeekInput.getText().toString().replaceAll("[^0-9.-]", "");
                final String plantNotes = plantNotesInput.getText().toString();

                PlantDatabase plantDatabase = PlantDatabase.getPlantDatabaseInstance(getApplicationContext());
                List<Plant> plants = plantDatabase.plantDao().getAllPlants();
                for (int i = 0; i < plants.size(); i++) {
                    if (plants.get(i).plantName != null && plants.get(i).plantName.equals(plantName)) {
                        plantDatabase.plantDao().deletePlant(plants.get(i));
                        addNewPlant(plantName, plantImage, seedDepth, seedSpacing, rowSpacing, plantsPerSquareFoot, startDate, daysToHarvest,
                                sunLevel, numWateringTimesPerWeek, amountWaterPerWeek, numWeedingTimesPerWeek, plantNotes);

                        startActivity(new Intent(getApplicationContext(), MyPlants_Base.class));
                        finish();
                        return;
                    }
                }

            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyPlants_EditPlant4.class);
                if (previousExtras != null) {
                    intent.putExtras(previousExtras);
                }
                startActivity(intent);
                finish();
            }
        });
        cancelButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.cancelButtonAP5) {
            Intent intent = new Intent(getApplicationContext(), MyPlants_Base.class);
            startActivity(intent);
            finish();
        }
    }

    private void addNewPlant(String plantName, String plantImage, String seedDepth, String seedSpacing, String rowSpacing, String plantsPerSquareFoot,
                             String startDate, String daysToHarvest, String sunLevel, String numWateringTimesPerWeek, String amountWaterPerWeek,
                             String numWeedingTimesPerWeek, String plantNotes) {
        PlantDatabase plantDatabase = PlantDatabase.getPlantDatabaseInstance(this.getApplicationContext());

        Plant plant = new Plant();
        if (plantName != null && !plantName.equals("")) {
            plant.plantName = plantName;
        }
        plant.plantImage = plantImage;
        if (seedDepth != null && !seedDepth.equals("")) {
            plant.seedDepth = seedDepth;
        }
        if (seedSpacing != null && !seedSpacing.equals("")) {
            plant.seedSpacing = seedSpacing;
        }
        if (rowSpacing != null && !rowSpacing.equals("")) {
            plant.rowSpacing = rowSpacing;
        }
        if (plantsPerSquareFoot != null && !plantsPerSquareFoot.equals("")) {
            plant.plantsPerSquareFoot = plantsPerSquareFoot;
        }
        if (startDate != null && !startDate.equals("")) {
            plant.startDate = startDate;
        }
        if (daysToHarvest != null && !daysToHarvest.equals("")) {
            plant.daysToHarvest = daysToHarvest;
        }
        if (sunLevel != null && (sunLevel.equals("shade") || sunLevel.equals("partial") || sunLevel.equals("full"))) {
            plant.sunLevel = sunLevel;
        }
        if (numWateringTimesPerWeek != null && !numWateringTimesPerWeek.equals("")) {
            plant.numWateringTimesPerWeek = numWateringTimesPerWeek;
        }
        if (amountWaterPerWeek != null && !amountWaterPerWeek.equals("")) {
            plant.amountWaterPerWeek = amountWaterPerWeek;
        }
        if (numWeedingTimesPerWeek != null && !numWeedingTimesPerWeek.equals("")) {
            plant.numWeedingTimesPerWeek = numWeedingTimesPerWeek;
        }
        if (plantNotes != null && !plantNotes.equals("")) {
            plant.plantNotes = plantNotes;
        }

        plantDatabase.plantDao().insertPlant(plant);
    }
}

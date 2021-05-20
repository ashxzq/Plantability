package com.illinois.cs465.plantability;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.illinois.cs465.plantability.notificationDatabase.Notification;
import com.illinois.cs465.plantability.notificationDatabase.NotificationDatabase;
import com.illinois.cs465.plantability.plantDatabase.Plant;
import com.illinois.cs465.plantability.plantDatabase.PlantDatabase;

import java.util.List;

public class MyPlants_PlantDetails extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_plants_plant_details);

        final Intent intent = getIntent();

        int id = intent.getIntExtra("id", 0);

        ImageView sunIcon = (ImageView) findViewById(R.id.sunIconDetails);

        TextView tempId = (TextView) findViewById(R.id.tempId);
        String idString = "Id: " + String.valueOf(id);
        tempId.setText(idString);

        TextView plantName = (TextView) findViewById(R.id.plantName);
        String plantNameString = intent.getStringExtra("plant_name");
        plantName.setText(plantNameString);

        TextView seedDepth = (TextView) findViewById(R.id.seedDepth);
        String seedDepthString = intent.getStringExtra("seed_depth") + "(in) down.";
        seedDepth.setText(seedDepthString);

        TextView seedSpacing = (TextView) findViewById(R.id.seedSpacing);
        String seedSpacingString =intent.getStringExtra("seed_spacing") + "(in) apart.";
        seedSpacing.setText(seedSpacingString);

        TextView rowSpacing = (TextView) findViewById(R.id.rowSpacing);
        String rowSpacingString = intent.getStringExtra("row_spacing") + "(in) apart.";
        rowSpacing.setText(rowSpacingString);

        TextView plantsPerSquareFoot = (TextView) findViewById(R.id.plantsPerSquareFoot);
        String plantsPerSquareFootString = intent.getStringExtra("plants_per_square_foot") + " per square foot.";
        plantsPerSquareFoot.setText(plantsPerSquareFootString);

        TextView startDate = (TextView) findViewById(R.id.startDate);
        String startDateString =  intent.getStringExtra("start_date");
        startDate.setText(startDateString);

        TextView daysToHarvest = (TextView) findViewById(R.id.daysToHarvest);
        String daysToHarvestString = intent.getStringExtra("days_to_harvest") + " days.";
        daysToHarvest.setText(daysToHarvestString);

        TextView sunLevel = (TextView) findViewById(R.id.sunLevelTextView);
        String sunLevelIntent = intent.getStringExtra("sun_level");
        String sunLevelString = "Sun Level: " + sunLevelIntent;
        sunLevel.setText(sunLevelString);

        if (sunLevelIntent.equals("Full")) {
            sunIcon.setImageResource(R.drawable.full_sun);
        } else if (sunLevelIntent.equals("Partial")) {
            sunIcon.setImageResource(R.drawable.partial_sun);
        } else {
            sunIcon.setImageResource(R.drawable.shady_sun);
        }

        TextView numWateringsPerWeek = (TextView) findViewById(R.id.numWateringsPerWeek);
        String numWateringsPerWeekString = intent.getStringExtra("num_waterings_per_week") + " times a week.";

        numWateringsPerWeek.setText(numWateringsPerWeekString);

        TextView amountWaterPerWeek = (TextView) findViewById(R.id.amountWaterPerWeek);
        String amountWaterPerWeekString = intent.getStringExtra("amount_water_per_week") + " gallons per week.";
        amountWaterPerWeek.setText(amountWaterPerWeekString);

        TextView numWeedingsPerWeek = (TextView) findViewById(R.id.numWeedingsPerWeek);
        String numWeedingsPerWeekString = intent.getStringExtra("num_weedings_per_week") + " times per week.";
        numWeedingsPerWeek.setText(numWeedingsPerWeekString);

        TextView plantNotes = (TextView) findViewById(R.id.plantNotes);
        String plantNotesString = intent.getStringExtra("plant_notes");
        plantNotes.setText(plantNotesString);


        ImageView plantImageView = (ImageView) findViewById(R.id.plantImageView);
        String plantImageIntent = intent.getStringExtra("plant_image");

        // Sets image
        int imgId = getResources().getIdentifier(plantImageIntent, "drawable", getPackageName());
        plantImageView.setImageResource(imgId);


        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(this);

        Button deleteButton = (Button) findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlantDatabase plantDatabase = PlantDatabase.getPlantDatabaseInstance(getApplicationContext());
                List<Plant> plants = plantDatabase.plantDao().getAllPlants();

                // Notification Implementation
                NotificationDatabase notificationDatabase = NotificationDatabase.getNotificationDatabaseInstance(getApplicationContext());
                List<Notification> notifications = notificationDatabase.notificationDao().getAllNotifications();

                for (int i = 0; i < plants.size(); i++) {
                    if (plants.get(i).plantName.equals(intent.getStringExtra("plant_name"))) {
                        plantDatabase.plantDao().deletePlant(plants.get(i));

                        for (Notification notif:notifications) {
                            if (notif.plantName.equals(plants.get(i).plantName)) {
                                notificationDatabase.notificationDao().deleteNotification(notif);
                            }
                        }
                        startActivity(new Intent(getApplicationContext(), MyPlants_Base.class));
                        finish();
                    }
                }

            }
        });

        Button editButton = (Button) findViewById(R.id.editButton);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editIntent = new Intent(getApplicationContext(), MyPlants_EditPlant2.class);
                editIntent.putExtras(intent.getExtras());
                startActivity(editIntent);
                finish();

            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.backButton) {
            finish();
        }
    }
}

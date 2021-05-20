package com.illinois.cs465.plantability;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.illinois.cs465.plantability.notificationDatabase.Notification;
import com.illinois.cs465.plantability.notificationDatabase.NotificationDatabase;
import com.illinois.cs465.plantability.plantDatabase.Plant;
import com.illinois.cs465.plantability.plantDatabase.PlantDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Discover_AddToMyPlants extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.discover_add_to_my_plants);

        Intent intent = getIntent();
        final Bundle previousExtras = intent.getExtras();

        final EditText plantNameInput = (EditText) findViewById(R.id.plantNameInput);
        if (intent.getStringExtra("plant_name") != null) {
            plantNameInput.setText(intent.getStringExtra("plant_name"));
        }

        final String plantName = intent.getStringExtra("plant_name");
        final String plantImage = intent.getStringExtra("plant_image");
        final String seedDepth = intent.getStringExtra("seed_depth");
        final String seedSpacing = intent.getStringExtra("seed_spacing");
        final String rowSpacing = intent.getStringExtra("row_spacing");
        final String plantsPerSquareFoot = intent.getStringExtra("plants_per_square_foot");
        final String startDate = intent.getStringExtra("start_date");
        final String daysToHarvest = intent.getStringExtra("days_to_harvest");
        final String sunLevel = intent.getStringExtra("sun_level");
        final String numWateringTimesPerWeek = intent.getStringExtra("num_waterings_per_week");
        final String amountWaterPerWeek = intent.getStringExtra("amount_water_per_week");
        final String numWeedingTimesPerWeek = intent.getStringExtra("num_weedings_per_week");
        final String plantNotes = intent.getStringExtra("plant_notes");

        Button doneButton = (Button) findViewById(R.id.doneButton);
        Button cancelButton = (Button) findViewById(R.id.cancelButton);


        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String plantName = plantNameInput.getText().toString();
                if (plantName.equals("")) {
                    plantName = "NO NAME";
                }
                addNewPlant(plantName, plantImage, seedDepth, seedSpacing, rowSpacing, plantsPerSquareFoot, startDate, daysToHarvest,
                        sunLevel, numWateringTimesPerWeek, amountWaterPerWeek, numWeedingTimesPerWeek, plantNotes);

                startActivity(new Intent(getApplicationContext(), MyPlants_Base.class));
                finish();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Discover_PlantDetails.class);
                intent.putExtras(previousExtras);
                startActivity(intent);
                finish();
            }
        });
    }


    private void addNewPlant(String plantName, String plantImage, String seedDepth, String seedSpacing, String rowSpacing, String plantsPerSquareFoot,
                             String startDate, String daysToHarvest, String sunLevel, String numWateringTimesPerWeek, String amountWaterPerWeek,
                             String numWeedingTimesPerWeek, String plantNotes) {
        PlantDatabase plantDatabase = PlantDatabase.getPlantDatabaseInstance(this.getApplicationContext());

        // Adding Notification Database Implementation here
        NotificationDatabase notificationDatabase = NotificationDatabase.getNotificationDatabaseInstance(this.getApplicationContext());
        Notification start_notification = new Notification();
        Notification harvest_notification = new Notification();
//        TODO implement the reoccurring events
//        Notification water_notification = new Notification();
//        Notification weed_notification = new Notification();
        String eventTitle = "";

        // Handling incomplete inputs...
        // TODO COPY CHANGES HERE
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
        String format = s.format(new Date());
        String[] cur_tokens = format.split("/");
        String curDay = cur_tokens[0];
        String curMonth = cur_tokens[1];
        String curYear = cur_tokens[2];

        start_notification.startMonth = curMonth;
        start_notification.startDay = curDay;
        start_notification.startYear = curYear;
        start_notification.endMonth = curMonth;
        start_notification.endDay = curDay;
        start_notification.endYear = curYear;

        boolean harvest_bool = false;

        Plant plant = new Plant();
        if (plantName != null && !plantName.equals("")) {
            plant.plantName = plantName;
            // Notification Implementation
            eventTitle += plant.plantName;
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
            // Notification Implementation
            String[] tokens = startDate.split("/"); // MM/DD/YYYY
            start_notification.startMonth = tokens[0];
            start_notification.startDay = tokens[1];
            start_notification.startYear = tokens[2];

            start_notification.endMonth = tokens[0];
            start_notification.endDay = tokens[1];
            start_notification.endYear = tokens[2];
        }
        if (daysToHarvest != null && !daysToHarvest.equals("")) {
            plant.daysToHarvest = daysToHarvest;

            // Notification Implementation
            harvest_bool = true;         // TODO COPY CHANGES HERE
            String[] tokens = startDate.split("/"); // MM/DD/YYYY
            String start_month = tokens[0];
            String start_day = tokens[1];
            String start_year = tokens[2];

            // TODO ??? timezone?
            String start_string = start_year + "-" + start_month + "-" + start_day;
//            https://stackoverflow.com/questions/8738369/how-to-add-days-into-the-date-in-android/8738398
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            try {
                c.setTime(sdf.parse(start_string));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            c.add(Calendar.DATE, Integer.parseInt(daysToHarvest));
            String harvest_date = sdf.format(c.getTime());
            String[] harvest_tokens = harvest_date.split("-");
            harvest_notification.startYear = harvest_tokens[0];
            harvest_notification.startMonth = harvest_tokens[1];
            harvest_notification.startDay = harvest_tokens[2];
            harvest_notification.endYear = harvest_tokens[0];
            harvest_notification.endMonth = harvest_tokens[1];
            harvest_notification.endDay = harvest_tokens[2];

//            TODO Remove Failed Attempt
//            DateTime start_dateTime = DateTime.parseRfc3339(start_string);
//            DateTime harvest_dateTime = start_dateTime.AddDays(Integer.parseInt(daysToHarvest));
        }
        if (sunLevel != null && (sunLevel.equals("Shaded") || sunLevel.equals("Partial") || sunLevel.equals("Full"))) {
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

        // Notification Implementations
        start_notification.plantName = eventTitle;
        start_notification.eventType = "Start Seeds";
        start_notification.eventTitle = eventTitle + ": Start Seeds";

        harvest_notification.plantName = eventTitle;
        harvest_notification.eventType = "Harvest Plant";
        harvest_notification.eventTitle = eventTitle + ": Harvest Plant";

        notificationDatabase.notificationDao().insertNotification(start_notification);
        if(harvest_bool){         // TODO COPY CHANGES HERE
            notificationDatabase.notificationDao().insertNotification(harvest_notification);
        }

        // TODO add these
//        notificationDatabase.notificationDao().insertNotification(water_notification);
//        notificationDatabase.notificationDao().insertNotification(weed_notification);
    }
}
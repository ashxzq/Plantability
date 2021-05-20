package com.illinois.cs465.plantability;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MyPlants_EditPlant4 extends AppCompatActivity implements View.OnClickListener {
    // New data gathered on this page
    private EditText sunLevelInput;
    private EditText numWateringTimesPerWeekInput;
    private EditText amountWaterPerWeekInput;

    // Data gathered on previous pages
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_plants_edit_plant_4);

        Intent intent = getIntent();
        final Bundle previousExtras = intent.getExtras();

        ImageView fullSunIcon = (ImageView) findViewById(R.id.fullSunIcon);
        ImageView partialSunIcon = (ImageView) findViewById(R.id.partialSunIcon);
        ImageView noSunIcon = (ImageView) findViewById(R.id.noSunIcon);

        final LinearLayout fullSunBorder = (LinearLayout) findViewById(R.id.fulldSunBorder);
        final LinearLayout partialSunBorder = (LinearLayout) findViewById(R.id.partialSunBorder);
        final LinearLayout shadedSunBorder = (LinearLayout) findViewById(R.id.shadedSunBorder);

        String intentSunLevel = intent.getStringExtra("sun_level");
        sunLevelInput = (EditText) findViewById(R.id.sunLevelInput);
        if (intentSunLevel != null) {
            if (intentSunLevel.toLowerCase().equals("full")) {
                fullSunBorder.setBackgroundColor(Color.BLACK);
                sunLevelInput.setText("Full");

            } else if (intentSunLevel.toLowerCase().equals("partial")) {
                partialSunBorder.setBackgroundColor(Color.BLACK);
                sunLevelInput.setText("Partial");

            } else if (intentSunLevel.toLowerCase().equals("shaded")) {
                shadedSunBorder.setBackgroundColor(Color.BLACK);
                sunLevelInput.setText("Shaded");
            }
        }

        numWateringTimesPerWeekInput = (EditText) findViewById(R.id.numWateringTimesPerWeekInput);
        numWateringTimesPerWeekInput.setText(intent.getStringExtra("num_waterings_per_week"));

        amountWaterPerWeekInput = (EditText) findViewById(R.id.amountWaterPerWeekInput);
        amountWaterPerWeekInput.setText(intent.getStringExtra("amount_water_per_week"));

        fullSunIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sunLevelInput.setText("Full");
                fullSunBorder.setBackgroundColor(Color.BLACK);
                partialSunBorder.setBackgroundColor(Color.WHITE);
                shadedSunBorder.setBackgroundColor(Color.WHITE);
            }
        });
        partialSunIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sunLevelInput.setText("Partial");
                partialSunBorder.setBackgroundColor(Color.BLACK);
                fullSunBorder.setBackgroundColor(Color.WHITE);
                shadedSunBorder.setBackgroundColor(Color.WHITE);
            }
        });
        noSunIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sunLevelInput.setText("Shaded");
                shadedSunBorder.setBackgroundColor(Color.BLACK);
                partialSunBorder.setBackgroundColor(Color.WHITE);
                fullSunBorder.setBackgroundColor(Color.WHITE);
            }
        });

        Button nextButton = (Button) findViewById(R.id.nextButtonAP4);
        Button backButton = (Button) findViewById(R.id.backButtonAP4);
        Button cancelButton = (Button) findViewById(R.id.cancelButtonAP4);


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyPlants_EditPlant5.class);
                intent.putExtras(previousExtras);

                String sunLevel = sunLevelInput.getText().toString().toLowerCase();
                if (intent.getStringExtra("sun_level") != null) {
                    intent.removeExtra("sun_level");
                }
                intent.putExtra("sun_level", sunLevel);

                String numWateringTimesPerWeek = numWateringTimesPerWeekInput.getText().toString().replaceAll("[^0-9.-]", "");
                if (intent.getStringExtra("num_waterings_per_week") != null) {
                    intent.removeExtra("num_waterings_per_week");
                }
                intent.putExtra("num_waterings_per_week", numWateringTimesPerWeek);


                String amountWaterPerWeek = amountWaterPerWeekInput.getText().toString().replaceAll("[^0-9.-]", "");
                if (intent.getStringExtra("amount_water_per_week") != null) {
                    intent.removeExtra("amount_water_per_week");
                }
                intent.putExtra("amount_water_per_week", amountWaterPerWeek);

                startActivity(intent);
                finish();
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyPlants_EditPlant3.class);
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
        if (v.getId() == R.id.cancelButtonAP4) {
            Intent intent = new Intent(getApplicationContext(), MyPlants_Base.class);
            startActivity(intent);
            finish();
        }
    }

}

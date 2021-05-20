package com.illinois.cs465.plantability;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MyPlants_AddPlant3 extends AppCompatActivity implements View.OnClickListener {
    // New data gathered on this page
    private EditText startDateInput;
    private EditText daysToHarvestInput;

    // Data gathered on previous pages
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_plants_add_plant_3);

        Intent intent = getIntent();
        final Bundle previousExtras = intent.getExtras();

        startDateInput = (EditText) findViewById(R.id.startDateInput);
        if (intent.getStringExtra("start_date") != null) {
            startDateInput.setText(intent.getStringExtra("start_date"));
        }
        daysToHarvestInput = (EditText) findViewById(R.id.daysToHarvestInput);
        if (intent.getStringExtra("days_to_harvest") != null) {
            daysToHarvestInput.setText(intent.getStringExtra("days_to_harvest"));
        }

        Button nextButton = (Button) findViewById(R.id.nextButtonAP3);
        Button backButton = (Button) findViewById(R.id.backButtonAP3);
        Button cancelButton = (Button) findViewById(R.id.cancelButtonAP3);


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyPlants_AddPlant4.class);
                intent.putExtras(previousExtras);

                String startDate = startDateInput.getText().toString().replaceAll("[^0-9/-]", "");
                if (intent.getStringExtra("start_date") != null) {
                    intent.removeExtra("start_date");
                }
                intent.putExtra("start_date", startDate);

                String daysToHarvest = daysToHarvestInput.getText().toString().replaceAll("[^0-9.-]", "");
                if (intent.getStringExtra("days_to_harvest") != null) {
                    intent.removeExtra("days_to_harvest");
                }
                intent.putExtra("days_to_harvest", daysToHarvest);

                startActivity(intent);
                finish();
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyPlants_AddPlant2.class);
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
        if (v.getId() == R.id.cancelButtonAP3) {
            startActivity(new Intent(this, MyPlants_Base.class));
            finish();
        }
    }

}



/*package com.illinois.cs465.plantability;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MyPlants_AddPlant3 extends AppCompatActivity implements View.OnClickListener {
    // New data gathered on this page
    private EditText startDateInput;
    private EditText daysToHarvestInput;

    // Data gathered on previous pages
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_plants_add_plant_3);

        Intent intent = getIntent();
        final Bundle previousExtras = intent.getExtras();

        startDateInput = (EditText) findViewById(R.id.startDateInput);
        if (intent.getStringExtra("start_date") != null) {
            startDateInput.setText(intent.getStringExtra("start_date"));
        }
        daysToHarvestInput = (EditText) findViewById(R.id.daysToHarvestInput);
        if (intent.getStringExtra("days_to_harvest") != null) {
            daysToHarvestInput.setText(intent.getStringExtra("days_to_harvest"));
        }

        Button nextButton = (Button) findViewById(R.id.nextButtonAP3);
        Button backButton = (Button) findViewById(R.id.backButtonAP3);
        Button cancelButton = (Button) findViewById(R.id.cancelButtonAP3);


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyPlants_AddPlant4.class);

                if (previousExtras != null) {
                    intent.putExtras(previousExtras);
                }

                String startDate = startDateInput.getText().toString().replaceAll("[^0-9/]", "");
                intent.putExtra("start_date", startDate);

                String daysToHarvest = daysToHarvestInput.getText().toString().replaceAll("[^0-9.]", "");
                intent.putExtra("days_to_harvest", daysToHarvest);

                startActivity(intent);
                finish();
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyPlants_AddPlant2.class);
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
        if (v.getId() == R.id.cancelButtonAP3) {
            startActivity(new Intent(this, MyPlants_Base.class));
            finish();
        }
    }

}*/

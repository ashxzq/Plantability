package com.illinois.cs465.plantability;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.illinois.cs465.plantability.plantDatabase.Plant;
import com.illinois.cs465.plantability.plantDatabase.PlantDatabase;

public class MyPlants_AddPlant2 extends AppCompatActivity implements View.OnClickListener {
    // New data gathered on this page
    private EditText seedDepthInput;
    private EditText seedSpacingInput;
    private EditText rowSpacingInput;
    private EditText plantsPerSquareFootInput;
    // Data gathered on previous pages
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_plants_add_plant_2);

        Intent intent = getIntent();
        final Bundle previousExtras = intent.getExtras();

        seedDepthInput = (EditText) findViewById(R.id.seedDepthInput);
        if (intent.getStringExtra("seed_depth") != null) {
            seedDepthInput.setText(intent.getStringExtra("seed_depth"));
        }
        seedSpacingInput = (EditText) findViewById(R.id.seedSpacingInput);
        if (intent.getStringExtra("seed_spacing") != null) {
            seedSpacingInput.setText(intent.getStringExtra("seed_spacing"));
        }
        rowSpacingInput = (EditText) findViewById(R.id.rowSpacingInput);
        if (intent.getStringExtra("row_spacing") != null) {
            rowSpacingInput.setText(intent.getStringExtra("row_spacing"));
        }
        plantsPerSquareFootInput = (EditText) findViewById(R.id.plantsPerSquareFootInput);
        if (intent.getStringExtra("plants_per_square_foot") != null) {
            plantsPerSquareFootInput.setText(intent.getStringExtra("plants_per_square_foot"));
        }

        Button nextButton = (Button) findViewById(R.id.nextButtonAP2);
        Button backButton = (Button) findViewById(R.id.backButtonAP2);
        Button cancelButton = (Button) findViewById(R.id.cancelButtonAP2);


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyPlants_AddPlant3.class);
                intent.putExtras(previousExtras);

                String seedDepth = seedDepthInput.getText().toString().replaceAll("[^0-9.-]", "");
                if (intent.getStringExtra("seed_depth") != null) {
                    intent.removeExtra("seed_depth");
                }
                intent.putExtra("seed_depth", seedDepth);

                String seedSpacing = seedSpacingInput.getText().toString().replaceAll("[^0-9.-]", "");
                if (intent.getStringExtra("seed_spacing") != null) {
                    intent.removeExtra("seed_spacing");
                }
                intent.putExtra("seed_spacing", seedSpacing);

                String rowSpacing = rowSpacingInput.getText().toString().replaceAll("[^0-9.-]", "");
                if (intent.getStringExtra("row_spacing") != null) {
                    intent.removeExtra("row_spacing");
                }
                intent.putExtra("row_spacing", rowSpacing);

                String plantsPerSquareFoot = plantsPerSquareFootInput.getText().toString().replaceAll("[^0-9.-]", "");
                if (intent.getStringExtra("plants_per_square_foot") != null) {
                    intent.removeExtra("plants_per_square_foot");
                }
                intent.putExtra("plants_per_square_foot", plantsPerSquareFoot);

                startActivity(intent);
                finish();
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyPlants_AddPlant1.class);
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
        if (v.getId() == R.id.cancelButtonAP2) {
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

import com.illinois.cs465.plantability.plantDatabase.Plant;
import com.illinois.cs465.plantability.plantDatabase.PlantDatabase;

public class MyPlants_AddPlant2 extends AppCompatActivity implements View.OnClickListener {
    // New data gathered on this page
    private EditText seedDepthInput;
    private EditText seedSpacingInput;
    private EditText rowSpacingInput;
    private EditText plantsPerSquareFootInput;
    // Data gathered on previous pages
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_plants_add_plant_2);

        Intent intent = getIntent();
        final Bundle previousExtras = intent.getExtras();

        seedDepthInput = (EditText) findViewById(R.id.seedDepthInput);
        if (intent.getStringExtra("seed_depth") != null) {
            seedDepthInput.setText(intent.getStringExtra("seed_depth"));
        }
        seedSpacingInput = (EditText) findViewById(R.id.seedSpacingInput);
        if (intent.getStringExtra("seed_spacing") != null) {
            seedSpacingInput.setText(intent.getStringExtra("seed_spacing"));
        }
        rowSpacingInput = (EditText) findViewById(R.id.rowSpacingInput);
        if (intent.getStringExtra("row_spacing") != null) {
            rowSpacingInput.setText(intent.getStringExtra("row_spacing"));
        }
        plantsPerSquareFootInput = (EditText) findViewById(R.id.plantsPerSquareFootInput);
        if (intent.getStringExtra("plants_per_square_foot") != null) {
            plantsPerSquareFootInput.setText(intent.getStringExtra("plants_per_square_foot"));
        }

        Button nextButton = (Button) findViewById(R.id.nextButtonAP2);
        Button backButton = (Button) findViewById(R.id.backButtonAP2);
        Button cancelButton = (Button) findViewById(R.id.cancelButtonAP2);


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyPlants_AddPlant3.class);

                if (previousExtras != null) {
                    intent.putExtras(previousExtras);
                }

                String seedDepth = seedDepthInput.getText().toString().replaceAll("[^0-9.]", "");
                intent.putExtra("seed_depth", seedDepth);

                String seedSpacing = seedSpacingInput.getText().toString().replaceAll("[^0-9.]", "");
                intent.putExtra("seed_spacing", seedSpacing);

                String rowSpacing = rowSpacingInput.getText().toString().replaceAll("[^0-9.]", "");
                intent.putExtra("row_spacing", rowSpacing);

                String plantsPerSquareFoot = plantsPerSquareFootInput.getText().toString().replaceAll("[^0-9.]", "");
                intent.putExtra("plants_per_square_foot", plantsPerSquareFoot);

                startActivity(intent);
                finish();
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyPlants_AddPlant1.class);
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
        if (v.getId() == R.id.cancelButtonAP2) {
            startActivity(new Intent(this, MyPlants_Base.class));
            finish();
        }
    }
}
*/
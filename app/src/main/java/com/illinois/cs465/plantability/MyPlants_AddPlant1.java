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

public class MyPlants_AddPlant1 extends AppCompatActivity implements View.OnClickListener {
    String plantImageInput = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_plants_add_plant_1);

        Intent intent = getIntent();

        final EditText plantNameInput = (EditText) findViewById(R.id.plantNameInput);
        if (intent.getStringExtra("plant_name") != null) {
            plantNameInput.setText(intent.getStringExtra("plant_name"));
        }

        Button nextButton = (Button) findViewById(R.id.nextButtonAP1);
        Button backButton = (Button) findViewById(R.id.backButtonAP1);
        Button cancelButton = (Button) findViewById(R.id.cancelButtonAP1);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyPlants_AddPlant2.class);
                String plantName = plantNameInput.getText().toString();
                if (plantName.equals("")) {
                    plantName = "NO NAME";
                }
                if (intent.getStringExtra("plant_name") != null) {
                    intent.removeExtra("plant_name");
                }
                intent.putExtra("plant_name", plantName);

                intent.putExtra("plant_image", plantImageInput);

                startActivity(intent);
                finish();
            }
        });
        backButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);



        ImageView pumpkinIcon = (ImageView) findViewById(R.id.pumpkinIcon);
        final LinearLayout pumpkinBorder = (LinearLayout) findViewById(R.id.pumpkinBorder);

        ImageView grapeIcon = (ImageView) findViewById(R.id.grapeIcon);
        final LinearLayout grapeBorder = (LinearLayout) findViewById(R.id.grapeBorder);

        ImageView cornIcon = (ImageView) findViewById(R.id.cornIcon);
        final LinearLayout cornBorder = (LinearLayout) findViewById(R.id.cornBorder);

        ImageView broccoliIcon = (ImageView) findViewById(R.id.broccoliIcon);
        final LinearLayout broccoliBorder = (LinearLayout) findViewById(R.id.broccoliBorder);

        ImageView potatoIcon = (ImageView) findViewById(R.id.potatoIcon);
        final LinearLayout potatoBorder = (LinearLayout) findViewById(R.id.potatoBorder);

        ImageView carrotIcon = (ImageView) findViewById(R.id.carrotIcon);
        final LinearLayout carrotBorder = (LinearLayout) findViewById(R.id.carrotBorder);

        ImageView tomatoIcon = (ImageView) findViewById(R.id.tomatoIcon);
        final LinearLayout tomatoBorder = (LinearLayout) findViewById(R.id.tomatoBorder);

        ImageView watermelonIcon = (ImageView) findViewById(R.id.watermelonIcon);
        final LinearLayout watermelonBorder = (LinearLayout) findViewById(R.id.watermelonBorder);

        ImageView cucumberIcon = (ImageView) findViewById(R.id.cucumberIcon);
        final LinearLayout cucumberBorder = (LinearLayout) findViewById(R.id.cucumberBorder);

        ImageView blueberryIcon = (ImageView) findViewById(R.id.blueberryIcon);
        final LinearLayout blueberryBorder = (LinearLayout) findViewById(R.id.blueberryBorder);

        ImageView blackberryIcon = (ImageView) findViewById(R.id.blackberryIcon);
        final LinearLayout blackberryBorder = (LinearLayout) findViewById(R.id.blackberryBorder);

        ImageView raspberryIcon = (ImageView) findViewById(R.id.raspberryIcon);
        final LinearLayout raspberryBorder = (LinearLayout) findViewById(R.id.raspberryBorder);

        pumpkinIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plantImageInput = "pumpkin";
                pumpkinBorder.setBackgroundColor(Color.BLACK);
                grapeBorder.setBackgroundColor(Color.WHITE);
                cornBorder.setBackgroundColor(Color.WHITE);
                broccoliBorder.setBackgroundColor(Color.WHITE);
                potatoBorder.setBackgroundColor(Color.WHITE);
                carrotBorder.setBackgroundColor(Color.WHITE);
                tomatoBorder.setBackgroundColor(Color.WHITE);
                watermelonBorder.setBackgroundColor(Color.WHITE);
                cucumberBorder.setBackgroundColor(Color.WHITE);
                blueberryBorder.setBackgroundColor(Color.WHITE);
                blackberryBorder.setBackgroundColor(Color.WHITE);
                raspberryBorder.setBackgroundColor(Color.WHITE);
            }
        });
        grapeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plantImageInput = "grape";
                pumpkinBorder.setBackgroundColor(Color.WHITE);
                grapeBorder.setBackgroundColor(Color.BLACK);
                cornBorder.setBackgroundColor(Color.WHITE);
                broccoliBorder.setBackgroundColor(Color.WHITE);
                potatoBorder.setBackgroundColor(Color.WHITE);
                carrotBorder.setBackgroundColor(Color.WHITE);
                tomatoBorder.setBackgroundColor(Color.WHITE);
                watermelonBorder.setBackgroundColor(Color.WHITE);
                cucumberBorder.setBackgroundColor(Color.WHITE);
                blueberryBorder.setBackgroundColor(Color.WHITE);
                blackberryBorder.setBackgroundColor(Color.WHITE);
                raspberryBorder.setBackgroundColor(Color.WHITE);
            }
        });
        cornIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plantImageInput = "corn";
                pumpkinBorder.setBackgroundColor(Color.WHITE);
                grapeBorder.setBackgroundColor(Color.WHITE);
                cornBorder.setBackgroundColor(Color.BLACK);
                broccoliBorder.setBackgroundColor(Color.WHITE);
                potatoBorder.setBackgroundColor(Color.WHITE);
                carrotBorder.setBackgroundColor(Color.WHITE);
                tomatoBorder.setBackgroundColor(Color.WHITE);
                watermelonBorder.setBackgroundColor(Color.WHITE);
                cucumberBorder.setBackgroundColor(Color.WHITE);
                blueberryBorder.setBackgroundColor(Color.WHITE);
                blackberryBorder.setBackgroundColor(Color.WHITE);
                raspberryBorder.setBackgroundColor(Color.WHITE);
            }
        });
        broccoliIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plantImageInput = "broccoli";
                pumpkinBorder.setBackgroundColor(Color.WHITE);
                grapeBorder.setBackgroundColor(Color.WHITE);
                cornBorder.setBackgroundColor(Color.WHITE);
                broccoliBorder.setBackgroundColor(Color.BLACK);
                potatoBorder.setBackgroundColor(Color.WHITE);
                carrotBorder.setBackgroundColor(Color.WHITE);
                tomatoBorder.setBackgroundColor(Color.WHITE);
                watermelonBorder.setBackgroundColor(Color.WHITE);
                cucumberBorder.setBackgroundColor(Color.WHITE);
                blueberryBorder.setBackgroundColor(Color.WHITE);
                blackberryBorder.setBackgroundColor(Color.WHITE);
                raspberryBorder.setBackgroundColor(Color.WHITE);
            }
        });
        potatoIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plantImageInput = "potato";
                pumpkinBorder.setBackgroundColor(Color.WHITE);
                grapeBorder.setBackgroundColor(Color.WHITE);
                cornBorder.setBackgroundColor(Color.WHITE);
                broccoliBorder.setBackgroundColor(Color.WHITE);
                potatoBorder.setBackgroundColor(Color.BLACK);
                carrotBorder.setBackgroundColor(Color.WHITE);
                tomatoBorder.setBackgroundColor(Color.WHITE);
                watermelonBorder.setBackgroundColor(Color.WHITE);
                cucumberBorder.setBackgroundColor(Color.WHITE);
                blueberryBorder.setBackgroundColor(Color.WHITE);
                blackberryBorder.setBackgroundColor(Color.WHITE);
                raspberryBorder.setBackgroundColor(Color.WHITE);
            }
        });
        carrotIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plantImageInput = "carrot";
                pumpkinBorder.setBackgroundColor(Color.WHITE);
                grapeBorder.setBackgroundColor(Color.WHITE);
                cornBorder.setBackgroundColor(Color.WHITE);
                broccoliBorder.setBackgroundColor(Color.WHITE);
                potatoBorder.setBackgroundColor(Color.WHITE);
                carrotBorder.setBackgroundColor(Color.BLACK);
                tomatoBorder.setBackgroundColor(Color.WHITE);
                watermelonBorder.setBackgroundColor(Color.WHITE);
                cucumberBorder.setBackgroundColor(Color.WHITE);
                blueberryBorder.setBackgroundColor(Color.WHITE);
                blackberryBorder.setBackgroundColor(Color.WHITE);
                raspberryBorder.setBackgroundColor(Color.WHITE);
            }
        });
        tomatoIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plantImageInput = "tomato";
                pumpkinBorder.setBackgroundColor(Color.WHITE);
                grapeBorder.setBackgroundColor(Color.WHITE);
                cornBorder.setBackgroundColor(Color.WHITE);
                broccoliBorder.setBackgroundColor(Color.WHITE);
                potatoBorder.setBackgroundColor(Color.WHITE);
                carrotBorder.setBackgroundColor(Color.WHITE);
                tomatoBorder.setBackgroundColor(Color.BLACK);
                watermelonBorder.setBackgroundColor(Color.WHITE);
                cucumberBorder.setBackgroundColor(Color.WHITE);
                blueberryBorder.setBackgroundColor(Color.WHITE);
                blackberryBorder.setBackgroundColor(Color.WHITE);
                raspberryBorder.setBackgroundColor(Color.WHITE);
            }
        });
        watermelonIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plantImageInput = "watermelon";
                pumpkinBorder.setBackgroundColor(Color.WHITE);
                grapeBorder.setBackgroundColor(Color.WHITE);
                cornBorder.setBackgroundColor(Color.WHITE);
                broccoliBorder.setBackgroundColor(Color.WHITE);
                potatoBorder.setBackgroundColor(Color.WHITE);
                carrotBorder.setBackgroundColor(Color.WHITE);
                tomatoBorder.setBackgroundColor(Color.WHITE);
                watermelonBorder.setBackgroundColor(Color.BLACK);
                cucumberBorder.setBackgroundColor(Color.WHITE);
                blueberryBorder.setBackgroundColor(Color.WHITE);
                blackberryBorder.setBackgroundColor(Color.WHITE);
                raspberryBorder.setBackgroundColor(Color.WHITE);
            }
        });
        cucumberIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plantImageInput = "cucumber";
                pumpkinBorder.setBackgroundColor(Color.WHITE);
                grapeBorder.setBackgroundColor(Color.WHITE);
                cornBorder.setBackgroundColor(Color.WHITE);
                broccoliBorder.setBackgroundColor(Color.WHITE);
                potatoBorder.setBackgroundColor(Color.WHITE);
                carrotBorder.setBackgroundColor(Color.WHITE);
                tomatoBorder.setBackgroundColor(Color.WHITE);
                watermelonBorder.setBackgroundColor(Color.WHITE);
                cucumberBorder.setBackgroundColor(Color.BLACK);
                blueberryBorder.setBackgroundColor(Color.WHITE);
                blackberryBorder.setBackgroundColor(Color.WHITE);
                raspberryBorder.setBackgroundColor(Color.WHITE);
            }
        });
        blueberryIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plantImageInput = "blueberry";
                pumpkinBorder.setBackgroundColor(Color.WHITE);
                grapeBorder.setBackgroundColor(Color.WHITE);
                cornBorder.setBackgroundColor(Color.WHITE);
                broccoliBorder.setBackgroundColor(Color.WHITE);
                potatoBorder.setBackgroundColor(Color.WHITE);
                carrotBorder.setBackgroundColor(Color.WHITE);
                tomatoBorder.setBackgroundColor(Color.WHITE);
                watermelonBorder.setBackgroundColor(Color.WHITE);
                cucumberBorder.setBackgroundColor(Color.WHITE);
                blueberryBorder.setBackgroundColor(Color.BLACK);
                blackberryBorder.setBackgroundColor(Color.WHITE);
                raspberryBorder.setBackgroundColor(Color.WHITE);
            }
        });
        blackberryIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plantImageInput = "blackberry";
                pumpkinBorder.setBackgroundColor(Color.WHITE);
                grapeBorder.setBackgroundColor(Color.WHITE);
                cornBorder.setBackgroundColor(Color.WHITE);
                broccoliBorder.setBackgroundColor(Color.WHITE);
                potatoBorder.setBackgroundColor(Color.WHITE);
                carrotBorder.setBackgroundColor(Color.WHITE);
                tomatoBorder.setBackgroundColor(Color.WHITE);
                watermelonBorder.setBackgroundColor(Color.WHITE);
                cucumberBorder.setBackgroundColor(Color.WHITE);
                blueberryBorder.setBackgroundColor(Color.WHITE);
                blackberryBorder.setBackgroundColor(Color.BLACK);
                raspberryBorder.setBackgroundColor(Color.WHITE);
            }
        });
        raspberryIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plantImageInput = "raspberry";
                pumpkinBorder.setBackgroundColor(Color.WHITE);
                grapeBorder.setBackgroundColor(Color.WHITE);
                cornBorder.setBackgroundColor(Color.WHITE);
                broccoliBorder.setBackgroundColor(Color.WHITE);
                potatoBorder.setBackgroundColor(Color.WHITE);
                carrotBorder.setBackgroundColor(Color.WHITE);
                tomatoBorder.setBackgroundColor(Color.WHITE);
                watermelonBorder.setBackgroundColor(Color.WHITE);
                cucumberBorder.setBackgroundColor(Color.WHITE);
                blueberryBorder.setBackgroundColor(Color.WHITE);
                blackberryBorder.setBackgroundColor(Color.WHITE);
                raspberryBorder.setBackgroundColor(Color.BLACK);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.backButtonAP1) {
            startActivity(new Intent(this, MyPlants_Base.class));
            finish();

        } else if (v.getId() == R.id.cancelButtonAP1) {
            startActivity(new Intent(this, MyPlants_Base.class));
            finish();
        }
    }
}
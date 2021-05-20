package com.illinois.cs465.plantability;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.illinois.cs465.plantability.notificationDatabase.Notification;
import com.illinois.cs465.plantability.notificationDatabase.NotificationDatabase;
import com.illinois.cs465.plantability.plantDatabase.PlantDatabase;
import com.illinois.cs465.plantability.plotDatabase.PlotDatabase;

public class OpeningPage extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout myPlotsClickableLayout;
    private LinearLayout myPlantsClickableLayout;
    private LinearLayout discoverClickableLayout;
    private LinearLayout notificationsClickableLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening_page);

        PlantDatabase plantDatabase = PlantDatabase.getPlantDatabaseInstance(this.getApplicationContext());
//        plantDatabase.plantDao().delete(); // FOR DEBUGGING ONLY, REMOVE FOR SUBMISSION TODO REMOVE
        NotificationDatabase notificationDatabase = NotificationDatabase.getNotificationDatabaseInstance(this.getApplicationContext());
//        notificationDatabase.notificationDao().delete();// FOR DEBUGGING ONLY, REMOVE FOR SUBMISSION TODO REMOVE
        PlotDatabase plotDatabase = PlotDatabase.getPlotDatabaseInstance(this.getApplicationContext());
//        plotDatabase.plotDao().delete();

        myPlotsClickableLayout = (LinearLayout) findViewById(R.id.my_plots_button_layout);
        myPlantsClickableLayout = (LinearLayout) findViewById(R.id.my_plants_button_layout);
        discoverClickableLayout = (LinearLayout) findViewById(R.id.discover_button_layout);
        notificationsClickableLayout = (LinearLayout) findViewById(R.id.notifications_button_layout);

        myPlotsClickableLayout.setOnClickListener(this);
        myPlantsClickableLayout.setOnClickListener(this);
        discoverClickableLayout.setOnClickListener(this);
        notificationsClickableLayout.setOnClickListener(this);
    }

    @Override // Switches activities based on "button" clicks in the bottom navigation bar
    public void onClick(View v) {
        if (v.getId() == R.id.my_plots_button_layout) {
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
        }
    }
}
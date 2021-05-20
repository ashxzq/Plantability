package com.illinois.cs465.plantability;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import com.illinois.cs465.plantability.notificationDatabase.Notification;
import com.illinois.cs465.plantability.notificationDatabase.NotificationDatabase;
import com.illinois.cs465.plantability.notificationDatabase.NotificationListAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class Notifications_Base extends AppCompatActivity implements View.OnClickListener {
    private NotificationListAdapter notificationListAdapter;

    private LinearLayout myPlotsClickableLayout;
    private LinearLayout myPlantsClickableLayout;
    private LinearLayout discoverClickableLayout;
    private Button addNotificationButton;

    private Button pastButton;
    private Button todayButton;
    private Button upcomingButton;
    private LinearLayout gcSyncButton;

    private String timeSetting = "today";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications_base);

        pastButton = (Button) findViewById(R.id.pastButton);
        todayButton = (Button) findViewById(R.id.todayButton);
        upcomingButton = (Button) findViewById(R.id.upcomingButton);
        gcSyncButton = (LinearLayout) findViewById(R.id.gcSyncButton);

        myPlotsClickableLayout = (LinearLayout) findViewById(R.id.my_plots_button_layout);
        myPlantsClickableLayout = (LinearLayout) findViewById(R.id.my_plants_button_layout);
        discoverClickableLayout = (LinearLayout) findViewById(R.id.discover_button_layout);
//        addNotificationButton = (Button) findViewById(R.id.addNotificationButton);

        pastButton.setOnClickListener(this);
        todayButton.setOnClickListener(this);
        upcomingButton.setOnClickListener(this);
        gcSyncButton.setOnClickListener(this);
        myPlotsClickableLayout.setOnClickListener(this);
        myPlantsClickableLayout.setOnClickListener(this);
        discoverClickableLayout.setOnClickListener(this);
//        addNotificationButton.setOnClickListener(this);

//        timeSetting = "today";
        pastButton.setBackgroundResource(R.drawable.button_gradient_1);
        todayButton.setBackgroundResource(R.drawable.button_gradient_2);
        upcomingButton.setBackgroundResource(R.drawable.button_gradient_1);

        initRecyclerView();

        loadNotificationList();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view_notifications);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        notificationListAdapter = new NotificationListAdapter(this);
        recyclerView.setAdapter(notificationListAdapter);
    }

    private void loadNotificationList() {
        NotificationDatabase notificationDatabase = NotificationDatabase.getNotificationDatabaseInstance(this.getApplicationContext());
        List<Notification> notificationList = notificationDatabase.notificationDao().getAllNotifications();

//        https://stackoverflow.com/questions/8077530/android-get-current-timestamp
//        SimpleDateFormat s = new SimpleDateFormat("ddMMyyyyhhmmss");
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
        String format = s.format(new Date());
        String[] tokens = format.split("/");
        int curDay = Integer.parseInt(tokens[0]);
        int curMonth = Integer.parseInt(tokens[1]);
        int curYear = Integer.parseInt(tokens[2]);

        // FOR DEBUGGING: Remove for Submission
//        curDay = 23;
//        curMonth = 04;
//        curYear = 2021;
        List<Notification> timeSettingList = new ArrayList<>();
        for(Notification tmp:notificationList) {
//            Notification tmp = notificationList.get(i);
            int startYear = Integer.parseInt(tmp.startYear);
            int startMonth = Integer.parseInt(tmp.startMonth);
            int startDay = Integer.parseInt(tmp.startDay);

            if(startYear<=0){
                startYear = curYear;
            }
            if(startMonth<=0){
                startMonth = curMonth;
            }
            if(startDay<=0){
                startDay = curDay;
            }

            if(timeSetting == "upcoming") {
                if((curYear<startYear) || (curYear==startYear && curMonth<startMonth) || (curYear==startYear && curMonth==startMonth && curDay<startDay)){
                    timeSettingList.add(tmp);
                }
            }
            else if(timeSetting == "today"){
                if(curYear == startYear && curMonth == startMonth && curDay == startDay){
                    timeSettingList.add(tmp);
                }
            }
            else if(timeSetting == "past"){
                if((curYear>startYear) || (curYear==startYear && curMonth>startMonth) || (curYear==startYear && curMonth==startMonth && curDay>startDay)){
                    timeSettingList.add(tmp);
                }
            }

        }
        // TODO Change Made here
        notificationListAdapter.setNotificationList(timeSettingList);
/*
        notificationDatabase.notificationDao().delete(); // deletes all elements
        addNewNotification("Demo Notification 1", "69");

        addNewNotification("Demo Notification 2", "420");*/
    }

    @Override
    public void onClick(View v) {
        pastButton = (Button) findViewById(R.id.pastButton);
        todayButton = (Button) findViewById(R.id.todayButton);
        upcomingButton = (Button) findViewById(R.id.upcomingButton);
        if (v.getId() == R.id.pastButton) {
            // TODO Display past notifications
            // TODO Change hue of button
            timeSetting = "past";
            loadNotificationList();
            pastButton.setBackgroundResource(R.drawable.button_gradient_2);
            todayButton.setBackgroundResource(R.drawable.button_gradient_1);
            upcomingButton.setBackgroundResource(R.drawable.button_gradient_1);
        }
        else if (v.getId() == R.id.todayButton) {
            // TODO Display todays notifications
            // TODO Change hue of button
            timeSetting = "today";
            loadNotificationList();
            pastButton.setBackgroundResource(R.drawable.button_gradient_1);
            todayButton.setBackgroundResource(R.drawable.button_gradient_2);
            upcomingButton.setBackgroundResource(R.drawable.button_gradient_1);
        }
        else if (v.getId() == R.id.upcomingButton) {
            // TODO Display upcoming notifications
            // TODO Change hue of button
            timeSetting = "upcoming";
            loadNotificationList();
            pastButton.setBackgroundResource(R.drawable.button_gradient_1);
            todayButton.setBackgroundResource(R.drawable.button_gradient_1);
            upcomingButton.setBackgroundResource(R.drawable.button_gradient_2);
        }
        else if (v.getId() == R.id.gcSyncButton) {
            // TODO
            //      Go through all notifications from database
            //      Any with sync_flag == "False" should be synced and set to "True"

            // TODO remove demo_bool
            boolean demo_bool = false;

            NotificationDatabase notificationDatabase = NotificationDatabase.getNotificationDatabaseInstance(this.getApplicationContext());
            List<Notification> notificationList = notificationDatabase.notificationDao().getAllNotifications();
            for(Notification notification:notificationList){

                // TODO FOR TESTING: TO REMOVE
//                Toast.makeText(Notifications_Base.this, "Getting notification...", Toast.LENGTH_SHORT).show();
                notification.syncFlag = "False";

                if((demo_bool==false) && (notification.syncFlag == "False")){
//                    Toast.makeText(Notifications_Base.this, "Got a notification to sync", Toast.LENGTH_SHORT).show();
                    // Add event
//                    Event event = new Event()
//                            .setSummary(notification.eventTitle);
//
//                    String startString = notification.startYear + "-" + notification.startMonth + "-" + notification.startDay + ":00:00-00:00";
//                    EventDateTime start = new EventDateTime()
//                            .setDateTime(DateTime.parseRfc3339(startString))
//                            .setTimeZone(String.valueOf(TimeZone.getDefault()));
//                    event.setStart(start);
//
//                    String endString = notification.endYear + "-" + notification.endMonth + "-" + notification.endDay + ":00:00-00:00";
//                    EventDateTime end = new EventDateTime()
//                            .setDateTime(DateTime.parseRfc3339(endString))
//                            .setTimeZone(String.valueOf(TimeZone.getDefault()));
//                    event.setEnd(end);
//
//                    Event.Reminders reminders = new Event.Reminders()
//                            .setUseDefault(true);
//                    event.setReminders(reminders);
//
//                    // TODO Set up reoccurring event implementation
//
//                    String calendarId = "primary";
                    // TODO Set up non-intent google calendar implementation
//                    event = service.events().insert(calendarId, event).execute();

                    Intent intent = new Intent(Intent.ACTION_INSERT);
                    intent.setData(CalendarContract.CONTENT_URI);
                    intent.putExtra(CalendarContract.Events.TITLE, notification.eventTitle);
                    intent.putExtra(CalendarContract.Events.ALL_DAY, true);

//                    Toast.makeText(Notifications_Base.this, "Going to try intent", Toast.LENGTH_SHORT).show();
                    demo_bool = true;
                    if(intent.resolveActivity(getPackageManager()) != null){

                        startActivity(intent);
                    } else {
                        Toast.makeText(Notifications_Base.this, "Sync Failed: No Email Provided", Toast.LENGTH_SHORT).show();
                    }

                    // Set notification sync flag to true
                    notification.syncFlag = "True";
                }
            }
            // Brings the "Enter Google Email Address" window into view
            popUpEditText("Enter Google Email Address");
        }
        else if (v.getId() == R.id.my_plots_button_layout) {
            startActivity(new Intent(this, MyPlots_Base.class));
            finish();

        } else if (v.getId() == R.id.my_plants_button_layout) {
            startActivity(new Intent(this, MyPlants_Base.class));
            finish();

        } else if (v.getId() == R.id.discover_button_layout) {
            startActivity(new Intent(this, Discover_Base.class));
            finish();

        }
//        else if (v.getId() == R.id.addNotificationButton) {
//            startActivity(new Intent(this, Notifications_EXPERIMENTAL_AddNotification.class));
//            finish();
//        }
    }
/*
    private void addNewNotification(String notificationName, String notificationData) {
        NotificationDatabase notificationDatabase = NotificationDatabase.getNotificationDatabaseInstance(this.getApplicationContext());

        Notification notification = new Notification();
        if (!notificationName.equals("")) {
            notification.notificationName = notificationName;
        }
        notification.data = notificationData;

        notificationDatabase.notificationDao().insertNotification(notification);
    }*/



    // For Demo -> Displays a popup edit text for to enter google email and password, then displays a success toast message
    private void popUpEditText(final String prompt) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(prompt);

        final EditText input = new EditText(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (prompt.equals("Enter Google Email Address")) {
                    popUpEditText("Enter Password");
                }
                if (prompt.equals("Enter Password")) {
                    Toast.makeText(Notifications_Base.this, "Synced With Google Calendar", Toast.LENGTH_SHORT).show();
                }

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();

    }
}
package com.illinois.cs465.plantability.notificationDatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Notification {
    @PrimaryKey(autoGenerate = true)
    int id;

    // TODO ??? Need event_timezone, calendar ID (username/password?)

    // Title Components
    @ColumnInfo(name = "plant_name")
    public String plantName;
    @ColumnInfo(name = "event_type")
    public String eventType;

    // Event Info
    @ColumnInfo(name = "event_title")
    public String eventTitle;
//    @ColumnInfo(name = "image") // TODO use plant implementation better to include this and more details
//    public String image;
    // TODO Include notification icons as well
    // TODO Add description

    // Event Flags
    @ColumnInfo(name = "reoccurring")
    public String reoccuring = "False"; // TODO: implement reoccurring events
    @ColumnInfo(name = "done_flag")
//    public String timeFlag = "N/A"; // "Past", "Today", or "Upcoming" // TODO ??? do we need this?
//    @ColumnInfo(name = "done_flag")
    public String doneFlag = "False";
    @ColumnInfo(name = "sync_flag")
    public String syncFlag = "False";


//    @ColumnInfo(name = "start_time")
//    public String startTime = "N/A"; // "MM/DD/YYYY"
    @ColumnInfo(name = "start_year")
    public String startYear = "N/A"; // "YYYY"
    @ColumnInfo(name = "start_month")
    public String startMonth = "N/A"; // "MM"
    @ColumnInfo(name = "start_day")
    public String startDay = "N/A"; // "DD"
//    @ColumnInfo(name = "end_time")
//    public String endTime = "N/A"; // "MM/DD/YYYY"
    @ColumnInfo(name = "end_year")
    public String endYear = "N/A"; // "YYYY"
    @ColumnInfo(name = "end_month")
    public String endMonth = "N/A"; // "MM"
    @ColumnInfo(name = "end_day")
    public String endDay = "N/A"; // "DD"


//    @ColumnInfo(name = "start_time")
//    public String startTime = "N/A"; // "MM/DD/YYYY"
//    @ColumnInfo(name = "end_time")
//    public String endTime = "N/A"; // "MM/DD/YYYY"

    // ONLY for Reoccurring
    // Duration: RFC5545 format -> "PT1H" = one hour long; "P2W" = 2 weeks
//    @ColumnInfo(name = "duration")
//    public String duration = "N/A";
    // RRule: (examples) FREQ=WEEKLY; COUNT=10l WKST=SU
//    @ColumnInfo(name = "r_rule")
//    public String rRule = "N/A"; // TODO ??? No Idea how to format this....


    // Needed Info from plant database:
//    @ColumnInfo(name = "days_to_harvest")
//    public String daysToHarvest = "N/A"

    // AddPlant4
//    @ColumnInfo(name = "num_watering_times_per_week")
//    public String numWateringTimesPerWeek = "N/A"; // # of occurrences

    // AddPlant5
//    @ColumnInfo(name = "num_weeding_times_per_week")
//    public String numWeedingTimesPerWeek = "N/A"; // # of occurrences
}

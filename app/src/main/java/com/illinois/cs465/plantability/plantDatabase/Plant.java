package com.illinois.cs465.plantability.plantDatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Plant {
    @PrimaryKey(autoGenerate = true)
    int id;

    // AddPlant1
    @ColumnInfo(name = "plant_name")
    public String plantName;
    @ColumnInfo(name = "plant_image")
    public String plantImage;
    // AddPlant2
    @ColumnInfo(name = "seed_depth")
    public String seedDepth = "N/A";
    @ColumnInfo(name = "seed_spacing")
    public String seedSpacing = "N/A";
    @ColumnInfo(name = "row_spacing")
    public String rowSpacing = "N/A";
    @ColumnInfo(name = "plants_per_square_foot")
    public String plantsPerSquareFoot = "N/A";

    // AddPlant3
    @ColumnInfo(name = "start_date")
    public String startDate = "N/A"; // "MM/DD/YYYY"
    @ColumnInfo(name = "days_to_harvest")
    public String daysToHarvest = "N/A";

    // AddPlant4
    @ColumnInfo(name = "sun_level")
    public String sunLevel = "N/A"; // "shade", "partial", "full"
    @ColumnInfo(name = "num_watering_times_per_week")
    public String numWateringTimesPerWeek = "N/A"; // # of occurrences
    @ColumnInfo(name = "amount_water_per_week")
    public String amountWaterPerWeek = "N/A"; // By volume

    // AddPlant5
    @ColumnInfo(name = "num_weeding_times_per_week")
    public String numWeedingTimesPerWeek = "N/A"; // # of occurrences
    @ColumnInfo(name = "plant_notes")
    public String plantNotes = "N/A"; // Additional notes for this plant
}

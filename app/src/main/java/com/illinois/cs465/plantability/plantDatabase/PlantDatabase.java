package com.illinois.cs465.plantability.plantDatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Plant.class}, version = 4, exportSchema = false)
public abstract class PlantDatabase extends RoomDatabase {
    public abstract PlantDao plantDao();

    private static PlantDatabase INSTANCE;

    public static PlantDatabase getPlantDatabaseInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), PlantDatabase.class, "PLANT_DATABASE")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}

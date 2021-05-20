package com.illinois.cs465.plantability.discoverDatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {DiscoverPlant.class}, version = 2, exportSchema = false)
public abstract class DiscoverPlantDatabase extends RoomDatabase {
    public abstract DiscoverPlantDao discoverPlantDao();

    private static DiscoverPlantDatabase INSTANCE;

    public static DiscoverPlantDatabase getDiscoverDatabaseInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DiscoverPlantDatabase.class, "DISCOVER_DATABASE")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}

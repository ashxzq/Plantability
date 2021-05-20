package com.illinois.cs465.plantability.plotDatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Plot.class}, version = 5, exportSchema = false)
public abstract class PlotDatabase extends RoomDatabase {
    public abstract PlotDao plotDao();

    private static PlotDatabase INSTANCE;

    public static PlotDatabase getPlotDatabaseInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), PlotDatabase.class, "PLOT_DATABASE")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}

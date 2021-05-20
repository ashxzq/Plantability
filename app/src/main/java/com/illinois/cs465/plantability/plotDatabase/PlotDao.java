package com.illinois.cs465.plantability.plotDatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PlotDao {
    @Query("SELECT * FROM Plot")
    List<Plot> getAllPlots();

    @Query("DELETE FROM Plot")
    void delete();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPlot(Plot...plots);

    @Delete
    void deletePlot(Plot plot);
}

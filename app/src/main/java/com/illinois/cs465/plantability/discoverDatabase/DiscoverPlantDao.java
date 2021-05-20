package com.illinois.cs465.plantability.discoverDatabase;

import com.illinois.cs465.plantability.plantDatabase.Plant;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface DiscoverPlantDao {
    @Query("SELECT * FROM DiscoverPlant")
    List<DiscoverPlant> getAllPlants();

    @Query("DELETE FROM DiscoverPlant")
    void delete();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPlant(DiscoverPlant...plants);

    @Delete
    void deletePlant(DiscoverPlant plant);

}
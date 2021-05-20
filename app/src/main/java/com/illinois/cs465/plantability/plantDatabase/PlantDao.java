package com.illinois.cs465.plantability.plantDatabase;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface PlantDao {
    @Query("SELECT * FROM Plant")
    List<Plant> getAllPlants();

    @Query("DELETE FROM Plant")
    void delete();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPlant(Plant...plants);

    @Delete
    void deletePlant(Plant plant);

}
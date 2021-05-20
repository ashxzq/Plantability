package com.illinois.cs465.plantability.notificationDatabase;

import com.illinois.cs465.plantability.notificationDatabase.Notification;
import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface NotificationDao {
    @Query("SELECT * FROM Notification")
    List<Notification> getAllNotifications();

    @Query("DELETE FROM Notification")
    void delete();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNotification(Notification...notifications);

    @Delete
    void deleteNotification(Notification notification);
}

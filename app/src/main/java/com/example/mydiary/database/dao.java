package com.example.mydiary.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import static androidx.room.OnConflictStrategy.REPLACE;

import com.example.mydiary.modules.dairy;

import java.util.List;

@Dao
public interface dao {

    @Insert(onConflict = REPLACE)
    Void insert(dairy dairy);


    @Query(value = "SELECT * FROM dairy ORDER BY title DESC")
    List<dairy> getAll();

    @Query("UPDATE dairy SET title = :title,dairy=:dairy WHERE ID=:id")
    void update(int id, String title, String dairy);

    @Delete
    void delete(dairy dairy);
}


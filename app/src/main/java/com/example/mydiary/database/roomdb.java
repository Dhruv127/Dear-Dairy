package com.example.mydiary.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mydiary.modules.dairy;

@Database(entities = dairy.class,version = 1,exportSchema = false)
public abstract class roomdb extends RoomDatabase {
    private static roomdb database;
    private static String DATABASE_NAME="MY_DIARY_APP";
    public synchronized  static roomdb getInstance(Context context)
    {
        if (database==null) {
            database = Room.databaseBuilder(context.getApplicationContext(), roomdb.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return database;

    }
    public abstract dao dao();
}


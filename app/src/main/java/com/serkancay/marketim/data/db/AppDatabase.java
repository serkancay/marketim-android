package com.serkancay.marketim.data.db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * Created by S.Serkan Cay on 25.07.2019
 */

//@Database(entities = {}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase sInstance;

    public static AppDatabase getDatabase(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "marketim")
                    .allowMainThreadQueries()
                    .build();
        }
        return sInstance;
    }

    public static AppDatabase getMemoryDatabase(Context context) {
        if (sInstance == null) {
            sInstance = Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class)
                    .allowMainThreadQueries()
                    .build();
        }
        return sInstance;
    }

    public static void destroyInstance() {
        sInstance = null;
    }

}

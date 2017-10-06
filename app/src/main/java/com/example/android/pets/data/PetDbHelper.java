package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.pets.data.PetContract.PetEntry;



/**
 * Created by GOURAV on 20-04-2017.
 */

public class PetDbHelper extends SQLiteOpenHelper {

    /** Name of the database file */
    private static final String DATABASE_NAME = "shelter.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Constructs a new instance of {@link PetDbHelper}.
     *
     * @param context of the app
     */
    public PetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_PETS_TABLE =  "CREATE TABLE " + PetEntry.TABLE_NAME + " (" +
                PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                PetEntry.COLUMN_PET_NAME + " TEXT NOT_NULL, "+
                PetEntry.COLUMN_PET_BREED + " TEXT, "+
                PetEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL, "+
                PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0);";
        // Execute the SQL statement
        db.execSQL(SQL_CREATE_PETS_TABLE);
    }

    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

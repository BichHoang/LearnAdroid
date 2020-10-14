package com.example.learnandroid.databases;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Bich Hoang on 10/5/2020.
 */
public class DBconfig extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "nihongo.db";
    private static final int DATABASE_VERSION = 1;

    public DBconfig(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}

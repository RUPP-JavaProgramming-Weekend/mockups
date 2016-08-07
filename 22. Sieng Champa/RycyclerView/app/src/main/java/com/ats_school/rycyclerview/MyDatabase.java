package com.ats_school.rycyclerview;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by macbookpro on 10/7/16.
 */
public class MyDatabase extends SQLiteAssetHelper {


    private static final String DATABASE_NAME = "dictionary3.db";
    private static final int DATABASE_VERSION = 1;

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


}

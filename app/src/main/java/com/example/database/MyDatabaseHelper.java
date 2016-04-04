package com.example.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/3/20.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper{

    private static final String TAG = "MyDatabaseHelper";
    private static final String CREATE_BOOK = "create table Book ("+
            "id integer primary key autoincrement, "+
            "author text, "+"price real, "+"pages integer, "+
            "name text, "+
            "category_id integer)";
    private static final String CREATE_CATEGORY = "create table Category (" +
            "id integer primary key autoincrement, "+
            "category_name text, "+
            "category_code integer)";
    private Context mContext;
    /**
     * Create a helper object to create, open, and/or manage a database.
     * This method always returns very quickly.  The database is not actually
     * created or opened until one of {@link #getWritableDatabase} or
     * {@link #getReadableDatabase} is called.
     *
     * @param context to use to open or create the database
     * @param name    of the database file, or null for an in-memory database
     * @param factory to use for creating cursor objects, or null for the default
     * @param version number of the database (starting at 1); if the database is older,
     *                {@link #onUpgrade} will be used to upgrade the database; if the database is
     *                newer, {@link #onDowngrade} will be used to downgrade the database
     */
    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
        Log.d(TAG,"MyDatabaseHelper");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG,"onCreate");
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);
//        Toast.makeText(mContext,"Create succeeded",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG,"onUpgrade oldVersion"+oldVersion);
//        db.execSQL("drop table if exists Book");
//        db.execSQL("drop table if exists Category");
        switch (oldVersion){
            case 1:
                db.execSQL(CREATE_CATEGORY);
            case 2:
                db.execSQL("alter table Book add column category_id integer");
            default:
                    break;
        }
    }
}

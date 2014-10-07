package com.example.MessageBao.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 麟 on 2014/10/5.
 */
public class MessageBaoOpenHelper extends SQLiteOpenHelper {

    public static final String CREATE_SMS_TABLE = "create table " +
            DBConstants.DB_TABLE_SMS + " (" +
            "id integer primary key autoincrement," +
            DBConstants.DB_SMS_FROM + " text, " +
            DBConstants.DB_SMS_CONTENT + " text," +
            DBConstants.DB_SMS_DATE + " text)";

    public MessageBaoOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_SMS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+DBConstants.DB_TABLE_SMS);
        onCreate(db);
    }
}

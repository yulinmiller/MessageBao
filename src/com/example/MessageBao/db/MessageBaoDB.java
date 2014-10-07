package com.example.MessageBao.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.telephony.SmsMessage;
import com.example.MessageBao.model.Sms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 麟 on 2014/10/5.
 */
public class MessageBaoDB {
        public static final int VERSION = 3;
    private static MessageBaoDB messageBaoDB;
    private SQLiteDatabase db;

    private MessageBaoDB(Context context) {
        MessageBaoOpenHelper dbHelper = new MessageBaoOpenHelper(context,DBConstants.DB_NAME,null,VERSION);
        db=dbHelper.getWritableDatabase();
    }

    public synchronized static MessageBaoDB getInstance(Context context){
        if(messageBaoDB == null)
            messageBaoDB = new MessageBaoDB(context);
        return messageBaoDB;
    }

    public void saveMessage(Sms sms){
        if(sms!=null){
            ContentValues values = new ContentValues();
            values.put(DBConstants.DB_SMS_FROM,sms.getFromWhom());
            values.put(DBConstants.DB_SMS_CONTENT,sms.getContent());
            values.put(DBConstants.DB_SMS_DATE,sms.getDate());
            db.insert(DBConstants.DB_TABLE_SMS,null,values);
        }
    }
    public int deleteMessage(Sms sms){
        String[] arg = {String.valueOf(sms.getId())};
        return db.delete(DBConstants.DB_TABLE_SMS,"id=?",arg);
    }

    public List<Sms> loadSms(){
        List<Sms> list = new ArrayList<Sms>();
        Cursor cursor = db.query(DBConstants.DB_TABLE_SMS,null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                Sms sms = new Sms();
                sms.setId(cursor.getInt(cursor.getColumnIndex("id")));
                sms.setFromWhom(cursor.getString(cursor.getColumnIndex(DBConstants.DB_SMS_FROM)));
                sms.setContent(cursor.getString(cursor.getColumnIndex(DBConstants.DB_SMS_CONTENT)));
                sms.setDate(cursor.getString(cursor.getColumnIndex(DBConstants.DB_SMS_DATE)));
                list.add(sms);
            }
            while (cursor.moveToNext());
        }
        return list;
    }
}

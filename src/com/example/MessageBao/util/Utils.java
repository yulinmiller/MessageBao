package com.example.MessageBao.util;

import com.example.MessageBao.db.MessageBaoDB;
import com.example.MessageBao.model.Sms;

import java.text.SimpleDateFormat;

/**
 * Created by 麟 on 2014/10/6.
 */
public class Utils {
    public static void handleReceivedSms(String address,String fullMessage,MessageBaoDB messageBaoDB){
        if(messageBaoDB!=null) {
            SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String date = sDateFormat.format(new java.util.Date());
            Sms sms = new Sms();
            sms.setFromWhom(address);
            sms.setContent(fullMessage);
            sms.setDate(date);
            messageBaoDB.saveMessage(sms);
        }
    }
}

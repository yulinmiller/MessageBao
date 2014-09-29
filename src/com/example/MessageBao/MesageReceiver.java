package com.example.MessageBao;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

import java.sql.*;

/**
 * Created by 麟 on 2014/9/26.
 */
public class MesageReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        Object[] pdus = (Object[]) bundle.get("pdus");
        SmsMessage[] messages = new SmsMessage[pdus.length];
        for(int i =0; i <messages.length; ++i){
            messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
        }
        String address = messages[0].getOriginatingAddress();
        String fullMessage = "";
        for(SmsMessage message : messages){
            fullMessage += message.getMessageBody();
        }

        try {
            Connection conn = null;
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@yulinmiller.vicp.cc:1521:XXB", "lliyu", "Oracle123");
            Statement statement = conn.createStatement();
            String sqlstate = "insert into test_table (name,message) values("+address+","+fullMessage+")";
            ResultSet resultSet = statement.executeQuery(sqlstate);
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

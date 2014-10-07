package com.example.MessageBao.activity;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import com.example.MessageBao.receiver.MessageReceiver;
import com.example.MessageBao.R;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private MessageReceiver messageReceiver;
    private IntentFilter intentFilter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        messageReceiver = new MessageReceiver();
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(messageReceiver,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(messageReceiver);
    }
}

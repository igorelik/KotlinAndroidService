package com.example.igorg.kpollingservice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

public class AutoStart: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
//        var intent = Intent(context, PollingService::class.java)
//        if (context != null) {
//            context.startService(intent)
//        }
        var intent = Intent(context, MainActivity::class.java)
        if (context != null) {
            context.startActivity(intent)
        }
        Log.i("AutoStart", "started")
    }

}
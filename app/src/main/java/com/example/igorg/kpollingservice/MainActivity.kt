package com.example.igorg.kpollingservice

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)
        if(!PollingService.IsRunning)
        {
            var intent = Intent(this, PollingService::class.java)
            this.startService(intent)
        }
        finish()
    }
}

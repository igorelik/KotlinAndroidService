package com.example.igorg.kpollingservice

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.microsoft.appcenter.crashes.Crashes
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.AppCenter



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)
        AppCenter.start(application, "3fd20389-8835-43de-857b-4aa94895428e",
                Analytics::class.java, Crashes::class.java)
        if(!PollingService.IsRunning)
        {
            var intent = Intent(this, PollingService::class.java)
            this.startService(intent)
        }
        finish()
    }
}

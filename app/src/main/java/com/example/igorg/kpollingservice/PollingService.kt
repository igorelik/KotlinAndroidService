package com.example.igorg.kpollingservice

import android.app.Service
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import java.util.*
import android.R.string.cancel



public class PollingService: Service(){
    companion object {
        var IsRunning:Boolean = false
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null;
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Polling Service Stopped", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onDestroy")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        var res = super.onStartCommand(intent, flags, startId)
        IsRunning = true
//
//        var intents = Intent(baseContext,MainActivity::class.java);
//        startActivity(intents)
        Toast.makeText(this, "Polling Service Started", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onStartCommand")
        startTimer()
        return res;
    }

    var counter = 0
    private var timer: Timer? = null
    private var timerTask: TimerTask? = null
    var oldTime: Long = 0
    fun startTimer() {
        //set a new Timer
        timer = Timer()

        //initialize the TimerTask's job
        initializeTimerTask()

        //schedule the timer, to wake up every 1 second
        this.timer!!.schedule(timerTask, 1000, 10000)
    }

    fun initializeTimerTask() {
        timerTask = object : TimerTask() {
            override fun run() {
                Log.i("in timer", "in timer ++++  " + counter++)
            }
        }
    }

    fun stoptimertask() {
        //stop the timer, if it's not already null
        if (timer != null) {
            timer!!.cancel()
            timer = null
        }
    }
}
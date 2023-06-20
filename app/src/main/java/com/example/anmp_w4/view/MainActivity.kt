package com.example.anmp_w4.view

import android.app.Activity
import android.app.Notification
import android.app.NotificationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.android.volley.Request.Method.POST
//import com.example.anmp_w4.Manifest
import com.example.anmp_w4.R
import com.example.anmp_w4.util.createNotificationChannel

class MainActivity : AppCompatActivity() {

    init{
        instance = this
    }

    companion object {
        private var instance:MainActivity ?=null

        fun showNotif(title:String, content:String, icon:Int){
            val channelId = "{$instance?.packageName}${instance?.getString(R.string.app_name)}"

            val builder = NotificationCompat.Builder(instance!!.applicationContext, channelId).apply {
                setSmallIcon(icon)
                setContentTitle(title)
                setContentText(content)
                setStyle(NotificationCompat.BigTextStyle())
                priority = NotificationCompat.PRIORITY_DEFAULT
                setAutoCancel(true)
            }

//            if (ActivityCompat.checkSelfPermission(instance!!.applicationContext, Manifest.permission.POST))

            val manager = NotificationManagerCompat.from(instance!!.applicationContext)
            manager.notify(1001, builder.build())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createNotificationChannel(this, NotificationManagerCompat.IMPORTANCE_DEFAULT, false, getString(R.string.app_name), "App notification channel")



    }
}
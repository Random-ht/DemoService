package com.ht.search

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

/******
 * startService
 */
class MainActivity : AppCompatActivity() {

    var service: Intent? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        service = Intent(this, MyService::class.java)
        service?.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);


        start.setOnClickListener {
            startService(service)
        }

        stop.setOnClickListener {
            stopService(service)
        }
    }
}

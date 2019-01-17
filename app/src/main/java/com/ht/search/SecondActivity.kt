package com.ht.search

import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

/****
 * BindService
 */
class SecondActivity : AppCompatActivity() {

    var binder: MyService2.MyBinder? = null

    private var conn: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            Log.i("----------", "执行的是onServiceConnected()方法")
            binder = service as MyService2.MyBinder?
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            Log.i("----------", "执行的是onServiceDisconnected()方法")
        }
    }

    var service: Intent? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        service = Intent(this, MyService2::class.java)

        start.setOnClickListener {
            bindService(service, conn, Service.BIND_AUTO_CREATE)
        }

        stop.setOnClickListener {
            unbindService(conn)
        }

        count.setOnClickListener {
            Toast.makeText(this@SecondActivity, (binder?.count1).toString(), Toast.LENGTH_SHORT).show()
        }
    }
}

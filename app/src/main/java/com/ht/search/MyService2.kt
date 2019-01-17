package com.ht.search

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log


/**
 * Created by hutao on 2019/1/17.
 */
class MyService2 : Service() {

    var count: Int = 1;
    var quit: Boolean = false

    override fun onBind(intent: Intent?): IBinder {
        Log.i("----------", "执行的是onBind()方法")
        return binder
    }

    var binder: MyBinder = MyBinder()

    inner class MyBinder : Binder() {
        val count1: Int
            get() = count

//        上下等价
//        public Int getCount(){
//            return count;
//        }
    }

    override fun onCreate() {
        Log.i("----------", "执行的是onCreate()方法")
        super.onCreate()
        Thread(object : Runnable {
            override fun run() {
                while (!quit) {
                    try {
                        Thread.sleep(1000)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                    count++
                }
            }
        }).start()
    }

//    override fun onStart(intent: Intent?, startId: Int) {
//        Log.i("----------", "执行的是onStart()方法")
//        super.onStart(intent, startId)
//    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i("----------", "执行的是onStartCommand()方法")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        Log.i("----------", "执行的是onDestroy()方法")
        super.onDestroy()
    }

    override fun onRebind(intent: Intent?) {
        Log.i("----------", "执行的是onRebind()方法")
        super.onRebind(intent)
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.i("----------", "执行的是onUnbind()方法")
        return super.onUnbind(intent)
    }
}